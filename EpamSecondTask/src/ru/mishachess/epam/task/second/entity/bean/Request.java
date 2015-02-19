package ru.mishachess.epam.task.second.entity.bean;

import ru.mishachess.epam.task.second.entity.Notebook;


public class Request {
    private Notebook notebook;
    private String requestParameter;
    private String[] requestParameters;

    public Request(Notebook notebook) {
	setNotebook(notebook);
    }

    public Request(Notebook notebook, String requestParameter) {
	setNotebook(notebook);
	setRequestParameter(requestParameter);
    }

    public Request(Notebook notebook, String[] requestParameters) {
	setNotebook(notebook);
	setRequestParameters(requestParameters);
    }

    public Notebook getNotebook() {
	return notebook;
    }

    public void setNotebook(Notebook notebook) {
	if (notebook != null) {
	    this.notebook = notebook;
	}
    }

    public String getRequestParameter() {
	return requestParameter;
    }

    public void setRequestParameter(String requestParameter) {
	if (requestParameter != null) {
	    this.requestParameter = requestParameter;
	}
    }

    public String[] getRequestParameters() {
	return requestParameters;
    }

    public void setRequestParameters(String[] requestParameters) {
	for (int paramIndex = 0; paramIndex < requestParameters.length; paramIndex++) {
	    if (requestParameters[paramIndex] == null) {
		throw new IllegalArgumentException("Null in request parameters");
	    }
	}
	this.requestParameters = requestParameters;
    }

}
