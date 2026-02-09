package main;

import dao.*;
import model.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO doctorDAO = new DoctorDAO();
        AppointmentDAO appointmentDAO = new AppointmentDAO();
        VisitDAO visitDAO = new VisitDAO();
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
        MedicalHistoryDAO historyDAO = new MedicalHistoryDAO();
        BillingDAO billingDAO = new BillingDAO();
        PaymentDAO paymentDAO = new PaymentDAO();

        while (true) {

            System.out.println("\n===== Health Clinic Menu =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. Record Visit");
            System.out.println("5. Generate Bill");
            System.out.println("6. Record Payment");
            System.out.println("7. View Medical History");
            System.out.println("8. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("DOB (YYYY-MM-DD): ");
                    String dob = sc.next();

                    System.out.print("Phone: ");
                    String phone = sc.next();

                    System.out.print("Address: ");
                    String address = sc.next();

                    System.out.print("Blood Group: ");
                    String bloodGroup = sc.next();

                    Patient patient = new Patient(name, dob, phone, address, bloodGroup);
                    patientDAO.addPatient(patient);
                    break;

                case 2:
                    System.out.print("Doctor Name: ");
                    String doctorName = sc.next();

                    System.out.print("Specialization: ");
                    String specialization = sc.next();

                    System.out.print("Phone: ");
                    String doctorPhone = sc.next();

                    System.out.print("Fee: ");
                    double fee = sc.nextDouble();

                    Doctor doctor = new Doctor(doctorName, specialization, doctorPhone, fee);
                    doctorDAO.addDoctor(doctor);
                    break;

                case 3:
                    patientDAO.viewPatients();
                    System.out.print("Patient Id: ");
                    int patientId = sc.nextInt();

                    doctorDAO.viewDoctors();
                    System.out.print("Doctor Id: ");
                    int doctorId = sc.nextInt();

                    System.out.print("Date: ");
                    String date = sc.next();

                    System.out.print("Time: ");
                    String time = sc.next();

                    Appointment appointment = new Appointment(patientId, doctorId, date, time);

                    appointmentDAO.bookAppointment(appointment);
                    break;

                case 4:
                    appointmentDAO.viewAppointments();
                    System.out.print("Appointment Id: ");
                    int appointmentId = sc.nextInt();

                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.next();

                    System.out.print("Notes: ");
                    String notes = sc.next();

                    System.out.print("Visit Date: ");
                    String visitDate = sc.next();

                    Visit visit = new Visit(appointmentId, diagnosis, notes, visitDate);

                    int visitId = visitDAO.recordVisitAndCompleteAppointment(visit);

                    System.out.print("Medicine: ");
                    String medicine = sc.next();

                    System.out.print("Dosage: ");
                    String dosage = sc.next();

                    System.out.print("Duration: ");
                    String duration = sc.next();

                    List<Prescription> prescriptions = new ArrayList<>();
                    prescriptions.add(
                            new Prescription(visitId, medicine, dosage, duration)
                    );

                    prescriptionDAO.addPrescriptionBatch(prescriptions);
                    break;

                case 5:
                    visitDAO.viewVisits();
                    System.out.print("Visit Id: ");
                    int visitIdForBill = sc.nextInt();

                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Bill Date: ");
                    String billDate = sc.next();

                    Bill bill = new Bill(visitIdForBill, amount, billDate);
                    billingDAO.generateBill(bill);
                    break;

                case 6:
                    billingDAO.viewBills();
                    System.out.print("Bill Id: ");
                    int billId = sc.nextInt();

                    System.out.print("Mode: ");
                    String mode = sc.next();

                    System.out.print("Payment Date: ");
                    String paymentDate = sc.next();

                    Payment payment = new Payment(billId, mode, paymentDate);

                    paymentDAO.recordPayment(payment);
                    break;

                case 7:
                    patientDAO.viewPatients();
                    System.out.print("Enter Patient Id: ");
                    int historyPatientId = sc.nextInt();

                    historyDAO.viewHistory(historyPatientId);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}
