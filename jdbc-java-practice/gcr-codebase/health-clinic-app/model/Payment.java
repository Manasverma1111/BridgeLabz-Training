package model;

public class Payment{

    private int billId;
    private String mode;
    private String date;

    public Payment(int billId, String mode, String date){
        this.billId = billId;
        this.mode = mode;
        this.date = date;
    }

    public int getBillId(){
        return billId;
    }
    public String getMode(){
        return mode;
    }
    public String getDate(){
        return date;
    }
}