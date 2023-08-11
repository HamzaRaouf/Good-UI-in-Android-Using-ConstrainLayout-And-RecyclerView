package com.example.myuitask.models;

public class Transaction {
    private String transactionCategory;
    private String date;
    private String amount;

    public Transaction(String cat, String date, String amount){
        this.transactionCategory = cat;
        this.date = date;
        this.amount = amount;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getDatee() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
