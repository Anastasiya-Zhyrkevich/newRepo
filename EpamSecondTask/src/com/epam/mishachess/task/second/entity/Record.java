package com.epam.mishachess.task.second.entity;

import java.io.Serializable;

/**
 * @author Mikhail Sadovsky
 *
 */
public class Record implements Serializable {
    private String topic;
    private String creationDate;
    private String email;
    private String message;

    public Record(String topic, String creationDate, String email,
	    String message) {
	setTopic(topic);
	setCreationDate(creationDate);
	setEmail(email);
	setMessage(message);
    }

    public String getTopic() {
	return topic;
    }

    public void setTopic(String topic) {
	if (topic == null) {
	    throw new IllegalArgumentException("topic can't be null");
	}
	this.topic = topic;
    }

    public String getCreationDate() {
	return creationDate;
    }

    public void setCreationDate(String creationDate) {
	if (creationDate == null) {
	    throw new IllegalArgumentException("creation date can't be null");
	}
	this.creationDate = creationDate;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	if (email == null) {
	    throw new IllegalArgumentException("email can't be null");
	}
	this.email = email;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	if (message == null) {
	    throw new IllegalArgumentException("message can't be null");
	}
	this.message = message;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((creationDate == null) ? 0 : creationDate.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((message == null) ? 0 : message.hashCode());
	result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
	Record other = (Record) obj;
	if (creationDate == null) {
	    if (other.creationDate != null) {
		return false;
	    }
	} else if (!creationDate.equals(other.creationDate)) {
	    return false;
	}
	if (email == null) {
	    if (other.email != null) {
		return false;
	    }
	} else if (!email.equals(other.email)) {
	    return false;
	}
	if (message == null) {
	    if (other.message != null) {
		return false;
	    }
	} else if (!message.equals(other.message)) {
	    return false;
	}
	if (topic == null) {
	    if (other.topic != null) {
		return false;
	    }
	} else if (!topic.equals(other.topic)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(this.getClass().getName());
	result.append(" Topic: " + topic);
	result.append(" Creation date: " + creationDate);
	result.append(" Email: " + email);
	result.append(" Message: " + message);
	return result.toString();
    }

}
