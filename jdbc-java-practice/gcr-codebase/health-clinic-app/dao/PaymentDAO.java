package dao;

import model.Payment;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    public void recordPayment(Payment payment) {

        String insertPayment =
                "INSERT INTO payments (bill_id, payment_mode, payment_date) " +
                        "VALUES (?, ?, ?)";

        String updateBill =
                "UPDATE bills SET payment_status = 'PAID' WHERE id = ?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false);

            try (
                    PreparedStatement psInsert = con.prepareStatement(insertPayment);
                    PreparedStatement psUpdate = con.prepareStatement(updateBill)
            ) {

                psInsert.setInt(1, payment.getBillId());
                psInsert.setString(2, payment.getMode());
                psInsert.setString(3, payment.getDate());
                psInsert.executeUpdate();

                psUpdate.setInt(1, payment.getBillId());
                psUpdate.executeUpdate();

                con.commit();
                System.out.println("Payment recorded successfully");

            } catch (Exception e) {

                con.rollback();
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
