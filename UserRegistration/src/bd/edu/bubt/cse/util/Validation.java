
package bd.edu.bubt.cse.util;

import bd.edu.bubt.cse.customException.PasswordLengthException;
import bd.edu.bubt.cse.customException.PasswordNoCapitalLetterException;
import bd.edu.bubt.cse.customException.PasswordNoDigitException;
import bd.edu.bubt.cse.customException.PasswordNoSmallLetterException;
import bd.edu.bubt.cse.customException.PasswordNoSpecialCharacterException;
import bd.edu.bubt.cse.customException.UsernameContainsSpaceException;
import bd.edu.bubt.cse.customException.UsernameFirstLetterException;
import bd.edu.bubt.cse.customException.ValidationException;

public class Validation {

    public static boolean wordLencgthChecker(String word){
        boolean result = true;

        if(word.length() < 0)
            result = false;

        return result;
    }

    public static boolean wordCharacterChecker(String word, char upperRange, char lowerRange){
        boolean result = false;

        for(int index = 0; index < word.length(); index++){
            if(word.charAt(index) >= lowerRange && word.charAt(index) <= upperRange){
                return true;
            }
        }

        return result;
    }

    public static boolean wordSpecialCharacterChecker(String word){
        boolean result = false;

        for(int index = 0; index < word.length(); index++){
            if(!(word.charAt(index) >= 'A' && word.charAt(index) <= 'Z') &&
                    !(word.charAt(index) >= 'a' && word.charAt(index) <= 'z') &&
                    !(word.charAt(index) >= '0' && word.charAt(index) <= '9') &&
                    !(word.charAt(index) == ' ') ){
                return true;
            }
        }
        return result;
    }
}
