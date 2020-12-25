package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Pattern pattern;
    private static Matcher matcher;

//    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_PHONE = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}";
    private static final String REGEX_DATE = "^\\d{4}(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
    private static final String REGEX_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String REGEX_CUSTOMER_ID ="^(KH-)\\d{4}$";
    private static final String REGEX_SERVICE_ID ="^(DV-)\\d{4}$";

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
    public static void regexIdCustomer(String idCustomer) throws ValidateException {
        pattern = Pattern.compile(REGEX_CUSTOMER_ID);
        matcher = pattern.matcher(idCustomer);

        if (!matcher.find()) throw new ValidateException("Id Customer Format Exception (KH-XXXX) !!!");
    }
    public static void regexIdService(String idService) throws ValidateException {
        pattern = Pattern.compile(REGEX_SERVICE_ID);
        matcher = pattern.matcher(idService);

        if (!matcher.find()) throw new ValidateException("Id Service Format Exception (DV-XXXX) !!!");
    }
    public static void regexIdCard(String idcard) throws ValidateException {
        pattern = Pattern.compile(REGEX_ID_CARD);
        matcher = pattern.matcher(idcard);

        if (!matcher.find()) throw new ValidateException("Id card Format Exception (XXXXXXXXX) or (XXXXXXXXXXXX)  !!!");
    }
}
