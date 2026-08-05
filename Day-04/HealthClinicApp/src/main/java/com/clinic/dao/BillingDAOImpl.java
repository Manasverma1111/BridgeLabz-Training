package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of BillingDAO.
 *
 * insertBilling() deliberately accepts an external Connection rather than
 * borrowing its own from the pool -- this is what allows AppointmentService to
 * combine an appointment status update + billing insert + visit history insert
 * into one atomic transaction (see Part 5: Transaction Management).
 */
public class BillingDAOImpl implements BillingDAO {

    @Override
    public boolean insertBilling(Connection conn, Billing billing) throws SQLException {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setDouble(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus() == null ? "Pending" : billing.getPaymentStatus());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<Billing> getAllBilling() {
        String sql = "SELECT * FROM billing ORDER BY billing_id";
        List<Billing> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Billing b = new Billing();
                b.setBillingId(rs.getInt("billing_id"));
                b.setAppointmentId(rs.getInt("appointment_id"));
                b.setAmount(rs.getDouble("amount"));
                b.setPaymentStatus(rs.getString("payment_status"));
                b.setBilledAt(rs.getTimestamp("billed_at"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return list;
    }
}
