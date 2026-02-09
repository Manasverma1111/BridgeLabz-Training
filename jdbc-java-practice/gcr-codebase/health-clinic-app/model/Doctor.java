package model;

public class Doctor{

    private int id;
    private String name;
    private String specialization;
    private String contact;
    private double fee;

    public Doctor(String name,String specialization,String contact,double fee){
        this.name=name;
        this.specialization=specialization;
        this.contact=contact;
        this.fee=fee;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public String getContact(){return contact;}
    public double getFee(){return fee;}
}