package main.project.model;

import java.util.ArrayList;

;
public class Account {

    private String userName;
    private String password;
    private int  balance;
    private String active;
    private ArrayList<Transaction> TransactionHistory;

    public Account() {
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
        TransactionHistory=new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return TransactionHistory;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int  getBalance() {
        return balance;
    }

    public void setBalance(int  balance) {
        this.balance = balance;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    public String toString()
    {
        return " USER Name : " + this.userName +" BALANCE : " + this.balance;
    }

}
