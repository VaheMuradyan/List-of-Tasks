import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {


    }
}
interface fiction{
    void addFicionBook();
}
interface nonFiction{
    void addNonFictionBook();
}

abstract class AllBooks {
    public static final LinkedList<fictionBook> FICTION_BOOKS = new LinkedList<>();
    public static final LinkedList<nonFictionBook> NON_FICTIONS_BOOKS = new LinkedList<>();

    abstract String getName();

    public static void showAllBooks() {
        System.out.println("Fiction books");
        for (fictionBook ob : FICTION_BOOKS) {
            System.out.println(ob.getName() + " " + ob.getAuthor() + " " + ob.getDate());
        }
        System.out.println("Non Fiction books");
        for (nonFictionBook ob : NON_FICTIONS_BOOKS) {
            System.out.println(ob.getName() + " " + ob.getAuthor() + " " + ob.getDate());
        }
    }
}
class fictionBook extends AllBooks implements fiction{
    private final String name;
    private final String author;
    private final String date;

    public fictionBook(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    @Override
    public void addFicionBook() {
        FICTION_BOOKS.add(this);
    }
}

class nonFictionBook extends AllBooks implements nonFiction{
    private final String name;
    private final String author;
    private final String date;

    public nonFictionBook(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    @Override
    public void addNonFictionBook() {
        NON_FICTIONS_BOOKS.add(this);
    }
}
class Borrower{
    private final String name;
    private final String contInfo;
    private final LinkedList<String> readBooks = new LinkedList<>();
    private LinkedList<AllBooks> myBooks = new LinkedList<>();

    public Borrower(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }
    public void getBook(AllBooks ob){
        myBooks.add(ob);
        readBooks.add(ob.getName());

    }
    public AllBooks returnBook(AllBooks ob){
        AllBooks ob1 = null;
        for(int i = 0; i < myBooks.size(); i++){
            if(myBooks.get(i).getName().equals(ob.getName())){
                ob1 = myBooks.get(i);
                myBooks.remove(i);
            }
        }
        return ob1;
    }
    public void showMyBooks(){
        for(AllBooks ob : myBooks){
            System.out.println(ob.getName());
        }
    }
}

class Bibrarian{
    private final String name;
    private final String contInfo;

    public Bibrarian(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }

    public void givBook(Borrower borrower,AllBooks book){
        borrower.getBook(book);
    }
}