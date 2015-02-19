package com.epam.mishachess.task.second.entity.bean;

import java.util.ArrayList;
import java.util.List;

import com.epam.mishachess.task.second.entity.Record;

public class Response {
    private List<Record> records = new ArrayList<Record>();
    private String message;

    public Response(String message) {
	setMessage(message);
    }

    public Response(List<Record> records) {
	setRecords(records);
    }

    public List<Record> getRecords() {
	return records;
    }

    public void setRecords(List<Record> records) {
	this.records = records;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((message == null) ? 0 : message.hashCode());
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
	Response other = (Response) obj;
	if (message == null) {
	    if (other.message != null) {
		return false;
	    }
	} else if (!message.equals(other.message)) {
	    return false;
	}
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
	StringBuilder result = new StringBuilder();
	result.append(this.getClass().getName());
	result.append(" Records: " + records);
	result.append(" Message: " + message);
	return result.toString();
    }

}