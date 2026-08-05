package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of PatientDAO.
 * All SQL/JDBC code for the Patient entity lives here and only here.
 */
public class PatientDAOImpl implements PatientDAO {

    @Override
    public int insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, gender, email, phone) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, patient.getDateOfBirth());
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getEmail());
            pstmt.setString(6, patient.getPhone());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        return keys.getInt(1);
                    }
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("A patient with this email already exists: " + e.getMessage());
        } catch (SQLTimeoutException e) {
            System.err.println("Database query timed out -- try again later: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Insert failed [SQLState: " + e.getSQLState()
                    + ", ErrorCode: " + e.getErrorCode() + "]: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToPatient(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patients WHERE is_active = TRUE ORDER BY patient_id";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                patients.add(mapRowToPatient(rs));
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?, "
                + "gender = ?, email = ?, phone = ? WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, patient.getDateOfBirth());
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getEmail());
            pstmt.setString(6, patient.getPhone());
            pstmt.setInt(7, patient.getPatientId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePatient(int id) {
        // Soft delete pattern -- preserves audit trail for healthcare compliance.
        String sql = "UPDATE patients SET is_active = FALSE WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    // Helper method -- avoids duplicating row-mapping code across methods
    private Patient mapRowToPatient(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setPatientId(rs.getInt("patient_id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        p.setDateOfBirth(rs.getDate("date_of_birth"));
        p.setGender(rs.getString("gender"));
        p.setEmail(rs.getString("email"));
        p.setPhone(rs.getString("phone"));
        p.setActive(rs.getBoolean("is_active"));
        return p;
    }
}
