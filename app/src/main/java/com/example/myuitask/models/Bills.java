package com.example.myuitask.models;

public class Bills {

    private String billDate;
    private String amount;


    public Bills(String date, String amount){
        this.billDate =date;
        this.amount = amount;
    }
    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
