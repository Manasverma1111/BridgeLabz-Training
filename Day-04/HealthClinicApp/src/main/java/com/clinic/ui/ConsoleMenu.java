package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

/**
 * Console UI layer -- menus, user input/output only.
 * Depends only on DAO interfaces and the AppointmentService; never writes
 * SQL or touches Connection/ResultSet objects directly.
 */
public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    private final AppointmentService appointmentService =
            new AppointmentService(appointmentDAO, billingDAO, visitHistoryDAO);

    public void run() {
        System.out.println("Starting Health Clinic Management System...");
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> patientModule();
                case 2 -> doctorModule();
                case 3 -> specializationModule();
                case 4 -> appointmentModule();
                case 5 -> completeAppointmentModule();
                case 6 -> running = false;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("===== HEALTH CLINIC MANAGEMENT SYSTEM =====");
        System.out.println("1. Patient Module");
        System.out.println("2. Doctor Module");
        System.out.println("3. Specialization Module");
        System.out.println("4. Appointment Module");
        System.out.println("5. Complete Appointment (Billing + Visit History)");
        System.out.println("6. Exit");
    }

    // ----------------------------------------------------------------------
    // Patient Module
    // ----------------------------------------------------------------------
    private void patientModule() {
        System.out.println("\n-- Patient Module --");
        System.out.println("1. Add Patient  2. View All Patients  3. Update Patient  4. Deactivate Patient  5. Back");
        int choice = readInt("Choice: ");
        switch (choice) {
            case 1 -> addPatient();
            case 2 -> viewAllPatients();
            case 3 -> updatePatient();
            case 4 -> deactivatePatient();
            case 5 -> { /* back */ }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addPatient() {
        String firstName = readString("First name: ");
        String lastName = readString("Last name: ");
        Date dob = Date.valueOf(readString("Date of birth (YYYY-MM-DD): "));
        String gender = readString("Gender (Male/Female/Other): ");
        String email = readString("Email: ");
        String phone = readString("Phone: ");

        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDateOfBirth(dob);
        p.setGender(gender);
        p.setEmail(email);
        p.setPhone(phone);

        int id = patientDAO.insertPatient(p);
        if (id > 0) {
            System.out.println("Patient added successfully with ID: " + id);
        } else {
            System.out.println("Failed to add patient.");
        }
    }

    private void viewAllPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private void updatePatient() {
        int id = readInt("Patient ID to update: ");
        Patient existing = patientDAO.getPatientById(id);
        if (existing == null) {
            System.out.println("Patient not found.");
            return;
        }
        String email = readString("New email (current: " + existing.getEmail() + "): ");
        existing.setEmail(email);
        boolean success = patientDAO.updatePatient(existing);
        System.out.println(success ? "Patient updated." : "Update failed.");
    }

    private void deactivatePatient() {
        int id = readInt("Patient ID to deactivate: ");
        boolean success = patientDAO.deletePatient(id);
        System.out.println(success ? "Patient deactivated (soft delete)." : "Deactivation failed.");
    }

    // ----------------------------------------------------------------------
    // Doctor Module
    // ----------------------------------------------------------------------
    private void doctorModule() {
        System.out.println("\n-- Doctor Module --");
        System.out.println("1. Add Doctor  2. View All Doctors  3. Deactivate Doctor  4. Back");
        int choice = readInt("Choice: ");
        switch (choice) {
            case 1 -> addDoctor();
            case 2 -> viewAllDoctors();
            case 3 -> deactivateDoctor();
            case 4 -> { /* back */ }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addDoctor() {
        String firstName = readString("First name: ");
        String lastName = readString("Last name: ");
        int specId = readInt("Specialization ID: ");
        String email = readString("Email: ");
        String phone = readString("Phone: ");

        Doctor d = new Doctor();
        d.setFirstName(firstName);
        d.setLastName(lastName);
        d.setSpecializationId(specId);
        d.setEmail(email);
        d.setPhone(phone);

        int id = doctorDAO.insertDoctor(d);
        System.out.println(id > 0 ? "Doctor added successfully with ID: " + id : "Failed to add doctor.");
    }

    private void viewAllDoctors() {
        List<Doctor> doctors = doctorDAO.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private void deactivateDoctor() {
        int id = readInt("Doctor ID to deactivate: ");
        boolean success = doctorDAO.deleteDoctor(id);
        System.out.println(success ? "Doctor deactivated (soft delete)." : "Deactivation failed.");
    }

    // ----------------------------------------------------------------------
    // Specialization Module
    // ----------------------------------------------------------------------
    private void specializationModule() {
        System.out.println("\n-- Specialization Module --");
        System.out.println("1. Add Specialization  2. View All Specializations  3. Back");
        int choice = readInt("Choice: ");
        switch (choice) {
            case 1 -> addSpecialization();
            case 2 -> viewAllSpecializations();
            case 3 -> { /* back */ }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addSpecialization() {
        String name = readString("Name: ");
        String description = readString("Description: ");
        Specialization s = new Specialization();
        s.setName(name);
        s.setDescription(description);
        int id = specializationDAO.insertSpecialization(s);
        System.out.println(id > 0 ? "Specialization added with ID: " + id : "Failed to add specialization.");
    }

    private void viewAllSpecializations() {
        List<Specialization> list = specializationDAO.getAllSpecializations();
        if (list.isEmpty()) {
            System.out.println("No specializations found.");
            return;
        }
        for (Specialization s : list) {
            System.out.println(s);
        }
    }

    // ----------------------------------------------------------------------
    // Appointment Module
    // ----------------------------------------------------------------------
    private void appointmentModule() {
        System.out.println("\n-- Appointment Module --");
        System.out.println("1. Book Appointment  2. View All Appointments  3. Cancel Appointment  4. Back");
        int choice = readInt("Choice: ");
        switch (choice) {
            case 1 -> bookAppointment();
            case 2 -> viewAllAppointments();
            case 3 -> cancelAppointment();
            case 4 -> { /* back */ }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void bookAppointment() {
        int patientId = readInt("Patient ID: ");
        int doctorId = readInt("Doctor ID: ");
        Timestamp dateTime = Timestamp.valueOf(readString("Appointment date/time (YYYY-MM-DD HH:MM:SS): "));

        Appointment a = new Appointment();
        a.setPatientId(patientId);
        a.setDoctorId(doctorId);
        a.setAppointmentDate(dateTime);
        a.setStatus("Scheduled");

        int id = appointmentDAO.insertAppointment(a);
        System.out.println(id > 0 ? "Appointment booked with ID: " + id : "Failed to book appointment.");
    }

    private void viewAllAppointments() {
        List<Appointment> appointments = appointmentDAO.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }

    private void cancelAppointment() {
        int id = readInt("Appointment ID to cancel: ");
        boolean success = appointmentDAO.cancelAppointment(id);
        System.out.println(success ? "Appointment cancelled." : "Cancel failed (not found or not in Scheduled state).");
    }

    // ----------------------------------------------------------------------
    // Complete Appointment Module (Billing + Visit History, atomic transaction)
    // ----------------------------------------------------------------------
    private void completeAppointmentModule() {
        System.out.println("\n-- Complete Appointment (Billing + Visit History) --");
        System.out.println("1. Complete Appointment  2. View All Billing  3. View All Visit History  4. Back");
        int choice = readInt("Choice: ");
        switch (choice) {
            case 1 -> completeAppointment();
            case 2 -> viewAllBilling();
            case 3 -> viewAllVisitHistory();
            case 4 -> { /* back */ }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void completeAppointment() {
        int appointmentId = readInt("Appointment ID: ");
        double amount = readDouble("Billing amount: ");
        String diagnosis = readString("Diagnosis: ");
        String prescription = readString("Prescription: ");
        String visitNotes = readString("Visit notes: ");

        appointmentService.completeAppointmentWithBillingAndVisit(
                appointmentId, amount, diagnosis, prescription, visitNotes);
    }

    private void viewAllBilling() {
        List<Billing> list = billingDAO.getAllBilling();
        if (list.isEmpty()) {
            System.out.println("No billing records found.");
            return;
        }
        for (Billing b : list) {
            System.out.println(b);
        }
    }

    private void viewAllVisitHistory() {
        List<VisitHistory> list = visitHistoryDAO.getAllVisitHistory();
        if (list.isEmpty()) {
            System.out.println("No visit history records found.");
            return;
        }
        for (VisitHistory v : list) {
            System.out.println(v);
        }
    }

    // ----------------------------------------------------------------------
    // Input helpers
    // ----------------------------------------------------------------------
    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
