package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of DoctorDAO.
 */
public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, specialization_id, email, phone) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            if (doctor.getSpecializationId() != null) {
                pstmt.setInt(3, doctor.getSpecializationId());
            } else {
                pstmt.setNull(3, Types.INTEGER);
            }
            pstmt.setString(4, doctor.getEmail());
            pstmt.setString(5, doctor.getPhone());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        return keys.getInt(1);
                    }
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("A doctor with this email already exists: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Doctor getDoctorById(int id) {
        String sql = "SELECT d.*, s.name AS specialization_name FROM doctors d "
                + "LEFT JOIN specializations s ON d.specialization_id = s.specialization_id "
                + "WHERE d.doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToDoctor(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        // LEFT JOIN because a doctor might not yet have a specialization assigned
        String sql = "SELECT d.*, s.name AS specialization_name FROM doctors d "
                + "LEFT JOIN specializations s ON d.specialization_id = s.specialization_id "
                + "WHERE d.is_active = TRUE ORDER BY d.doctor_id";
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                doctors.add(mapRowToDoctor(rs));
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return doctors;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name = ?, last_name = ?, specialization_id = ?, "
                + "email = ?, phone = ? WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            if (doctor.getSpecializationId() != null) {
                pstmt.setInt(3, doctor.getSpecializationId());
            } else {
                pstmt.setNull(3, Types.INTEGER);
            }
            pstmt.setString(4, doctor.getEmail());
            pstmt.setString(5, doctor.getPhone());
            pstmt.setInt(6, doctor.getDoctorId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        String sql = "UPDATE doctors SET is_active = FALSE WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    private Doctor mapRowToDoctor(ResultSet rs) throws SQLException {
        Doctor d = new Doctor();
        d.setDoctorId(rs.getInt("doctor_id"));
        d.setFirstName(rs.getString("first_name"));
        d.setLastName(rs.getString("last_name"));
        int specId = rs.getInt("specialization_id");
        d.setSpecializationId(rs.wasNull() ? null : specId);
        d.setSpecializationName(rs.getString("specialization_name"));
        d.setEmail(rs.getString("email"));
        d.setPhone(rs.getString("phone"));
        d.setActive(rs.getBoolean("is_active"));
        return d;
    }
}
