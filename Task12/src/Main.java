import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        luxCar bmw = new luxCar("bmw","m3",1200);
        luxCar mers = new luxCar("mers","c180",1300);
        ecoCar zro7 = new ecoCar("lada","zro7",300);
        ecoCar audi = new ecoCar("audi","a8",200);
        bmw.addToCars();
        mers.addToCars();
        zro7.addToCars();
        audi.addToCars();
        Customer vahe = new Customer("Vahe","Agarakic");
        vahe.serchCar("mers");
        Rental op1 = new Rental(bmw,vahe,"3");
        Rental op2 = new Rental(audi,vahe,"5");
        op1.rental();
        op2.rental();
        vahe.showMyCars();
    }
}
interface luxury{
    double getRentPrice();
}

interface econom{

    double getRentPrice();
}

abstract class Car{
    public static final LinkedList<ecoCar> ECO_CARS = new LinkedList<>();
    public static final LinkedList<luxCar> LUX_CARS = new LinkedList<>();
    protected void addCar(ecoCar ob){
        ECO_CARS.add(ob);
    }
    protected void addCar(luxCar ob){
        LUX_CARS.add(ob);
    }
    abstract public String getMake();

    abstract public String getModel();
}
class ecoCar extends Car implements econom{
    private final String make;
    private final String model;
    private final double rentPrice;

    public ecoCar(String make, String model, double rentPrice) {
        this.make = make;
        this.model = model;
        this.rentPrice = rentPrice;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getRentPrice() {
        return rentPrice;
    }
    public void addToCars(){
        super.addCar(this);
    }
}
class luxCar extends Car implements luxury{
    private final String make;
    private final String model;
    private final double rentPrice;

    public luxCar(String make, String model, double rentPrice) {
        this.make = make;
        this.model = model;
        this.rentPrice = rentPrice;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getRentPrice() {
        return rentPrice;
    }
    public void addToCars(){
        super.addCar(this);
    }
}

class Customer{
    private final String name;
    private final String contInfo;
    private LinkedList<Car> myCars = new LinkedList<>();

    public Customer(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }
    void serchCar(String makeName){
        for(ecoCar ob : Car.ECO_CARS){
            if(ob.getMake().equals(makeName)){
                System.out.println(ob.getMake() + " " + ob.getModel() + " " + ob.getRentPrice());
                return;
            }
        }
        for(luxCar ob : Car.LUX_CARS){
            if(ob.getMake().equals(makeName)){
                System.out.println(ob.getMake() + " " + ob.getModel() + " " + ob.getRentPrice());
                return;
            }
        }

    }
    void serchCar(String makeName, String modelName){
        for(ecoCar ob : Car.ECO_CARS){
            if(ob.getMake().equals(makeName) || ob.getModel().equals(modelName)){
                System.out.println(ob.getMake() + " " + ob.getModel() + " " + ob.getRentPrice());
                return;
            }
        }
        for(luxCar ob : Car.LUX_CARS){
            if(ob.getMake().equals(makeName) || ob.getModel().equals(modelName)){
                System.out.println(ob.getMake() + " " + ob.getModel() + " " + ob.getRentPrice());
                return;
            }
        }
    }

    void getCar(Car ob){
        myCars.add(ob);
    }
    Car retCar(String make){
        Car ob = null;
        for(int i = 0; i < myCars.size(); i++){
            if(myCars.get(i).getMake().equals(make)){
                ob = myCars.get(i);
                return ob;
            }
        }
        return ob;
    }

    Car retCar(String make, String model){
        Car ob = null;
        for(int i = 0; i < myCars.size(); i++){
            if(myCars.get(i).getMake().equals(make) || myCars.get(i).getModel().equals(model)){
                ob = myCars.get(i);
                return ob;
            }
        }
        return ob;
    }

    void showMyCars(){
        for(Car ob : myCars){
            System.out.println(ob.getMake() + ob.getModel());
        }
    }
}

abstract class Rentals{
    abstract void rental();
}

class Rental extends Rentals{
    private final Car rentalCar;
    private final Customer rentalCustomer;
    private final String rentTime;

    public Rental(Car rentalCar, Customer rentalCustomer, String rentTime) {
        this.rentalCar = rentalCar;
        this.rentalCustomer = rentalCustomer;
        this.rentTime = rentTime;
    }
    public void rental(){
        rentalCustomer.getCar(rentalCar);
    }
}