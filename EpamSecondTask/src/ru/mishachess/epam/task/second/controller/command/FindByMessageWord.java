package ru.mishachess.epam.task.second.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.mishachess.epam.task.second.entity.Record;
import ru.mishachess.epam.task.second.entity.bean.Request;

public class FindByMessageWord implements Command {

    @Override
    public List<Record> execute(Request request) {
	List<Record> recordList = new ArrayList<Record>();
	for (Record record : request.getNotebook().getRecordList()) {
	    Matcher matcher = Pattern.compile(request.getRequestParameter())
		    .matcher(record.getMessage());
	    if (matcher.find()) {
		recordList.add(record);
	    }
	}
	return recordList;
    }

}
