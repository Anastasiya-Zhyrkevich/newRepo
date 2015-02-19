package com.epam.mishachess.task.second.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Notebook implements Serializable {
    private List<Record> records = new ArrayList<Record>();

    public void addRecord(Record record) {
	if (record == null) {
	    throw new IllegalArgumentException(" Record is null");
	}
	records.add(record);
    }

    public void deleteRecord(Record record) {
	if (records.contains(record)) {
	    records.remove(record);
	}
    }

    public Record getRecord(int index) {
	if (index < 0 || index > records.size()) {
	    throw new IllegalArgumentException(" No such index in records list");
	}
	return records.get(index);
    }

    public void setRecord(int index, Record record) {
	if (index >= 0 && index <= records.size() && record != null) {
	    records.set(index, record);
	}
    }

    public List<Record> getRecordList() {
	return Collections.unmodifiableList(records);
    }

    public void setRecords(List<Record> records) {
	if (records != null) {
	    this.records = records;
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((records == null) ? 0 : records.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Notebook other = (Notebook) obj;
	if (records == null) {
	    if (other.records != null) {
		return false;
	    }
	} else if (!records.equals(other.records)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Notebook records=" + records;
    }

}
