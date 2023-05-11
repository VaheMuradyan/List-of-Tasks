import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Move{
    private final String name;
    private final String genre;
    private final String length;

    public Move(String name, String genre, String length) {
        this.name = name;
        this.genre = genre;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getLength() {
        return length;
    }
}

class Theatre{
    private LinkedList<Move> moves = new LinkedList<>();
    private final String location;
    private final int seatingCapacity;
    Theatre(String location, int seatingCapacity){
        this.seatingCapacity = seatingCapacity;
        this.location = location;
    }
    public void addMove(Move ob){
        moves.add(ob);
    }

    public LinkedList<Move> getMoves() {
        return moves;
    }
    public boolean arThisMove(String name){
        boolean yes = false;
        for(Move ob : moves){
            if(ob.getName().equals(name)){
                yes = true;
            }
        }
        return yes;
    }
}

class Showtime{
    final private Move move;
    final private Theatre theatre;
    final private String dateOfShowing;

    public Showtime(Move move, Theatre theatre, String dateOfShowing) {
        this.move = move;
        this.theatre = theatre;
        this.dateOfShowing = dateOfShowing;
    }

    public Move getMove() {
        return move;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public String getDateOfShowing() {
        return dateOfShowing;
    }

}

class Customer{
    private final String name;
    Customer(String name){
        this.name = name;
    }

    public void whotchMove(Theatre theatre, Move move){
        
    }
}