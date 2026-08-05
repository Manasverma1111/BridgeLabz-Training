package com.clinic.dao;

import com.clinic.dto.Billing;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillingDAO {

    /**
     * Inserts a billing record using a caller-supplied Connection so this write
     * can participate in a larger multi-step transaction (see AppointmentService).
     * Does NOT commit or close the connection.
     */
    boolean insertBilling(Connection conn, Billing billing) throws SQLException;

    List<Billing> getAllBilling();
}
