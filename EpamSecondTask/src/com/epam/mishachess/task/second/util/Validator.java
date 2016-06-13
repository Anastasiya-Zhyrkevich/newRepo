package com.epam.mishachess.task.second.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Mikhail Sadovsky
 * 
 */
public final class Validator {

    private Validator() {

    }

    public static boolean validateEmail(String validString, String emailPattern) {
	if (!Pattern.matches(emailPattern, validString)) {
	    return false;
	}
	return true;
    }

    public static boolean validateDate(String validString, String datePattern)
	    throws ParseException {
	SimpleDateFormat format = new SimpleDateFormat(datePattern);
	Date date = format.parse(validString);
	if (!validString.equals(format.format(date))) {
	    return false;
	}
	return true;
    }

}
