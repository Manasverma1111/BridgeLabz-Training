package model;

public class Patient{

    private int id;
    private String name;
    private String dob;
    private String contact;
    private String address;
    private String bloodGroup;

    public Patient(String name, String dob, String contact, String address, String bloodGroup){
        this.name = name;
        this.dob = dob;
        this.contact = contact;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public String getDob(){
        return dob;
    }
    public String getContact(){
        return contact;
    }
    public String getAddress(){
        return address;
    }
    public String getBloodGroup(){
        return bloodGroup;
    }
}