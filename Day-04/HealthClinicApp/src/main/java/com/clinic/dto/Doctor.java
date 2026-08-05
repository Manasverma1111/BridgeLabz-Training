package com.clinic.dto;

/**
 * DTO for Doctor.
 */
public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private Integer specializationId;
    private String specializationName; // convenience field for joined reads
    private String email;
    private String phone;
    private boolean active;

    public Doctor() {
    }

    public Doctor(int doctorId, String firstName, String lastName, Integer specializationId,
                  String email, String phone, boolean active) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializationId = specializationId;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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

    public Integer getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Integer specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
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
        return "Doctor{id=" + doctorId + ", name='Dr. " + firstName + " " + lastName
                + "', specialization='" + specializationName + "', email='" + email
                + "', phone='" + phone + "', active=" + active + "}";
    }
}
