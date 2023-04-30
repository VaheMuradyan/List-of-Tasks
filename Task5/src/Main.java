import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }
}

class Cours{
    private LinkedList<Student> students = new LinkedList<>();
    private final String coursName;
    private final Proffesor proffesor;
    private String info;

    private Cours(Builder builder){
        this.coursName = builder.coursName;
        this.proffesor = builder.proffesor;
        this.info = builder.info;
    }

    public static class Builder{
        private String coursName;
        private Proffesor proffesor;
        private String info = "Non";

        Builder(String coursName, Proffesor proffesor){
            this.coursName = coursName;
            this.proffesor = proffesor;
        }

        public Builder info(String valu){
            info = valu;
            return this;
        }

        public Cours build(){
            return new Cours(this);
        }
    }

    public String getCoursName() {
        return coursName;
    }

    public Proffesor getProffesor() {
        return proffesor;
    }

    public String getInfo() {
        return info;
    }

    public void addStudent(Student student){
        if(students.contains(student)){
            return;
        }else{
            students.add(student);
        }
    }

    public Cours getCours(){
        return this;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
}

class Student{
    private LinkedList<Cours> myCourses = new LinkedList<>();
    private String studentName;
    private String contInfo;

    Student(String studentName){
        this(studentName,"Non");
    }

    Student(String studentName, String contInfo){
        this.studentName = studentName;
        this.contInfo = contInfo;
    }

    public void setContInfo(){
        this.contInfo = contInfo;
    }

    public void goToCours(Cours cours){
        if(myCourses.contains(cours)){
            return;
        }else {
            myCourses.add(cours.getCours());
            cours.addStudent(this);
        }
    }

    public void removeCours(String coursName){
        for(int i = 0; i < myCourses.size(); i++){
            if(myCourses.get(i).getCoursName().equals(coursName)){
                myCourses.remove(i);
            }
        }
    }

    public void removeCourse(Cours cours){
        if(myCourses.contains(cours)){
            myCourses.remove(cours);
        }
    }

    public void goToCours(Proffesor proffesor,String coursName){
        if(myCourses.contains(proffesor.getCours(coursName))){
            return;
        }else {
            myCourses.add(proffesor.getCours(coursName));
            proffesor.getCours(coursName).addStudent(this);
        }
    }

    public LinkedList<Cours> getMyCourses() {
        return myCourses;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getContInfo() {
        return contInfo;
    }
}

class Proffesor{
    private LinkedList<Cours> courses = new LinkedList<>();
    private String proffesorName;
    private String contInfo;

    Proffesor(String proffesorName){
        this(proffesorName,"Non");
    }

    Proffesor(String proffesorName, String contInfo){
        this.proffesorName = proffesorName;
        this.contInfo = contInfo;
    }

    public void setContInfo(String contInfo){
        this.contInfo = contInfo;
    }

    public void makeCours(String coursName){
        courses.add(new Cours.Builder(coursName,this).build());
    }
    public void makeCours(String coursName, String info1){
         courses.add(new Cours.Builder(coursName,this).info(info1).build());
    }

    public void removeCours(String coursName){
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCoursName().equals(coursName)){
                courses.remove(i);
            }
        }
    }

    public void removeCourse(Cours cours){
        if(courses.contains(cours)){
            courses.remove(cours);
        }
    }
    public LinkedList<Cours> getCourses() {
        return courses;
    }
    public Cours getCours(String coursName){
        Cours ob = null;
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCoursName().equals(coursName)){
                ob = courses.get(i);
            }
        }
        return ob;
    }
}