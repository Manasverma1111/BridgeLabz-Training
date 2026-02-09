package model;

public class Appointment{

    private int patientId;
    private int doctorId;
    private String date;
    private String time;

    public Appointment(int patientId, int doctorId, String date, String time){
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public int getPatientId(){
        return patientId;
    }
    public int getDoctorId(){
        return doctorId;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
}