import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }
}

class Student{
    private final String name;
    private final String contInfo;

    Student(String name, String contInfo) {
        this.name = name;
        this.contInfo = contInfo;
    }

    public String getName() {
        return name;
    }
}

class Teacher{
    private final String name;
    private final String contInfo;
    private final String subjectTought;

    Teacher(String name, String contInfo, String subjectTought) {
        this.name = name;
        this.contInfo = contInfo;
        this.subjectTought = subjectTought;
    }

    public String getName() {
        return name;
    }

    public String getSubjectTought() {
        return subjectTought;
    }
    public void removeStudent(MathCours mathCours, Student student){
        mathCours.MathStudents.remove(student);
    }
}

class MathCours{
    public final MathCours mathCours = new MathCours();
    public final LinkedList<Student> MathStudents = new LinkedList<>();
    public LinkedList<Student> getStudents() {
        return MathStudents;
    }
}

class Algebra extends MathCours{
    private final String name;
    private final Teacher teacher;
    private final LinkedList<Student> students = new LinkedList<>();

    Algebra(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
    public void getStudent(Student student){
        students.add(student);
        MathStudents.add(student);

    }
}

class Geometry extends MathCours{
    private final String name;
    private final Teacher teacher;
    private final LinkedList<Student> students = new LinkedList<>();

    public Geometry(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
    public void getStudent(Student student){
        students.add(student);
        MathStudents.add(student);

    }
}

class Langueg{
    public final LinkedList<Student> LanguegStudnets = new LinkedList<>();
    public LinkedList<Student> getStudents() {
        return LanguegStudnets;
    }
}

class English extends Langueg{
    private final String name;
    private final Teacher teacher;
    private final LinkedList<Student> students = new LinkedList<>();

    public English(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
    public void getStudent(Student student){
        students.add(student);
        LanguegStudnets.add(student);
    }
}

class Spanish extends Langueg{
    private final String name;
    private final Teacher teacher;
    private final LinkedList<Student> students = new LinkedList<>();

    public Spanish(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
    public void getStudent(Student student){
        students.add(student);
        LanguegStudnets.add(student);
    }
}