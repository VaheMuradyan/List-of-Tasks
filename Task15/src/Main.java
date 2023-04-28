import java.util.LinkedList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        allProduct ban = new allProduct();
      indProduct ob = new indProduct("sapon",1200,"lav",ban);
      indProduct ob1 = new indProduct("kofe",200,"shat lav",ban);
      Customer vahe = new Customer("vahe","lav txa");
      Order taza = new Order(vahe,ban);
      taza.addProduct(ob, ob1);
      taza.buy();
    }
}

class allProduct{
    LinkedList<indProduct> products = new LinkedList<>();
    HashMap<indProduct,String> comment = new HashMap<>();

    protected void getComment(indProduct ob){
        System.out.println(comment.get(ob));
    }

}

class indProduct {
    allProduct ob;
    public String name;
    private double price;
    private String info;

    indProduct(String name, double price, String info,allProduct ob) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.ob = ob;
        addProduct(ob);
    }


    public double getPrice() {
        return price;
    }
    protected void addProduct(allProduct ob){
        ob.products.add(this);
    }
}

class Customer {
    private String name;
    private String contInfo;
    public double mony;
    LinkedList<indProduct> story = new LinkedList<>();

    Customer(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }
}

class Order {
    allProduct Allproduct;

    Customer ob;
    private LinkedList<indProduct> myProduct = new LinkedList<>();
    private double Price = 0;


    Order(Customer ob, allProduct ob1){
        this.ob = ob;
        Allproduct = ob1;
    }

    public void addProduct(indProduct ... ob){
        for(int i = 0; i < ob.length; i++){
            myProduct.add(ob[i]);
            Price += ob[i].getPrice();
        }
    }

    public void addRevue(indProduct ob, String string){
        Allproduct.comment.put(ob,string);
    }

    public LinkedList<indProduct> buy(){
        ob.mony -= Price;
        return myProduct;
    }
}