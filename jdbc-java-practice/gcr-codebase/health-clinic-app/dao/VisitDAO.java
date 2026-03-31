package dao;

import model.Visit;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VisitDAO {

    public int recordVisitAndCompleteAppointment(Visit visit) {

        int visitId = 0;

        String sql =
                "INSERT INTO visits (appointment_id, diagnosis, notes, visit_date) " + "VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps =
                        con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setString(2, visit.getDiagnosis());
            ps.setString(3, visit.getNotes());
            ps.setString(4, visit.getVisitDate());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                visitId = rs.getInt(1);
            }

            System.out.println("Visit recorded successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return visitId;
    }

    public void viewVisits() {

        String sql = "SELECT * FROM visits";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\nVisits:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("visit_id") +
                                " - Appointment: " +
                                rs.getInt("appointment_id") +
                                " Date: " +
                                rs.getString("visit_date")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
