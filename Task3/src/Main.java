import java.util.*;
public class Main {
    public static void main(String[] args) {
        Menu menu = Menu.getInstanc();
        menu.setMenu("xorovac",500);
        menu.setMenu("salat",1200);
        menu.setMenu("ratatuy",300);
        menu.setMenu("sok",200);
        hachaxort vahe = new hachaxort.Builder(50000).name("Vahe").contInfo("agarakic").build();
        vahe.showMenu();
        patver ob = new patver(vahe);
        ob.setPatverner("salat","ratatuy");
        vahe.Patvirel(ob);
        System.out.println(vahe.many);
    }
}

class Menu{
    private static final Menu Instanc = new Menu();
    private LinkedList<String> chashNames = new LinkedList<>();
    private HashMap<String,Integer> menu = new HashMap<>();
    private Menu(){ }

    public static Menu getInstanc() {
        return Instanc;
    }


    public void setMenu(String valu1, int valu2){
        chashNames.add(valu1);
        menu.put(valu1,valu2);

    }

    public int getCash(String valu){
        return menu.get(valu);
    }

    public LinkedList<String> getChashNames() {
        return chashNames;
    }


}

class patver{
    private hachaxort hachName;
    private Menu ob = Menu.getInstanc();
    private LinkedList<String> myPatverner = new LinkedList<>();
    public int allPrice = 0;

    patver(hachaxort hachName){
        this.hachName = hachName;
    }

    public void setPatverner(String ... arr){
        for(String val: arr){
            myPatverner.add(val);
        }
    }

    public LinkedList<String> getMyPatverner(){
        return myPatverner;
    }

}

class hachaxort{
    private String name;
    private String contInfo;
    public int many;
    private Menu menu;
    public static class Builder{
        private String name = "Non";
        private String contInfo = "Non";
        private int many;
        Builder(int many){
            this.many = many;
        }

        public Builder name(String valu){
            name = valu;
            return this;
        }

        public Builder contInfo(String valu){
            contInfo = valu;
            return this;
        }
        public hachaxort build(){
            return new hachaxort(this);
        }
    }
    private hachaxort(Builder builder){
        name = builder.name;
        contInfo = builder.contInfo;
        many = builder.many;
        menu = Menu.getInstanc();
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }

    public void showMenu(){
        for(String valu : menu.getChashNames()){
            System.out.println(valu + " ");
        }
    }

    public void Patvirel(patver ob1){
        for(int i = 0; i < ob1.getMyPatverner().size(); i++){
            ob1.allPrice += menu.getCash(ob1.getMyPatverner().get(i));
            System.out.println(ob1.allPrice);
        }
        many -= ob1.allPrice;
    }
}