package model;

public class Prescription{

    private int visitId;
    private String medicine;
    private String dosage;
    private String duration;

    public Prescription(int visitId, String medicine, String dosage, String duration){
        this.visitId = visitId;
        this.medicine = medicine;
        this.dosage = dosage;
        this.duration = duration;
    }

    public int getVisitId(){
        return visitId;
    }
    public String getMedicine(){
        return medicine;
    }
    public String getDosage(){
        return dosage;
    }
    public String getDuration(){
        return duration;
    }
}