import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        menuItem mek = new menuItem("mek",1200,"ank ank");
        menuItem erk = new menuItem("erk",1300,"erk erk");
        menuItem ere = new menuItem("ere",800,"ere ere");
        Customer vahe = new Customer("vahe","info");
        Order ha = new Order(vahe);
        vahe.ordering(ha,mek,erk,ere);
        System.out.println(ha.totalPrice);
        vahe.addRevue(mek,"shat lavna");
        mek.showRevues();
    }
}

class menuItem{
    private final String name;
    private final double price;
    private final String ingredients;
    private LinkedList<String> revues = new LinkedList<>();

    public menuItem(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setRevue(String revue){
        revues.add(revue);
    }

    public void showRevues(){
        System.out.println(revues);
    }
}
class Customer{
    private final String name;
    private final String contInfo;
    private final LinkedList<String> myOrders = new LinkedList<>();

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

    public void ordering(Order order, menuItem ... arr){
        LinkedList<menuItem> val = order.getMenuItems();
        for(int i = 0; i < arr.length; i++){
            val.add(arr[i]);
            order.totalPrice += arr[i].getPrice();
        }
        val = null;
    }

    public void addRevue(menuItem ob, String revu){
        ob.setRevue(revu);
    }
}

class Order{
    private final Customer customr;
    private final LinkedList<menuItem> menuItems = new LinkedList<>();
    public double totalPrice = 0;
    Order(Customer customer){
        this.customr = customer;
    }

    public LinkedList<menuItem> getMenuItems() {
        return menuItems;
    }
}