import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
}

class JobPoseing{
    private final String title;
    private final String description;
    private final double salary;

    public JobPoseing(String title, String description, double salary) {
        this.title = title;
        this.description = description;
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getSalary() {
        return salary;
    }
}

class Companie{
    public final HashMap<String,JobPoseing> JOBS = new HashMap<>();
    private final String name;
    private final String contInfo;

    public Companie(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }

    public String getContInfo() {
        return contInfo;
    }

    public void addJob(String name, JobPoseing jobPoseing){
        JOBS.put(name,jobPoseing);
    }
    public void serchJob(String name){
        System.out.println(JOBS.get(name).getTitle() + " " + JOBS.get(name).getDescription() + " " +JOBS.get(name).getSalary());
    }
}

class JobSeeker{
    private final String name;
    private final String contInfo;
    private final String resume;
    private final LinkedList<String> myJobs = new LinkedList<>();

    public static class Builder{
        private final String name;
        private final String contInfo;
        private String resume = "Non";
        Builder(String name, String contInfo){
            this.name = name;
            this.contInfo = contInfo;
        }

        public Builder resume(String val){
            resume = val;
            return this;
        }
        public JobSeeker build(){
            return new JobSeeker(this);
        }
    }
    private JobSeeker(Builder builder) {
        this.name = builder.name;
        this.contInfo = builder.contInfo;
        this.resume = builder.resume;
    }

    public void getJob(Companie companie, String name){
        if(companie.JOBS.containsKey(name)){
            companie.JOBS.remove(name);
            myJobs.add(name);
        }else{
            System.out.println("Ther are not thet kind of job");
        }

    }

}