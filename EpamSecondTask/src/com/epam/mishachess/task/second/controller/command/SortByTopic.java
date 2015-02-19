package com.epam.mishachess.task.second.controller.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.mishachess.task.second.entity.Record;
import com.epam.mishachess.task.second.entity.bean.Request;
import com.epam.mishachess.task.second.util.SorterByTopic;

/**
 * @author Mikhail Sadovsky
 *
 */
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
