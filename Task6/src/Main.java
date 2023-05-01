import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
}

class Patient{
    private LinkedList<String> taracVirahat = new LinkedList<>();
    private String name;
    private int age;
    private String info;

    public static class Builder{
        private String name;
        private int age;
        private String info = "Non";
        Builder(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Builder info(String val){
            info = val;
            return this;
        }
        public Patient build(){
            return new Patient(this);
        }
    }
    private Patient(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.info = builder.info;
    }

    public LinkedList<String> getTaracVirahat() {
        return taracVirahat;
    }
}

class Doctor {
    private HashMap<Patient,String> patienInfo = new HashMap<>();
    private String name;
    private String contInfo;

    Doctor(String name){
        this(name,"Non");
    }

    Doctor(String name, String contInfo){
        this.name = name;
        this.contInfo = contInfo;
    }

    public void addInfo(Patient patient, String info){
        patienInfo.put(patient,info);
    }
}

class medicallStaff{
    private LinkedList<Doctor> staffDoctors = new LinkedList<>();
    private Patient patient;
    private String name;
    private String titl;

    medicallStaff(String name){
        this(name,"Non");
    }

    medicallStaff(String name, String titl){
        this.name = name;
        this.titl = titl;
    }
    public void setStaffDoctors(Doctor ... arr){
        for(int i = 0; i < arr.length; i++){
            staffDoctors.add(arr[i]);
        }
    }

    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public void virahatel(){
        patient.getTaracVirahat().add(name);
    }
}
