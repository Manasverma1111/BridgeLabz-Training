package dao;

import model.Prescription;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PrescriptionDAO {

    public void addPrescriptionBatch(List<Prescription> list) {

        String sql =
                "INSERT INTO prescriptions (visit_id, medicine, dosage, duration) " + "VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            for (Prescription prescription : list) {

                ps.setInt(1, prescription.getVisitId());
                ps.setString(2, prescription.getMedicine());
                ps.setString(3, prescription.getDosage());
                ps.setString(4, prescription.getDuration());

                ps.addBatch();
            }

            ps.executeBatch();
            System.out.println("Prescriptions added successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
