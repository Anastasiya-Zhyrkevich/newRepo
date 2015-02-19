package com.epam.mishachess.task.second.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.mishachess.task.second.entity.Record;
import com.epam.mishachess.task.second.entity.bean.Request;

/**
 * @author Mikhail Sadovsky
 *
 */
public class FindByMessageWord implements Command {

    @Override
    public List<Record> execute(Request request) {
	List<Record> recordList = new ArrayList<Record>();
	for (Record record : request.getNotebook().getRecordList()) {
	    Matcher matcher = Pattern
		    .compile(request.getRequestParameters()[0]).matcher(
			    record.getMessage());
	    if (matcher.find()) {
		recordList.add(record);
	    }
	}
	return recordList;
    }

}
