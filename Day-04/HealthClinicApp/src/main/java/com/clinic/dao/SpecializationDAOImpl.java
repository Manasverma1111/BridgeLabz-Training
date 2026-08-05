package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Specialization;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC implementation of SpecializationDAO.
 * Uses PreparedStatement exclusively + try-with-resources, connections
 * borrowed from HikariConnectionPool.
 */
public class SpecializationDAOImpl implements SpecializationDAO {

    @Override
    public int insertSpecialization(Specialization specialization) {
        String sql = "INSERT INTO specializations (name, description) VALUES (?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, specialization.getName());
            pstmt.setString(2, specialization.getDescription());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                try (ResultSet keys = pstmt.getGeneratedKeys()) {
                    if (keys.next()) {
                        return keys.getInt(1);
                    }
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("A specialization with this name already exists: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Insert failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Specialization getSpecializationById(int id) {
        String sql = "SELECT * FROM specializations WHERE specialization_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        String sql = "SELECT * FROM specializations ORDER BY name";
        List<Specialization> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Query failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateSpecialization(Specialization specialization) {
        String sql = "UPDATE specializations SET name = ?, description = ? WHERE specialization_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, specialization.getName());
            pstmt.setString(2, specialization.getDescription());
            pstmt.setInt(3, specialization.getSpecializationId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteSpecialization(int id) {
        // Hard delete is acceptable here -- specializations are reference/lookup data,
        // not core patient-facing healthcare records requiring audit retention.
        String sql = "DELETE FROM specializations WHERE specialization_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete failed: " + e.getMessage());
            return false;
        }
    }

    private Specialization mapRow(ResultSet rs) throws SQLException {
        Specialization s = new Specialization();
        s.setSpecializationId(rs.getInt("specialization_id"));
        s.setName(rs.getString("name"));
        s.setDescription(rs.getString("description"));
        return s;
    }
}
