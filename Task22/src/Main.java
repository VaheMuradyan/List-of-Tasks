import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User vahe = new User("Vahe","non");
        vahe.douPost("ank");
    }
}

class User{
    final private LinkedList<String> masage = new LinkedList<>();
    final private LinkedList<Post> myPosts = new LinkedList<>();
    final private HashMap<Post,Comment> PostComments = new HashMap<>();
    final private LinkedList<Comment> myComments = new LinkedList<>();
    private final String name;
    private final String contInfo;

    public User(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }
    public void douPost(String postContent){
        Post post = new Post(this,postContent);
        myPosts.add(post);
    }

    public Post sharePost(String postContent) {
        Post ob = null;
        for(int i = 0; i < myPosts.size(); i++){
            if(myPosts.get(i).getPostContent().equals(postContent)){
                ob = myPosts.get(i);
            }
        }
        return ob;
    }

    public void addComment(Post post, Comment comment){
        myComments.add(comment);
        PostComments.put(post,comment);
    }



}

class Post{
    private final User user;
    private final String postContent;
    private LocalDate postTime = LocalDate.now();

    public Post(User user, String postContent) {
        this.user = user;
        this.postContent = postContent;
    }

    public User getUser() {
        return user;
    }

    public String getPostContent() {
        return postContent;
    }

    public LocalDate getPostTime() {
        return postTime;
    }
}

class Comment{
    private final User user;
    private final String coomentContent;
    private LocalDate commentTime = LocalDate.now();

    public Comment(User user, String coomentContent) {
        this.user = user;
        this.coomentContent = coomentContent;
    }

    public User getUser() {
        return user;
    }

    public String getCoomentContent() {
        return coomentContent;
    }

    public LocalDate getCommentTime() {
        return commentTime;
    }
}

