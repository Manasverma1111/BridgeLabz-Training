import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patients {

    private int patientId;
    private String name;
    private int age;

    private List<String> medicalHistory = new ArrayList<>();

    public Patients(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    protected void addMedicalHistory(String record) {
        medicalHistory.add(record);
    }

    protected void showMedicalHistory() {

        for (String record : medicalHistory) {
            System.out.println("" + record);
        }
    }
}

class InPatient extends Patients implements MedicalRecord {

    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyCharge) {

        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addMedicalHistory("InPatient Record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showMedicalHistory();
    }
}

class OutPatient extends Patients implements MedicalRecord {

    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addMedicalHistory("OutPatient Record: " + record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History:");
        showMedicalHistory();
    }
}

class HospitalService {

    public static void processPatients(List<Patients> patients) {

        for (Patients patient : patients) {

            patient.getPatientDetails();
            System.out.println("Total Bill: " + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }

            System.out.println();
        }
    }
}

public class HospitalManagSystem {

    public static void main(String[] args) {

        List<Patients> patients = new ArrayList<>();

        InPatient p1 = new InPatient(101, "Ravi Kumar", 45, 5, 3000);
        p1.addRecord("Admitted for surgery");
        p1.addRecord("Post-operation recovery");

        OutPatient p2 = new OutPatient(102, "Anita Sharma", 30, 800);
        p2.addRecord("Routine health checkup");

        patients.add(p1);
        patients.add(p2);

        HospitalService.processPatients(patients);
    }
}
