import java.util.*;
public class Main {
    public static void main(String[] args) {
      StandartRoom room1 = new StandartRoom("mek","ank",1200);
      DeluxRoom room2 = new DeluxRoom("erk","ank",3000);
      Guest Vahe = new Guest("Vahe","hamar");
      Reserv ham1 = new Reserv(Vahe,"ank",room1);
      ham1.reservRoom();
        System.out.println(Vahe.retRoom());
      Reserv ham2 = new Reserv(Vahe,"ank",room2);
      ham2.reservRoom();
      Vahe.showReservdRooms();
      System.out.println();
      room1.showStandartRooms();
      room1.showDeluxRums();
    }
}
class Room{
    public static final LinkedList<StandartRoom> STANDART_ROOMS = new LinkedList<>();
    public static final LinkedList<DeluxRoom> DELUX_ROOMS = new LinkedList<>();
    public void showStandartRooms(){
        for(StandartRoom ob : STANDART_ROOMS){
            System.out.print(ob.getNumber() + " ");
        }
    }
    public void showDeluxRums(){
        for(DeluxRoom ob : DELUX_ROOMS){
            System.out.print(ob.getNumber() + " ");
        }
    }
    public String getNumber(){
        return "non";
    }
}
class StandartRoom extends Room{
    private final String number;
    private final String amenities;
    private final double price;

    public StandartRoom(String number, String amenities, double price) {
        this.number = number;
        this.amenities = amenities;
        this.price = price;
        Room.STANDART_ROOMS.add(this);
    }

    public String getNumber() {
        return number;
    }
    public double getPrice() {
        return price;
    }
}

class DeluxRoom extends Room{
private final String number;
private final String amenities;
private final double price;

public DeluxRoom(String number, String amenities, double price) {
        this.number = number;
        this.amenities = amenities;
        this.price = price;
        Room.DELUX_ROOMS.add(this);
        }

public String getNumber() {
        return number;
        }
public double getPrice() {
        return price;
        }
}

class Guest{
    private final String name;
    private final String contInfo;
    private LinkedList<String> myRooms = new LinkedList<>();
    private  Room inRoom;

    public Guest(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }
    public void serchRoom(){
        Room ob = new Room();
        System.out.println("Standart rooms");
        ob.showStandartRooms();
        System.out.println();
        System.out.println("Delux rooms");
        ob.showDeluxRums();
        ob = null;
    }
    public void goToRoom(Room ob){
        inRoom = ob;
        myRooms.add(ob.getNumber());
    }
    public Room retRoom(){
        return inRoom;
    }

    public void showReservdRooms(){
        System.out.println(myRooms);
    }
}

class Reserv{
    private final Guest guest;
    private StandartRoom standartRoom;
    private DeluxRoom deluxRoom;
    private final String reservDate;
    Reserv(Guest guest, String reservDate, Room room){
        this.guest = guest;
        this.reservDate = reservDate;
        setRoom(room);
    }

    private void setRoom(Room room){
        if(room instanceof StandartRoom){
            this.standartRoom = (StandartRoom) room;
            deluxRoom = null;
        }else {
            this.deluxRoom = (DeluxRoom) room;
            standartRoom = null;
        }
    }

    public void reservRoom(){
        if(standartRoom != null)
            reservStandartRoom();
        else
            reservDeluxRoom();
    }

    private void reservStandartRoom(){
        guest.goToRoom(standartRoom);
    }
    private void reservDeluxRoom(){
        guest.goToRoom(deluxRoom);
    }

}