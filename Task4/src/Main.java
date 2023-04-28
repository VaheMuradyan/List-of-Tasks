import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Albom kamikadze = new Albom("kamikadze","Eminem","3/09/2018");
    }
}

class Song{
    public String name;
    public String artistName;
    public double erk;

    Song(String name, String artistName, double erk) {
        this.name = name;
        this.artistName = artistName;
        this.erk = erk;
    }


}

class Albom{
    private String albomName;
    private String Artist;
    private String date;
    private LinkedList<Song> albom = new LinkedList<>();
    public LinkedList<Song> listeningSongs = new LinkedList<>();

    Albom(String albomName, String Artist, String date) {
        this.albomName = albomName;
        this.Artist = Artist;
        this.date = date;
    }

    public void setAlbom(LinkedList<Song> albom) {
        this.albom = albom;
    }

    public void setAlbom(Song ... v){
        for(Song song : v){
            albom.add(song);
        }
    }

    public void play(String songName){
        for(int i = 0; i < albom.size(); i++){
            if(albom.get(i).name.equals(songName)){
                System.out.println("Play: " + albom.get(i).name + " " + albom.get(i).artistName);
                listeningSongs.add(albom.get(i));

            }
        }
    }

    public void serchSong(String songName){
        for(int i = 0; i < albom.size(); i++){
            if(albom.get(i).name.equals(songName)){
                System.out.println("Play: " + albom.get(i).name + " " + albom.get(i).artistName);
            }
        }
    }

    public void showAlbom(){
        for(Song ob : albom){
            System.out.println(ob.artistName + " " + ob.name + " " + ob.erk);
        }
    }


}

class PlayList{
    private String name;
    private LinkedList<Song> playlist = new LinkedList<>();
    private LinkedList<Song> listeningSongs = new LinkedList<>();
    PlayList(String name){
        this.name = name;
    }
    public void addSongPlaylist(Song ob){
        playlist.add(ob);
    }
    public void play(String songName){
        for(int i = 0; i < playlist.size(); i++){
            if(playlist.get(i).name.equals(songName)){
                System.out.println("Play: " + playlist.get(i).name + " " + playlist.get(i).artistName);
                listeningSongs.add(playlist.get(i));
            }
        }
    }

    public void serchSong(String songName){
        for(int i = 0; i < playlist.size(); i++){
            if(playlist.get(i).name.equals(songName)){
                System.out.println("Play: " + playlist.get(i).name + " " + playlist.get(i).artistName);
            }
        }
    }

    public void showPlaylist(){
        for(Song ob : playlist){
            System.out.println(ob.artistName + " " + ob.name + " " + ob.erk);
        }
    }
}