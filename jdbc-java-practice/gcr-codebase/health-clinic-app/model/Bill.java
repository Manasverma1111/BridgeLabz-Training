package model;

public class Bill{

    private int billId;
    private int visitId;
    private double amount;
    private String paymentStatus;
    private String paymentMode;
    private String date;

    public Bill(){}

    public Bill(int visitId, double amount, String date){
        this.visitId = visitId;
        this.amount = amount;
        this.date = date;
    }

    public int getBillId(){

        return billId;
    }

    public void setBillId(int billId){
        this.billId=billId;
    }

    public int getVisitId(){
        return visitId;
    }

    public void setVisitId(int visitId){
        this.visitId=visitId;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public String getPaymentStatus(){
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus=paymentStatus;
    }

    public String getPaymentMode(){
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode){
        this.paymentMode=paymentMode;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }
}