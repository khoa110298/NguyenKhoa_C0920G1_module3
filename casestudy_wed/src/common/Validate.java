package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String PHONE_NUMBER_CHECKING = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_EMAIL = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final String REGEX_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String REGEX_CUSTOMER_ID ="^(KH-)\\d{4}$";


    public static void regexPhone(String phone) throws PhoneException {
        pattern = Pattern.compile(REGEX_PHONE);
        matcher = pattern.matcher(phone);

        if (!matcher.find()) throw new PhoneException("Number Phone Format Exception (090|091)XXXXXXX !!!");
    }

    public static void regexDate(String date) throws BirthdayException {
        pattern = Pattern.compile(REGEX_DATE);
        matcher = pattern.matcher(date);

        if (!matcher.find()) throw new BirthdayException("Date Format Exception (dd/mm/YYYY)!!!");
    }

    public static void regexEmail(String email) throws EmailException {
        pattern = Pattern.compile(REGEX_EMAIL);
        matcher = pattern.matcher(email);

        if (!matcher.find()) throw new EmailException("mail Format Exception (abc@abc.abc)!!!");
    }
}
