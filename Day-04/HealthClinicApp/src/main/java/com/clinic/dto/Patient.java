package com.clinic.dto;

import java.sql.Date;

/**
 * DTO (Data Transfer Object) for Patient.
 * Pure data carrier -- no business logic, no JDBC/SQL code.
 */
public class Patient {

    private int patientId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private boolean active;

    public Patient() {
    }

    public Patient(int patientId, String firstName, String lastName, Date dateOfBirth,
                   String gender, String email, String phone, boolean active) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Patient{id=" + patientId + ", name='" + firstName + " " + lastName
                + "', dob=" + dateOfBirth + ", gender='" + gender + "', email='" + email
                + "', phone='" + phone + "', active=" + active + "}";
    }
}
