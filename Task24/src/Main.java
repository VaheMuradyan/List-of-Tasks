import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

    }
}
abstract class Consoles{
    abstract void addGame(Game ... bo);
    abstract Game getGame(String x);
}
class Xbox extends Consoles{
    private static final Xbox Instance = new Xbox();
    private final LinkedList<Game> games = new LinkedList<>();
    private Xbox(){

    }

    public void addGame(Game ... arr){
        for(int i = 0; i < arr.length; i++){
            games.add(arr[i]);
        }
    }

    public Game getGame(String name){
        Game ob = null;
        for(Game val : games){
            if(val.getName().equals(name))
                ob = val;
        }
        return ob;
    }

    public static Xbox getInstance(){
        return Instance;
    }

}


class PlaySation extends Consoles{
    private static final PlaySation Instance = new PlaySation();
    private final LinkedList<Game> games = new LinkedList<>();
    private PlaySation(){

    }

    public Game getGame(String name){
        Game ob = null;
        for(Game val : games){
            if(val.getName().equals(name))
                ob = val;
        }
        return ob;
    }

    public void addGame(Game ... arr){
        for(Game val : arr){
            games.add(val);
        }
    }

    public static PlaySation getInstance(){
        return Instance;
    }

}
class Player{
    final private String name;
    final private String contInfo;
    Player(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }
    public void Play(Console console, Game game){
        console.getConsole().addGame(game);
        System.out.println("play " + game.getName());
    }

}

class Console{
    Consoles console;
    Console(Consoles console){
        this.console = console;
    }

    public Consoles getConsole() {
        return console;
    }
}




abstract class Game{
    abstract String getName();
}

class SportGame extends Game{
    private final LocalDate genTime = LocalDate.now();
    private final String name;
    SportGame(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getGenTime() {
        return genTime;
    }
}

class AdventureGame extends Game{
    private final LocalDate genTime = LocalDate.now();
    private final String name;
    AdventureGame(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getGenTime() {
        return genTime;
    }
}