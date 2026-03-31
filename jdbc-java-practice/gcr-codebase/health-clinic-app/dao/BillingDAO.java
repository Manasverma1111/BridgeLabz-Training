package dao;

import model.Bill;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillingDAO {

    /* UC-5.1 Generate Bill */
    public void generateBill(Bill bill) {

        String sql =
                "INSERT INTO bills (visit_id, amount, payment_status, bill_date) " +
                        "VALUES (?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, bill.getVisitId());
            ps.setDouble(2, bill.getAmount());
            ps.setString(3, "UNPAID");
            ps.setString(4, bill.getDate());

            ps.executeUpdate();
            System.out.println("Bill generated successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* UC-5.2 Record Payment */
    public void recordPayment(int billId, String paymentMode) {

        String sql =
                "UPDATE bills " +
                        "SET payment_status = 'PAID', payment_mode = ?, payment_date = NOW() " +
                        "WHERE bill_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, paymentMode);
            ps.setInt(2, billId);

            ps.executeUpdate();
            System.out.println("Payment recorded successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* UC-5.3 View Outstanding Bills */
    public List<Bill> getOutstandingBills() {

        List<Bill> bills = new ArrayList<>();

        String sql =
                "SELECT * FROM bills WHERE payment_status = 'UNPAID'";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Bill bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setVisitId(rs.getInt("visit_id"));
                bill.setAmount(rs.getDouble("amount"));
                bill.setPaymentStatus(rs.getString("payment_status"));

                bills.add(bill);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return bills;
    }

    public void viewBills() {

        String sql = "SELECT * FROM bills";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\nBills:");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("bill_id") +
                                " - Visit: " + rs.getInt("visit_id") +
                                " Amount: " + rs.getDouble("amount") +
                                " Status: " + rs.getString("payment_status")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* UC-5.4 Revenue Report */
    public double getRevenue(String startDate, String endDate) {

        double total = 0;

        String sql =
                "SELECT SUM(amount) " +
                        "FROM bills " +
                        "WHERE payment_status = 'PAID' " +
                        "AND payment_date BETWEEN ? AND ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, startDate);
            ps.setString(2, endDate);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
}
