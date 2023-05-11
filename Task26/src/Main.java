import java.util.*;

public class Main {
    public static void main(String[] args) {
        
    }
}

abstract class Product{
    abstract String getName();
    abstract double getPrice();
    abstract void getComment(String x);
}

class ElectronicProduct extends Product{
    private final String name;
    private final String description;
    private final double price;
    private LinkedList<String> comments = new LinkedList<>();

    public ElectronicProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void getComment(String val){
        comments.add(val);
    }
}

class ClothingProduct extends Product{
    private final String name;
    private final String description;
    private final double price;
    private LinkedList<String> comments = new LinkedList<>();

    public ClothingProduct(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void getComment(String val){
        comments.add(val);
    }
}

class Customer{
    private double many;
    private final String name;
    private final String contInfo;
    private LinkedList<Product> myProducts = new LinkedList<>();

    public Customer(String name, String contInfo,double many) {
        this.name = name;
        this.contInfo = contInfo;
        this.many = many;
    }

    public String getName() {
        return name;
    }

    public void buy(Order order){
        many -= order.getAllPrice();
    }

    public void getProduct(LinkedList<Product> products){
        for(Product ob : products){
            myProducts.add(ob);
        }
    }
    public void addReviw(Product product, String comment){
        product.getComment(comment);
    }
    public void showMyProducts(){
        for(Product ob : myProducts){
            System.out.println(ob.getName() + " " + ob.getPrice());
        }
    }
}

class Order{
    private final Customer customer;
    private LinkedList<Product> productsInOrder = new LinkedList<>();
    private double allPrice = 0;
    Order(Customer customer,Product ... arr){
        this.customer = customer;
        orderProducts(arr);
    }

    private void orderProducts(Product ... arr){
        for(Product ob : arr){
            productsInOrder.add(ob);
            allPrice += ob.getPrice();
        }
    }

    public void order(){
        customer.buy(this);
        customer.getProduct(productsInOrder);
    }

    public double getAllPrice() {
        return allPrice;
    }
}
