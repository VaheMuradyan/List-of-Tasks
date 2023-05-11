import java.util.*;
public class Main {
    public static void main(String[] args) {
        
    }
}
abstract class Conversation{
    abstract LinkedList<String> getConvHistory();
    abstract LinkedList<User> getUsers();
}

class ChatConversation extends Conversation{
    private final LinkedList<User> users = new LinkedList<>();
    private LinkedList<String> convHistory = new LinkedList<>();
    ChatConversation(User ob1, User ob2){
        users.add(ob1);
        users.add(ob2);
    }
    ChatConversation() { }

    public LinkedList<String> getConvHistory() {
        return convHistory;
    }

    public LinkedList<User> getUsers() {
        return users;
    }
}
class GroupConversation extends ChatConversation{
    private LinkedList<User> users = new LinkedList<>();
    private LinkedList<String> convHistory = new LinkedList<>();

    private GroupConversation() { }
    GroupConversation(User ob1, User ob2){
        super(ob1,ob2);
    }
    GroupConversation(User ... arr){
        for(User ob : arr){
            users.add(ob);
        }
    }

    public LinkedList<String> getConvHistory() {
        return convHistory;
    }

    public LinkedList<User> getUsers() {
        return users;
    }
}

class User{
    private LinkedList<Message> messages = new LinkedList<>();
    private final String name;
    private final String contInfo;

    public User(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }
    public Conversation CreatGroupConversation(User ... arr){
        Conversation group = new GroupConversation(arr);
        return group;
    }
    public Conversation CreatGroupConversation(User num1, User num2){
        Conversation group = new GroupConversation(num1,num2);
        return group;
    }
    public Conversation CreatChatConversation(User num1, User num2){
        Conversation chat = new ChatConversation(num1,num2);
        return chat;
    }

    public void wrightMultimediaMessage(User user,Conversation conversation,String multimedia){
        Message message = new MultimediaMessage(user,conversation,multimedia);
        user.readMessage(message);
    }

    public void wrightTextMessage(User user,Conversation conversation,String text){
        Message message = new TextMessage(user,conversation,text);

        user.readMessage(message);

    }

    public void readMessage(Message val){
        System.out.println(val.getMassegeContent());
        messages.add(val);
    }
    public void showMessages(){
        for(Message ob : messages){
            System.out.print(ob.getMassegeContent() + " ");
        }
    }
}


abstract class Message{
    abstract User getUser();
    abstract Conversation getConversation();
    abstract String getMassegeContent();
}

class TextMessage extends Message{
    private final User user;
    private final Conversation conversation;
    private final String massegeContent;

    public TextMessage(User user, Conversation conversation, String massegeContent) {
        this.user = user;
        this.conversation = conversation;
        this.massegeContent = massegeContent;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public String getMassegeContent() {
        return massegeContent;
    }
}

class MultimediaMessage extends Message{
    private final User user;
    private final Conversation conversation;
    private final String massegeContent;

    public MultimediaMessage(User user, Conversation conversation, String massegeContent) {
        this.user = user;
        this.conversation = conversation;
        this.massegeContent = massegeContent;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public String getMassegeContent() {
        return massegeContent;
    }
}


