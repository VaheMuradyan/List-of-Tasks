public class Main {
    public static void main(String[] args) {
        Passenger Vahe = new Passenger("Vahe","ank");
        Driver Ando = new Driver("Ando","ank","06");
        Ride num1 = new Ride(Vahe,Ando,"zbosanq",200);
        num1.ride();
    }
}

class Driver{
    final private String name;
    final private String contInfo;
    final private String vehichel;
    private boolean isFree = true;
    private Passenger myPassenger;
    private double myPoints;

    public Driver(String name, String contInfo, String vehichel) {
        this.name = name;
        this.contInfo = contInfo;
        this.vehichel = vehichel;
    }

    public String getName() {
        return name;
    }

    public String getVehichel() {
        return vehichel;
    }

    public void ride(Passenger passenger){
        if(isFree) {
            isFree = false;
            myPassenger = passenger;
        }
    }

    public void getPoint(double val){
        if(val >= 5){
            myPoints = 5;
        }else {
            myPoints = 0;
        }
    }

    public void addPointToPassenger(Passenger passenger ,double val){
        passenger.getPoint(val);
    }

    public void isFreeNow(){
        isFree = true;
    }


}

class Passenger{
    final private String name;
    final private String contInfo;
    private double myPoints;

    public Passenger(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public void goRideing(Driver ob){
        ob.ride(this);
    }

    public void getPoint(double val){
        if(val >= 5){
            myPoints = 5;
        }else {
            myPoints = 0;
        }
    }
    public void addPoinToDriver(Driver driver, double val){
        driver.getPoint(val);
    }
}
class Ride{
    final private Passenger passenger;
    final private Driver driver;
    final private String rideDestonetion;
    final private double price;

    public Ride(Passenger passenger, Driver driver, String rideDestonetion, double price) {
        this.passenger = passenger;
        this.driver = driver;
        this.rideDestonetion = rideDestonetion;
        this.price = price;
    }
    public void ride(){
        passenger.goRideing(driver);
        try{
            Thread.sleep(2000);
            driver.isFreeNow();
        }catch (InterruptedException o){
            System.out.println(o);
        }
    }
}
