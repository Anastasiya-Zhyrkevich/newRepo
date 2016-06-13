package com.epam.mishachess.task.second.controller.command;

import java.text.ParseException;
import java.util.List;

import com.epam.mishachess.task.second.entity.Record;
import com.epam.mishachess.task.second.entity.bean.Request;
import com.epam.mishachess.task.second.exception.IllegalDateValidationException;
import com.epam.mishachess.task.second.exception.IllegalEmailValidationException;
import com.epam.mishachess.task.second.util.Validator;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class AddRecord implements Command {

    @Override
    public List<Record> execute(Request request) throws ParseException,
	    IllegalDateValidationException, IllegalEmailValidationException {
	String[] requestParameters = request.getRequestParameters();
	if (!Validator.validateDate(requestParameters[1], "d/M/yyyy")) {
	    throw new IllegalDateValidationException();
	}
	if (!Validator
		.validateEmail(
			requestParameters[2],
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
	    throw new IllegalEmailValidationException();
	}

	Record record = new Record(requestParameters[0], requestParameters[1],
		requestParameters[2], requestParameters[3]);
	request.getNotebook().addRecord(record);
	return request.getNotebook().getRecordList();
    }

}
