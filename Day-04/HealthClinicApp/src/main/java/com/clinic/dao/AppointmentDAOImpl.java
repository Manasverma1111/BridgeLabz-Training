package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of AppointmentDAO.
 */
public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public int insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) "
                + "VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getStatus() == null ? "Scheduled" : appointment.getStatus());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        return keys.getInt(1);
                    }
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Invalid patient/doctor reference: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT a.*, "
                + "CONCAT(p.first_name, ' ', p.last_name) AS patient_name, "
                + "CONCAT(d.first_name, ' ', d.last_name) AS doctor_name "
                + "FROM appointments a "
                + "JOIN patients p ON a.patient_id = p.patient_id "
                + "JOIN doctors d ON a.doctor_id = d.doctor_id "
                + "WHERE a.appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToAppointment(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        // LEFT JOIN not required here -- FK guarantees patient/doctor always exist,
        // but a patient may have zero appointments (see PatientDAO reads elsewhere).
        String sql = "SELECT a.*, "
                + "CONCAT(p.first_name, ' ', p.last_name) AS patient_name, "
                + "CONCAT(d.first_name, ' ', d.last_name) AS doctor_name "
                + "FROM appointments a "
                + "JOIN patients p ON a.patient_id = p.patient_id "
                + "JOIN doctors d ON a.doctor_id = d.doctor_id "
                + "ORDER BY a.appointment_date";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                appointments.add(mapRowToAppointment(rs));
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return appointments;
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        // Soft delete pattern -- status flag preserves audit history.
        String sql = "UPDATE appointments SET status = 'Cancelled' WHERE appointment_id = ? "
                + "AND status = 'Scheduled'";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Cancel failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateStatus(Connection conn, int appointmentId, String newStatus) throws SQLException {
        // Uses the connection supplied by the caller (service layer) so this write
        // participates in the caller's transaction -- does not open/close/commit itself.
        String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newStatus);
            pstmt.setInt(2, appointmentId);
            return pstmt.executeUpdate() > 0;
        }
    }

    private Appointment mapRowToAppointment(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setAppointmentId(rs.getInt("appointment_id"));
        a.setPatientId(rs.getInt("patient_id"));
        a.setDoctorId(rs.getInt("doctor_id"));
        a.setPatientName(rs.getString("patient_name"));
        a.setDoctorName(rs.getString("doctor_name"));
        a.setAppointmentDate(rs.getTimestamp("appointment_date"));
        a.setStatus(rs.getString("status"));
        return a;
    }
}
