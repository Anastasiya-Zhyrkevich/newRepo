package ru.mishachess.epam.task.second.controller.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.mishachess.epam.task.second.entity.Record;
import ru.mishachess.epam.task.second.entity.bean.Request;
import ru.mishachess.epam.task.second.util.SorterByTopic;

public class SortByTopic implements Command {
    private SorterByTopic sorterByTopic = new SorterByTopic();

    
    @Override
    public List<Record> execute(Request request) {
	List<Record> recordList = new ArrayList<Record>(
		request.getNotebook().getRecordList());
	if (recordList == null || recordList.size() == 0) {
	    return Collections.emptyList();
	}
	Collections.sort(recordList, sorterByTopic);
	return recordList;
    }

}
