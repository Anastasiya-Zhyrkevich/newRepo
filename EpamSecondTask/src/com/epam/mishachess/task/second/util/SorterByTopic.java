package com.epam.mishachess.task.second.util;

import java.util.Comparator;

import com.epam.mishachess.task.second.entity.Record;

/**
 * @author Mikhail Sadovsky
 *
 */
public final class SorterByTopic implements Comparator<Record> {

    @Override
    public int compare(Record record1, Record record2) {

	String topic1 = record1.getTopic();
	String topic2 = record2.getTopic();

	return topic1.compareTo(topic2);
    }
}
