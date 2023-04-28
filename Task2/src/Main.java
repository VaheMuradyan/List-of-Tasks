import java.util.*;

public class Main {
    public static void main(String[] args) {


    }
}

class Car {
    private String mark;
    private String model;
    private double price;

    Car(String mark, String model, double price){
        this.mark = mark;
        this.model = model;
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }
}

class Customer{
    private String name;
    private String kontakt;
    private LinkedList<Car> arr = new LinkedList<>();
    public Customer(String name, String kontakt) {
        this.name = name;
        this.kontakt = kontakt;
    }

    public void carInventory(Salesman ob, Car ob1){
        arr.add(ob.getAvto(ob1));
    }
    public void carInventory(Salesman ob, String mek, String erk){
        arr.add(ob.getAvto(mek,erk));
    }

    public void Property(){
        for(Car ob: arr){
            System.out.println(ob.getMark() + " " + ob.getModel() + " " + ob.getPrice());
        }
    }

}

class Salesman {
    private String name;
    private double commision;
    public LinkedList<Car> arr = new LinkedList<>();
    private LinkedList<Car> saleCarsList = new LinkedList<>();
    public Salesman(String name) {
        this.name = name;
        this.commision = 0;
    }

    public void cank(){
        for(Car ob: arr){
            System.out.println(ob.getMark() + " " + ob.getModel() + " " + ob.getPrice());
        }
    }

    public void showSaleCars(){
        for(Car x: arr){
            System.out.println(x.getMark() + " " + x.getModel() + " " + x.getPrice());
        }
    }

    public void addAvto(Car ob){
        arr.add(ob);
    }

    public Car getAvto(Car ob) {
        Car ob1 = null;
        for(int i = 0; i < arr.size(); i++){
            if(ob.getMark().equals(arr.get(i).getMark()) && ob.getModel().equals(arr.get(i).getModel())){
                commision += (ob.getPrice() * 5 / 100);
                ob1 = arr.get(i);
                saleCarsList.add(ob1);
                arr.remove(i);
            }
        }
        return ob1;
    }

    public Car getAvto(String mark, String model) {
        Car ob = null;
        for(int i = 0; i < arr.size(); i++){
            if( mark.equals(arr.get(i).getMark()) && model.equals(arr.get(i).getModel())){
                commision += (arr.get(i).getPrice() * 5 / 100);
                ob = arr.get(i);
                saleCarsList.add(ob);
                arr.remove(i);
            }
        }
        return ob;
    }

    public void search(String bar) {
        for(int i = 0; i < arr.size(); i++){
            if( bar.equals(arr.get(i).getMark()) || bar.equals(arr.get(i).getModel())){
                System.out.println(arr.get(i).getModel() + " " + arr.get(i).getMark() + " " + arr.get(i).getPrice());
            }
        }
    }


    public double getCommision() {
        return commision;
    }
}

