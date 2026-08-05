package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Service layer: coordinates multi-step, multi-DAO transactions.
 *
 * completeAppointmentWithBillingAndVisit() implements the exact transactional
 * pattern from Part 5 (Transaction Management): completing an appointment
 * updates its status, inserts a billing record, and inserts a visit history
 * record -- all in ONE atomic transaction (commit/rollback), reusing the same
 * Connection across all three DAO calls. If any step fails, all steps are
 * rolled back so we never end up with an inconsistent state (e.g. an
 * appointment marked "Completed" with no bill).
 */
public class AppointmentService {

    private final AppointmentDAO appointmentDAO;
    private final BillingDAO billingDAO;
    private final VisitHistoryDAO visitHistoryDAO;

    public AppointmentService(AppointmentDAO appointmentDAO, BillingDAO billingDAO,
                               VisitHistoryDAO visitHistoryDAO) {
        this.appointmentDAO = appointmentDAO;
        this.billingDAO = billingDAO;
        this.visitHistoryDAO = visitHistoryDAO;
    }

    /**
     * Completes an appointment atomically:
     *   1. UPDATE appointments SET status = 'Completed'
     *   2. INSERT INTO billing (...)
     *   3. INSERT INTO visit_history (...)
     * All three succeed together, or none apply (full rollback on any failure).
     */
    public boolean completeAppointmentWithBillingAndVisit(int appointmentId, double billingAmount,
                                                            String diagnosis, String prescription,
                                                            String visitNotes) {
        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false); // START TRANSACTION equivalent

            // Step 1: Update appointment status
            boolean statusUpdated = appointmentDAO.updateStatus(conn, appointmentId, "Completed");
            if (!statusUpdated) {
                throw new SQLException("Appointment not found or already completed/cancelled -- aborting transaction.");
            }

            // Step 2: Insert billing record
            Billing billing = new Billing();
            billing.setAppointmentId(appointmentId);
            billing.setAmount(billingAmount);
            billing.setPaymentStatus("Pending");
            billingDAO.insertBilling(conn, billing);

            // Step 3: Insert visit history record
            VisitHistory visit = new VisitHistory();
            visit.setAppointmentId(appointmentId);
            visit.setDiagnosis(diagnosis);
            visit.setPrescription(prescription);
            visit.setVisitNotes(visitNotes);
            visitHistoryDAO.insertVisitHistory(conn, visit);

            conn.commit(); // all three succeeded -- make permanent
            System.out.println("Appointment #" + appointmentId + " completed, billed, and recorded successfully.");
            return true;

        } catch (SQLException e) {
            System.err.println("Transaction failed: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); // undo everything since setAutoCommit(false)
                    System.out.println("Transaction rolled back -- no partial changes were saved.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Rollback failed: " + rollbackEx.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // restore default behavior before returning to pool
                    conn.close(); // returns connection to HikariCP pool
                } catch (SQLException e) {
                    System.err.println("Failed to reset/close connection: " + e.getMessage());
                }
            }
        }
    }
}
