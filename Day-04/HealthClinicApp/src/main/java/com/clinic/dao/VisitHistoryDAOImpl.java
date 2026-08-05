package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of VisitHistoryDAO.
 *
 * insertVisitHistory() accepts an external Connection for the same reason as
 * BillingDAOImpl.insertBilling() -- to participate in AppointmentService's
 * single atomic transaction.
 */
public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public boolean insertVisitHistory(Connection conn, VisitHistory visitHistory) throws SQLException {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) "
                + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, visitHistory.getAppointmentId());
            pstmt.setString(2, visitHistory.getDiagnosis());
            pstmt.setString(3, visitHistory.getPrescription());
            pstmt.setString(4, visitHistory.getVisitNotes());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<VisitHistory> getAllVisitHistory() {
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        List<VisitHistory> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                VisitHistory v = new VisitHistory();
                v.setVisitId(rs.getInt("visit_id"));
                v.setAppointmentId(rs.getInt("appointment_id"));
                v.setDiagnosis(rs.getString("diagnosis"));
                v.setPrescription(rs.getString("prescription"));
                v.setVisitNotes(rs.getString("visit_notes"));
                v.setCreatedAt(rs.getTimestamp("created_at"));
                list.add(v);
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return list;
    }
}
