package addressbook.model;

import java.util.Objects;

public class ContactC {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    public ContactC(String firstName,String lastName,String address,String city,String state,String zip,String phone,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone=phone;
        this.email=email;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getZip(){
        return zip;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }


    public void setAddress(String address){
        this.address=address;
    }

    public void setCity(String city){
        this.city=city;
    }

    public void setState(String state){
        this.state=state;
    }

    public void setZip(String zip){
        this.zip=zip;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setEmail(String email){
        this.email=email;
    }

    // Use Case 7: Duplicate Check using Name
    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj==null||getClass()!=obj.getClass())return false;
        ContactC contact=(ContactC)obj;
        return firstName.equalsIgnoreCase(contact.firstName)&&lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName.toLowerCase(),lastName.toLowerCase());
    }

    @Override
    public String toString(){
        return "Name:"+firstName+" "+lastName+", Address:"+address+", City:"+city+", State:"+state+", Zip:"+zip+", Phone:"+phone+", Email:"+email;
    }
}