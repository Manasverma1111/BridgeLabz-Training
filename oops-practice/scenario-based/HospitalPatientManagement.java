import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IPayable {
    double calculateBill();
}

class Doctor {
    String docName;
    int docId;
    String department;

    Doctor(String docName, int docId, String department) {
        this.docName = docName;
        this.docId = docId;
        this.department = department;
    }
}

abstract class Patientt implements IPayable {

    private String patientName;
    private int patientId;
    private int age;

    public Patientt(String patientName, int patientId, int age) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.age = age;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getAge() {
        return age;
    }

    abstract void displayDetails();
}

class InPatientt extends Patientt {

    private int totalDays;
    private double dailyCharge;

    InPatientt(String patientName, int patientId, int age, int totalDays, double dailyCharge) {
        super(patientName, patientId, age);
        this.totalDays = totalDays;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return totalDays * dailyCharge;
    }

    void displayDetails() {
        System.out.println("InPatient | Name: " + getPatientName()
                + ", ID: " + getPatientId()
                + ", Age: " + getAge()
                + ", Bill: " + calculateBill());
    }
}

class OutPatientt extends Patientt {

    private double appointmentFee;

    OutPatientt(String patientName, int patientId, int age, double appointmentFee) {
        super(patientName, patientId, age);
        this.appointmentFee = appointmentFee;
    }

    public double calculateBill() {
        return appointmentFee;
    }

    void displayDetails() {
        System.out.println("OutPatient | Name: " + getPatientName()
                + ", ID: " + getPatientId()
                + ", Age: " + getAge()
                + ", Bill: " + calculateBill());
    }
}

public class HospitalPatientManagement {

    static List<Patientt> patientsList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1.Admit Patient 2.View Patient 3.Discharge Patient 4.Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                addPatient();
            } else if (choice == 2) {
                viewDetails();
            } else if (choice == 3) {
                dischargePatient();
            } else {
                break;
            }
        }
    }

    static void addPatient() {
        System.out.println("1.InPatient  2.OutPatient");
        int type = sc.nextInt();

        System.out.print("Patient Id: ");
        int patientId = sc.nextInt();
        System.out.print("Patient Name: ");
        String patientName = sc.next();
        System.out.print("Patient Age: ");
        int age = sc.nextInt();

        if (type == 1) {
            System.out.print("Total Days: ");
            int totalDays = sc.nextInt();
            System.out.print("Daily Charge: ");
            double dailyCharge = sc.nextDouble();
            patientsList.add(new InPatientt(patientName, patientId, age, totalDays, dailyCharge));
        } else {
            System.out.print("Appointment Fee: ");
            double appointmentFee = sc.nextDouble();
            patientsList.add(new OutPatientt(patientName, patientId, age, appointmentFee));
        }
    }

    static void viewDetails() {
        for (Patientt p : patientsList) {
            p.displayDetails(); // Polymorphism
        }
    }

    static void dischargePatient() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        patientsList.removeIf(p -> p.getPatientId() == patientId);
    }
}
