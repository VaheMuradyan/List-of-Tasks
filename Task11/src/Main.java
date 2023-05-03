import java.util.*;
public class Main {
    public static void main(String[] args) {
        Developer vahe = new Developer("Vahe","ak");
        vahe.creatGame("voyna","strategia","ank");
        Publisher ando = new Publisher("Ando","agarak");
        Game ob = ando.releasGame("voyna");
        System.out.println(ob.getName() + " " + ob.getJanr() + " " + ob.getDate());
    }
}

abstract class allGame{
    public static LinkedList<Game> Games = new LinkedList<>();

    abstract void addGame(Game ... arr);
}
class Game extends allGame{
    private final String name;
    private final String janr;
    private final String date;
        public static class Builder{
            private final String name;
            private final String janr;
            private String date = "Non";
            Builder(String name, String janr){
                this.name = name;
                this.janr = janr;
            }

            public Builder date(String valu){
                date = valu;
                return this;
            }

            public Game build(){
                return new Game(this);
            }
        }
    private Game(Builder builder){
            this.name = builder.name;
            this.janr = builder.janr;
            this.date = builder.date;
    }

    public String getName() {
        return name;
    }

    public String getJanr() {
        return janr;
    }

    public String getDate() {
        return date;
    }

    public void addGame(Game ... arr){
            for(int i = 0; i < arr.length; i++){
                Games.add(arr[i]);
            }
    }
}

class Developer{
    private final String name;
    private String contInfo;
    Developer(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }

    Developer(String name){
        this(name,"Non");
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }

    public void setContInfo(String contInfo) {
        this.contInfo = contInfo;
    }

    public void creatGame(String name, String janr, String date1){
        Game ob = new Game.Builder(name,janr).date(date1).build();
        ob.addGame(ob);
        ob = null;
    }
    public void creatGame(String name, String janr){
        Game ob = new Game.Builder(name,janr).build();
        ob.addGame(ob);
        ob = null;
    }
}

class Publisher{
    private final String name;
    private String contInfo;
    Publisher(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }

    Publisher(String name){
        this(name,"Non");
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }

    public void setContInfo(String contInfo) {
        this.contInfo = contInfo;
    }

    public Game releasGame(String name){
        Game ob1 = null;
        for(Game ob : Game.Games){
            if(ob.getName().equals(name)){
                ob1 = ob;
            }
        }
        return ob1;
    }
}