package dao;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicalHistoryDAO {

    public void viewHistory(int patientId) {

        String sql =
                "SELECT v.id, v.diagnosis, p.medicine, p.dosage, a.appointment_date " +
                        "FROM visits v " +
                        "JOIN appointments a ON v.appointment_id = a.id " +
                        "LEFT JOIN prescriptions p ON v.id = p.visit_id " +
                        "WHERE a.patient_id = ? " +
                        "ORDER BY v.visit_date DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("diagnosis") + " " +
                                rs.getString("medicine"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
