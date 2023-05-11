import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }
}

abstract class Recipe{
    abstract String getTitle();
    abstract String getIngredients();
    abstract String getInstruction();
}

class VegitatianRecipe extends Recipe{
    private final String title;
    private final String ingredients;
    private final String instruction;

    public VegitatianRecipe(String title, String ingredients, String instruction) {
        this.title = title;
        this.ingredients = ingredients;
        this.instruction = instruction;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstruction() {
        return instruction;
    }
}

class DessertRecipe extends Recipe{
    private final String title;
    private final String ingredients;
    private final String instruction;

    public DessertRecipe(String title, String ingredients, String instruction) {
        this.title = title;
        this.ingredients = ingredients;
        this.instruction = instruction;
    }

    public String getTitle() {
        return title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstruction() {
        return instruction;
    }
}

class User{
    private final String name;
    private final String contInfo;
    private LinkedList<Recipe> favRecipe = new LinkedList<>();
    User(String name, String contInfo){
        this.contInfo = contInfo;
        this.name = name;
    }

    public void addFavRecipe(Recipe ob){
        favRecipe.add(ob);
    }
}

class Rating{
    private final Recipe recipe;
    private final User user;
    private int score;
    private HashMap<Recipe,Integer> racipeRating = new HashMap<>();

    public Rating(Recipe recipe, User user, int val) {
        this.recipe = recipe;
        this.user = user;
        setScore(val);
    }

    private void setScore(int val){
        if(val < 0){
            score = 0;
        }else if(val > 5){
            score = 5;
        }else {
            score = val;
        }
    }

    public void setRating(){
        racipeRating.put(recipe,score);
    }

}