package main.project.service;

import main.project.model.Account;
import main.project.model.Ewallet;

import java.util.ArrayList;
import java.util.Scanner;


public class ApplicationServiceImpl implements ApplicationService {
    ValidationService validationService = new ValidationServiceImpl();
    AccountService accountService = new AccountServiceImpl();
    Account currentAccount ;
    Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("---------------- Welcome Sir ----------------");

            System.out.println("Please Enter your choose :");
            System.out.print("a.login     b.signup   c.exit   :  ");
            char choose = scanner.next().charAt(0);
            switch (choose) {
                case 'a':
                    login();
                    break;
                case 'b':
                    signup();
                    break;
                case 'c':
                    System.out.println("you are welcome.");
                    return;
                default:
                    System.out.println("Invalid Choose");
            }
        }

    }

    private void signup() {

        System.out.println("-------------- SIGNUP PAGE --------------");
        // TODO Validation on UserName and Password
//
        ArrayList<String>userData;
        do {
            userData = getUserData();
        } while (!validationService.validateUserName(userData.get(0)) || !validationService.validatePassword(userData.get(1)));

        // TODO SERVICE OF ACCOUNT TO CREATE ACCOUNT

       currentAccount= new Account(userData.get(0),userData.get(1));
        if (accountService.createAccount(currentAccount))
        {
            services(currentAccount);
        }
        else
        {
           run();
        }

    }

    private void login() {
        System.out.println("-------------- LOGIN PAGE --------------");

        ArrayList<String>userData;
        // TODO Validation on UserName and Password

        do {
            userData = getUserData();
        } while (!validationService.validateUserName(userData.get(0)) || !validationService.validatePassword(userData.get(1)));


        // TODO SERVICE OF ACCOUNT TO CREATE LOGIN
        if (accountService.loginAccount(userData.get(0),userData.get(1)))
        {
            System.out.println("---------------- LOGIN SUCCESS ----------------");
            services(Ewallet.accounts.get(userData.get(0)));
        }
        else
        {

            run();
        }

    }

    private void services(Account account) {
        System.out.println("---------------- Service PAGE ----------------");
        while (true)
        {
            System.out.print("1.Deposit   " +
                    "2.Withdraw    " +
                    "3.show details    " +
                    "4.Transfer    " +
                    "5. show balance   "+
                    "6. show TransactionHistory "+
                    "7. Back To Main Page    :  "   );
            int choice= scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1 :
                    System.out.println(" PLEASE ENTER THE AMOUNT  : ");
                    int  amount =scanner.nextInt();
                    scanner.nextLine();
                    UserService.deposit(account,amount);

                    break;
                case 2 :
                    System.out.println(" PLEASE ENTER THE AMOUNT  : ");
                    int  value =scanner.nextInt();
                    scanner.nextLine();
                    UserService.withdraw(account,value);
                    break;

                case 3 :
                    UserService.showDetails(account);
                    break;
                case 4 :
                    System.out.println("PLEASE ENTER THE USER NAME OF THE ACCOUNT WANT TO TRANSFER");
                    String accountTransfer= scanner.next();
                    System.out.println("PLEASE ENTER THE AMOUNT TO BE TRANSFERRED");
                    int valueTransfer = scanner.nextInt();
                    scanner.nextLine();
                    UserService.transfer(account,Ewallet.accounts.get(accountTransfer),valueTransfer );
                    break;
                case 5 :
                    UserService.showBalance(account);
                    break;
                case 6 :
                    UserService.showTransactionHistory(account);
                    break;
                case 7 :
                    System.out.println("Returning to the main menu...");
                   return;


            }
        }




    }
    private ArrayList<String> getUserData()
    {
        ArrayList<String>userData=new ArrayList<>();


        System.out.println("Please Enter User name");
        String name = scanner.next();
        userData.add(name);

        System.out.println("Please Enter password");
        String password = scanner.next();
        userData.add(password);

        return userData;
    }


}
