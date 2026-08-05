package com.clinic.dto;

import java.sql.Timestamp;

/**
 * DTO for Billing.
 */
public class Billing {

    private int billingId;
    private int appointmentId;
    private double amount;
    private String paymentStatus; // Pending, Paid, Cancelled
    private Timestamp billedAt;

    public Billing() {
    }

    public Billing(int billingId, int appointmentId, double amount,
                    String paymentStatus, Timestamp billedAt) {
        this.billingId = billingId;
        this.appointmentId = appointmentId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.billedAt = billedAt;
    }

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getBilledAt() {
        return billedAt;
    }

    public void setBilledAt(Timestamp billedAt) {
        this.billedAt = billedAt;
    }

    @Override
    public String toString() {
        return "Billing{id=" + billingId + ", appointmentId=" + appointmentId
                + ", amount=" + amount + ", status='" + paymentStatus
                + "', billedAt=" + billedAt + "}";
    }
}
