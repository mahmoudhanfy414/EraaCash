package main.project.service;

import main.project.model.Account;
import main.project.model.Ewallet;
import main.project.model.Transaction;

public class UserService {

     public static   void showBalance(Account account)
    {
        System.out.println( "YOUR BALANCE IS " + account.getBalance());
    }
    public static void transfer(Account account1,Account account2,int balance)
    {
        if (Ewallet.accounts.containsKey(account1.getUserName())
                &&account2 != null && ! account2.getUserName().equals(account1.getUserName()))
        {
            if (account1.getBalance()>=balance)
            {
                account2.setBalance(account2.getBalance()+balance);
                account1.setBalance(account1.getBalance()-balance);
                System.out.println("TRANSFERRED SUCCESSFULLY");
                String tranAmountForAcc1=("-"+balance);
                String tranAmountForAcc2=("+"+balance);
                account1.getTransactionHistory().add(new Transaction(account2.getUserName(),"TRANSFER",tranAmountForAcc1));
                account2.getTransactionHistory().add(new Transaction(account1.getUserName(),"TRANSFER",tranAmountForAcc2));

            }
            else
            {
                System.out.println("NOT ENOUGH BALANCE");
            }

        }
        else {
            System.out.println("THIS ACCOUNT NOT FOUND");
        }

    }
    public static void deposit(Account account, int amount) {
        if (Ewallet.accounts.containsKey(account.getUserName())) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Balance after deposit: " + account.getBalance());
            String tranAmount=("+"+amount);
            account.getTransactionHistory().add(new Transaction(account.getUserName(),"Deposit",tranAmount));

        } else {
            System.out.println("Account not found in Ewallet.accounts");
        }
    }
    public static void showDetails(Account account)
    {
        System.out.println( account.toString());
    }
    public static void withdraw (Account account, int amount)
    {
        if (account.getBalance()>=amount)
        {
            account.setBalance(account.getBalance()-amount);
            System.out.println("YOUR BALANCE AFTER WITHDRAW IS " + account.getBalance() );
            String tranAmount=("-"+amount);
            account.getTransactionHistory().add(new Transaction(account.getUserName(),"WITHDRAW",tranAmount));
        }
        else
        {
            System.out.println("NOT ENOUGH BALANCE");
        }

    }
    public static void showTransactionHistory(Account account)
    {
        for(Transaction t : account.getTransactionHistory())
        {
            System.out.println(t);
        }
    }
}
