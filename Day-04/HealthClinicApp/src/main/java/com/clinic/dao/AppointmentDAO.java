package com.clinic.dao;

import com.clinic.dto.Appointment;

import java.sql.Connection;
import java.util.List;

public interface AppointmentDAO {
    int insertAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    boolean cancelAppointment(int appointmentId);

    /**
     * Updates the appointment's status using a caller-supplied Connection so this
     * write can participate in a larger multi-step transaction managed by a
     * service-layer class (see AppointmentService). Does NOT commit or close
     * the connection -- the caller owns the transaction boundary.
     */
    boolean updateStatus(Connection conn, int appointmentId, String newStatus) throws java.sql.SQLException;
}
