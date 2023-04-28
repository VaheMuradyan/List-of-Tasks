import java.util.*;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

    }
}

class User{
    private String Name;
    private String contInfo;
    private LinkedList<Post> myPosts = new LinkedList<>();
    User(String name, String contInfo){
        this.Name = name;
        this.contInfo = contInfo;
    }

    public void creatPost(String bovand){
        Post ob = new Post(this,bovand);
        myPosts.add(ob);
    }

    public void vwePost(int i){
        System.out.println(myPosts.get(i).getBovand());
    }

    public void addCommenToPost(int indexPost, Comment comment){
        myPosts.get(indexPost).addtComment(comment);
    }
}

class Post{
    User ob;
    private String bovand;
    LocalDate localDate;
    private LinkedList<Comment> comments = new LinkedList<>();
    Post(User ob,String bovand){
        this.ob = ob;
        this.bovand = bovand;
        localDate = LocalDate.now();
    }

    public String getBovand(){
        return bovand;
    }

    public void addtComment(Comment ob){
        comments.add(ob);
    }
}

class Comment{
    Post post;
    User user;
    private String bovand;

    Comment(Post post, User user, String bovand){
        this.post = post;
        this.user = user;
        this.bovand = bovand;
    }
}


