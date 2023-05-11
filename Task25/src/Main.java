import java.util.*;

class Main {
    public static void main(String[] args) {

    }
}
abstract class FitnessTrackingOperation {
    abstract void execute();
}

class Exercise {
    private String name;
    private String muscleGroup;

    public Exercise(String name, String muscleGroup) {
        this.name = name;
        this.muscleGroup = muscleGroup;
    }

    public String getName() {
        return name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }
}

class CardioExercise extends Exercise {
    private int duration;

    public CardioExercise(String name, String muscleGroup, int duration) {
        super(name, muscleGroup);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

class StrengthExercise extends Exercise {
    private int sets;
    private int reps;
    private double weight;

    public StrengthExercise(String name, String muscleGroup, int sets, int reps, double weight) {
        super(name, muscleGroup);
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }
}

class User {
    private String name;
    private String contactInfo;
    private List<Exercise> favoriteExercises;

    public User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
        favoriteExercises = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Exercise> getFavoriteExercises() {
        return favoriteExercises;
    }

    public void addFavoriteExercise(Exercise exercise) {
        favoriteExercises.add(exercise);
    }
}

class WorkoutPlan {
    private User user;
    private List<Exercise> exercises;
    private int duration;

    public WorkoutPlan(User user, List<Exercise> exercises, int duration) {
        this.user = user;
        this.exercises = exercises;
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public int getDuration() {
        return duration;
    }
}

class FitnessTracker {
    private List<User> users;
    private List<WorkoutPlan> workoutPlans;

    public FitnessTracker() {
        users = new ArrayList<>();
        workoutPlans = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addWorkoutPlan(WorkoutPlan workoutPlan) {
        workoutPlans.add(workoutPlan);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<WorkoutPlan> getWorkoutPlans() {
        return workoutPlans;
    }
}


