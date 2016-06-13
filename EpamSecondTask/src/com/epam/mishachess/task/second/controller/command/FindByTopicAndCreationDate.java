package com.epam.mishachess.task.second.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.epam.mishachess.task.second.entity.Record;
import com.epam.mishachess.task.second.entity.bean.Request;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class FindByTopicAndCreationDate implements Command {

    @Override
    public List<Record> execute(Request request) {
	String[] parameters = request.getRequestParameters();
	List<Record> recordList = new ArrayList<Record>();
	for (Record record : request.getNotebook().getRecordList()) {
	    if (Pattern.matches(parameters[0], record.getTopic())) {
		if (Pattern.matches(parameters[1], record.getCreationDate())) {
		    recordList.add(record);
		}
	    }
	}
	return recordList;
    }

}
