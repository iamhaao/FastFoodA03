package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String PHONE_NUMBER_PATTERN = "^[0-9]{10}$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{3,}$";
    private static final String PASSWORD_PATTERN = "^(?=\\S+$).{6,}$";
    private static final String PRICE_PATTERN = "^[0-9]+(\\.[0-9]{1,2})?$";

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public static boolean validateUsername(String username) {
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validatePrice(String price) {
        Pattern pattern = Pattern.compile(PRICE_PATTERN);
        Matcher matcher = pattern.matcher(price);
        if (matcher.matches()) {
            double value = Double.parseDouble(price);
            if (value >= 0.0 && value <= 1000000.0) { // Adjust the range as per your requirements
                return true;
            }
        }
        return false;
    }
}
