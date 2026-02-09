package model;

public class Visit{

    private int appointmentId;
    private String diagnosis;
    private String notes;
    private String visitDate;

    public Visit(int appointmentId, String diagnosis, String notes, String date){
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.visitDate = date;
    }

    public int getAppointmentId(){
        return appointmentId;
    }
    public String getDiagnosis(){
        return diagnosis;
    }
    public String getNotes(){
        return notes;
    }
    public String getVisitDate(){
        return visitDate;
    }
}