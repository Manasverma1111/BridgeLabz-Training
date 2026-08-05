package com.clinic.dao;

import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitHistoryDAO {

    /**
     * Inserts a visit history record using a caller-supplied Connection so this
     * write can participate in a larger multi-step transaction (see AppointmentService).
     * Does NOT commit or close the connection.
     */
    boolean insertVisitHistory(Connection conn, VisitHistory visitHistory) throws SQLException;

    List<VisitHistory> getAllVisitHistory();
}
