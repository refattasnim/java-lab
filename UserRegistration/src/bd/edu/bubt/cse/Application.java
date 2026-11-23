package bd.edu.bubt.cse;

import java.util.Scanner;

import bd.edu.bubt.cse.customException.*;
import bd.edu.bubt.cse.util.Validation;

public class Application {
    public static void main(String[] args){
        boolean isRegistrationSuccessful = true;
        String userName;
        String password;
        Scanner scanner = new Scanner(System.in);

        do{
            isRegistrationSuccessful = true;
            String errorMessage = "";

            System.out.println("Enter your username:");
            userName = scanner.nextLine();

            System.out.println("Enter your password:");
            password = scanner.nextLine();

            try {
                if(userName.length()>0) {
                    String firstChar = String.valueOf(userName.charAt(0));
                    if (!Validation.wordCharacterChecker(firstChar, 'Z', 'A') ||
                            !Validation.wordCharacterChecker(firstChar, 'z', 'a')) {
                        throw new UsernameFirstLetterException();
                    }
                }
            }
            catch (UsernameFirstLetterException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(Validation.wordCharacterChecker(userName,' ',' ')){
                    throw new UsernameContainsSpaceException();
                }

            }
            catch (UsernameContainsSpaceException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(Validation.wordLencgthChecker(password)){
                    throw new PasswordLengthException();
                }

            }
            catch (PasswordLengthException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(!Validation.wordCharacterChecker(password,'Z','A')){
                    throw new PasswordNoCapitalLetterException();
                }

            }
            catch (PasswordNoCapitalLetterException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(!Validation.wordCharacterChecker(password,'z','a')){
                    throw new PasswordNoSmallLetterException();
                }
            }
            catch (PasswordNoSmallLetterException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(!Validation.wordCharacterChecker(password,'0','9')){
                    throw new PasswordNoDigitException();
                }
            }
            catch (PasswordNoDigitException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            try {
                if(!Validation.wordSpecialCharacterChecker(password)){
                    throw new PasswordNoSpecialCharacterException();
                }
            }
            catch (PasswordNoSpecialCharacterException exception){
                errorMessage += exception.getMessage() + "\n";
                isRegistrationSuccessful = false;
            }

            System.out.println(errorMessage);

        }
        while(!isRegistrationSuccessful);

        System.out.println("User registration is successful!");
    }
}
