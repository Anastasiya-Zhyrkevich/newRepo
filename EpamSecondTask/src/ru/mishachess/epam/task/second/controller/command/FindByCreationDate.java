package ru.mishachess.epam.task.second.controller.command;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import ru.mishachess.epam.task.second.entity.Record;
import ru.mishachess.epam.task.second.entity.bean.Request;

public class FindByCreationDate implements Command {

    @Override
    public List<Record> execute(Request request) {
	List<Record> recordList = new ArrayList<Record>();
	for (Record record : request.getNotebook().getRecordList()) {
	    if (Pattern.matches(request.getRequestParameter(),
		    record.getCreationDate())) {
		recordList.add(record);
	    }
	}
	return recordList;
    }

}
