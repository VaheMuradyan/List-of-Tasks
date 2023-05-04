import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
}

abstract class allProperties{
    static final LinkedList<allProperties> PROPERTIES = new LinkedList<>();
    abstract void addProperty(allProperties ... arr);

}

interface residently{

}

interface comercial{

}
class resPropertie extends allProperties implements residently{
    private double price;
    private String hasce;
    private String feature;

    public resPropertie(double price, String hasce, String feature) {
        this.price = price;
        this.hasce = hasce;
        this.feature = feature;
    }

    public resPropertie(double price, String hasce) {
        this(price,hasce,"Non");
    }
    public resPropertie(double price) {
        this(price,"Non","Non");
    }

    public double getPrice() {
        return price;
    }

    public String getHasce() {
        return hasce;
    }

    public String getFeature() {
        return feature;
    }

    public void addProperty(allProperties ... v){
        for(allProperties ob : v){
            PROPERTIES.add(ob);
        }
    }
}

class comPropertie extends allProperties implements comercial{
    private double price;
    private String hasce;
    private String feature;

    public comPropertie(double price, String hasce, String feature) {
        this.price = price;
        this.hasce = hasce;
        this.feature = feature;
    }

    public comPropertie(double price, String hasce) {
        this(price,hasce,"Non");
    }
    public comPropertie(double price) {
        this(price,"Non","Non");
    }

    public double getPrice() {
        return price;
    }

    public String getHasce() {
        return hasce;
    }

    public String getFeature() {
        return feature;
    }

    public void addProperty(allProperties ... v){
        for(allProperties ob : v){
            PROPERTIES.add(ob);
        }
    }
}



class Agent{
    private final String name;
    private String contInfo;
    Agent(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }

    Agent(String name){
        this(name,"non");
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }
}

class Client{
    private final String name;
    private String contInfo;
    Client(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }

    Client(String name){
        this(name,"non");
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }
    public void sherchItem(String name){
        for(allProperties ob: allProperties.PROPERTIES){
            if()
        }
    }
}