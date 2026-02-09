package dao;

import model.Doctor;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDAO {

    public void addDoctor(Doctor doctor) {

        String sql =
                "INSERT INTO doctors (name, specialization, contact, fee) " + "VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, doctor.getName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getContact());
            ps.setDouble(4, doctor.getFee());

            ps.executeUpdate();
            System.out.println("Doctor added successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewDoctors() {

        String sql = "SELECT * FROM doctors";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\nAvailable Doctors:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("doctor_id") + " - " +
                                rs.getString("name") + " - " +
                                rs.getString("specialization")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
