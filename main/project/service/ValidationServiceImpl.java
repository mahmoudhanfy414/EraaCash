package main.project.service;

import java.util.Map;

public class ValidationServiceImpl implements ValidationService {


    @Override
    public boolean validateUserName(String userName)
    {
        if (userName.length()>=6)
        {
            for(int i=0;i<userName.length()-1;++i)
            {
                //must contain a number and alphaptics only
                if (!(Character.isAlphabetic(userName.charAt(i))||Character.isDigit(userName.charAt(i))))
                {
                    System.out.println("Alphabetic and Numbers only are Allowed ");
                    return false;
                }
            }

            return  true;
        }
        System.out.println("At least 6 character allowed ");
        return false;
    }

    @Override
    public boolean validatePassword(String password)
    {
        if (password.length()>=10) //must bigger than or equal 10 character
        {
            // having a special character
            for(int i=0;i<password.length()-1;++i)
            {
                if (!(Character.isAlphabetic(password.charAt(i))||Character.isDigit(password.charAt(i))))
                {
                    return true;
                }
            }
            System.out.println("Password must contain at least one special character [@ , ! , $ , &]");
            return false;
        }
        System.out.println("Password must contain at least 10 character ");
        return false;
    }
}
