package com.epam.mishachess.task.second.controller.command;

import java.text.ParseException;
import java.util.List;

import com.epam.mishachess.task.second.entity.Record;
import com.epam.mishachess.task.second.entity.bean.Request;
import com.epam.mishachess.task.second.exception.IllegalDateValidationException;
import com.epam.mishachess.task.second.exception.IllegalEmailValidationException;

/**
 * @author Mikhail Sadovsky
 * 
 */
public interface Command {
    List<Record> execute(Request request) throws ParseException,
	    IllegalDateValidationException, IllegalEmailValidationException;
}
