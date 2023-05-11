import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
}
// abstract class for healthcare operations
abstract class HealthcareOperation {
    abstract void viewMedicalHistory(Patient patient);
}

// interface for different types of appointments
interface Appointment {
    void scheduleAppointment(Patient patient, Doctor doctor, String appointmentTime);
}

// patient class with name and contact information attributes
class Patient {
    private String name;
    private String contactInfo;
    private String medicalHistory;

    public Patient(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}

// doctor class with name, contact information, and specialty attributes
class Doctor {
    private String name;
    private String contactInfo;
    private String specialty;
    private List<Appointment> appointments;

    public Doctor(String name, String contactInfo, String specialty) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.specialty = specialty;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void manageSchedule() {
        // manage doctor's schedule
    }
}

// in-person appointment class that implements the appointment interface
class InPersonAppointment implements Appointment {
    public void scheduleAppointment(Patient patient, Doctor doctor, String appointmentTime) {
        // schedule an in-person appointment
        System.out.println(patient.getName() + " has scheduled an in-person appointment with Dr. " + doctor.getName() + " on " + appointmentTime);
        doctor.addAppointment(this);
    }
}

// virtual appointment class that implements the appointment interface
class VirtualAppointment implements Appointment {
    public void scheduleAppointment(Patient patient, Doctor doctor, String appointmentTime) {
        // schedule a virtual appointment
        System.out.println(patient.getName() + " has scheduled a virtual appointment with Dr. " + doctor.getName() + " on " + appointmentTime);
        doctor.addAppointment(this);
    }
}



