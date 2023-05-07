import java.util.*;
public class Main {
    public static void main(String[] args) {
        Artist eminem = new Artist("Eminem","edem");
       Song mek = new PopSong("not","1",eminem);
       Song erk = new RockSong("chka","2",eminem);
       User Vahe = new User("Vahe","ank");
       Vahe.sherchSong("chka");

    }
}

abstract class Song{
        public static final LinkedList<Song> AllSongs = new LinkedList<>();
        abstract public String getName();
        abstract public Artist getArtist();
        protected void addSongToAllSongs(Song ob){
            AllSongs.add(ob);
        }
}
class RockSong extends Song{
    private final String name;
    private final String duratoin;
    private final Artist artist;

    public RockSong(String name, String duratoin, Artist artist) {
        this.name = name;
        this.duratoin = duratoin;
        this.artist = artist;
        addSongToAllSongs(this);
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

}
class PopSong extends Song{
    private final String name;
    private final String duratoin;
    private final Artist artist;

    public PopSong(String name, String duratoin, Artist artist) {
        this.name = name;
        this.duratoin = duratoin;
        this.artist = artist;
        addSongToAllSongs(this);
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

}


class Artist{
    private final String name;
    private final String contInfo;
    Artist(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }
    public String getName(){
        return name;
    }

}

class User{
    private final String name;
    private final String contInfo;
    private final LinkedList<Artist> myArtists = new LinkedList<>();
    private final LinkedList<Song> mySongs = new LinkedList<>();
    User(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }
    public void sherchSong(String name){
        for(Song ob : Song.AllSongs){
            if(ob.getName().equals(name)){
                System.out.println(ob.getName() + " " + ob.getArtist().getName());
            }
        }
    }

    public void creatPlaylist(Song ... arr){
        for(int i = 0; i < arr.length; i++){
            mySongs.add(arr[i]);
        }
    }

    public void addFavoritArtist(Artist ob){
        myArtists.add(ob);
    }

}