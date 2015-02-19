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
public class FindByEmail implements Command {

    @Override
    public List<Record> execute(Request request) {
	List<Record> recordList = new ArrayList<Record>();
	for (Record record : request.getNotebook().getRecordList()) {
	    if (Pattern.matches(request.getRequestParameters()[0],
		    record.getEmail())) {
		recordList.add(record);
	    }
	}
	return recordList;
    }

}
