package com.clinic.dto;

import java.sql.Timestamp;

/**
 * DTO for Appointment.
 */
public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String patientName;  // convenience field for joined reads
    private String doctorName;   // convenience field for joined reads
    private Timestamp appointmentDate;
    private String status; // Scheduled, Completed, Cancelled

    public Appointment() {
    }

    public Appointment(int appointmentId, int patientId, int doctorId,
                        Timestamp appointmentDate, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + appointmentId + "] Patient: " + patientName + " | Doctor: " + doctorName
                + " | " + appointmentDate + " | Status: " + status;
    }
}
