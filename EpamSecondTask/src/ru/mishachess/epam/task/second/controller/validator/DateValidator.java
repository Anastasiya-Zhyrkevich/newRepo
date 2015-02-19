package ru.mishachess.epam.task.second.controller.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements Validator {

    @Override
    public boolean validate(final String validString) {
	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

	try {
	    Date date = format.parse(validString);
	    return validString.equals(format.format(date));
	} catch (ParseException e) {
	    return false;
	}

    }
}
