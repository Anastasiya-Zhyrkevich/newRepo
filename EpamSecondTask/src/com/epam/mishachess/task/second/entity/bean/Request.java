package com.epam.mishachess.task.second.entity.bean;

import java.util.Arrays;

import com.epam.mishachess.task.second.entity.Notebook;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Request {
    private Notebook notebook;
    private String[] requestParameters;

    public Request(Notebook notebook) {
	setNotebook(notebook);
    }

    public Request(Notebook notebook, String[] requestParameters) {
	setNotebook(notebook);
	setRequestParameters(requestParameters);
    }

    public Notebook getNotebook() {
	return notebook;
    }

    public void setNotebook(Notebook notebook) {
	if (notebook == null) {
	    throw new IllegalArgumentException("Notebook is null");
	}
	this.notebook = notebook;
    }

    public String[] getRequestParameters() {
	return requestParameters;
    }

    public void setRequestParameters(String[] requestParameters) {
	if (requestParameters == null) {
	    throw new IllegalArgumentException("requestParameters is null");
	}
	for (String requestParameter : requestParameters) {
	    if (requestParameter == null) {
		throw new IllegalArgumentException("Request parameter is null");
	    }
	}
	this.requestParameters = requestParameters;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((notebook == null) ? 0 : notebook.hashCode());
	result = prime * result + Arrays.hashCode(requestParameters);
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
	Request other = (Request) obj;
	if (notebook == null) {
	    if (other.notebook != null) {
		return false;
	    }
	} else if (!notebook.equals(other.notebook)) {
	    return false;
	}
	if (!Arrays.equals(requestParameters, other.requestParameters)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(this.getClass().getName());
	result.append(" Notebook: " + notebook);
	result.append(" requestParameters: "
		+ Arrays.toString(requestParameters));
	return result.toString();
    }

}
