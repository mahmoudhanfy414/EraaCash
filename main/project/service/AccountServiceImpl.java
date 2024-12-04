package main.project.service;

import main.project.model.Account;
import main.project.model.Ewallet;

public class AccountServiceImpl implements AccountService {


    @Override
    public boolean createAccount(Account account) {
        // 1. check if this account is already found
       if( Ewallet.accounts.containsKey(account.getUserName()))
       {
           System.out.println("THIS ACCOUNT IS ALREADY FOUND ");

           return false;
       }
       else // if not add it in accounts map
       {

           Ewallet.accounts.put(account.getUserName(),account);
           System.out.println("THIS ACCOUNT CREATED SUCCESSFULLY ");

           return true;
       }

    }

    @Override
    public boolean loginAccount(String  userName,String password)
    {
        if( Ewallet.accounts.containsKey(userName) )
        {
          if (password.equals(Ewallet.accounts.get(userName).getPassword()))
          {
              return true;
          }
          else
          {
              System.out.println("INCORRECT PASSWORD");
              return false;

          }
        }
        System.out.println("---------------- ACCOUNT DOES NOT EXIST  ----------------");
        return false;
    }
}
