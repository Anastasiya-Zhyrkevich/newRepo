package ru.mishachess.epam.task.second.util;

import java.util.Comparator;

import ru.mishachess.epam.task.second.entity.Record;

public final class SorterByTopic implements Comparator<Record> {

    @Override
    public int compare(Record record1, Record record2) {

	String topic1 = record1.getTopic();
	String topic2 = record2.getTopic();

	return topic1.compareTo(topic2);
    }
}
