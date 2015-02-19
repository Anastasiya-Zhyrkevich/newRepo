package ru.mishachess.epam.task.second.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
	pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean validate(final String validString) {
	matcher = pattern.matcher(validString);

	return matcher.matches();
    }

}
