package com.epam.mishachess.task.second.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.epam.mishachess.task.second.controller.command.AddRecord;
import com.epam.mishachess.task.second.controller.command.Command;
import com.epam.mishachess.task.second.controller.command.FindByCreationDate;
import com.epam.mishachess.task.second.controller.command.FindByEmail;
import com.epam.mishachess.task.second.controller.command.FindByMessage;
import com.epam.mishachess.task.second.controller.command.FindByMessageWord;
import com.epam.mishachess.task.second.controller.command.FindByTopic;
import com.epam.mishachess.task.second.controller.command.FindByTopicAndCreationDate;
import com.epam.mishachess.task.second.controller.command.NameCommandEnum;
import com.epam.mishachess.task.second.controller.command.SortByTopic;
import com.epam.mishachess.task.second.entity.Notebook;
import com.epam.mishachess.task.second.entity.bean.Request;
import com.epam.mishachess.task.second.entity.bean.Response;
import com.epam.mishachess.task.second.exception.IllegalDateValidationException;
import com.epam.mishachess.task.second.exception.IllegalEmailValidationException;
import com.epam.mishachess.task.second.util.NotebookSerializer;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Controller {
    private final static Logger logger = Logger.getRootLogger();
    private Notebook notebook;
    private Map<NameCommandEnum, Command> commands = new HashMap<NameCommandEnum, Command>();

    public Controller(String fileName) {
	try {
	    setNotebook(NotebookSerializer.load(fileName));
	} catch (ClassNotFoundException | IOException e) {
	    logger.log(Level.ERROR, e);
	}
	initCommands();
    }

    public Controller(Notebook notebook) {
	setNotebook(notebook);
	initCommands();

    }

    private void initCommands() {
	commands.put(NameCommandEnum.FIND_BY_TOPIC, new FindByTopic());
	commands.put(NameCommandEnum.FIND_BY_CREATION_DATE,
		new FindByCreationDate());
	commands.put(NameCommandEnum.FIND_BY_EMAIL, new FindByEmail());
	commands.put(NameCommandEnum.FIND_BY_MESSAGE, new FindByMessage());
	commands.put(NameCommandEnum.FIND_BY_TOPIC_AND_CREATION_DATE,
		new FindByTopicAndCreationDate());
	commands.put(NameCommandEnum.FIND_BY_MESSAGE_WORD,
		new FindByMessageWord());
	commands.put(NameCommandEnum.SORT_BY_TOPIC, new SortByTopic());
	commands.put(NameCommandEnum.ADD_RECORD, new AddRecord());
    }

    public Notebook getNotebook() {
	return notebook;
    }

    public void setNotebook(Notebook notebook) {
	if (notebook == null) {
	    logger.log(Level.ERROR, new IllegalArgumentException(
		    "Notebook is null"));
	}
	this.notebook = notebook;
    }

    public Response execute(NameCommandEnum enumKey,
	    String... requestParameters) {
	Command command = commands.get(enumKey);
	try {
	    return new Response(command.execute(new Request(notebook,
		    requestParameters)));
	} catch (ParseException | IllegalDateValidationException
		| IllegalEmailValidationException | IllegalArgumentException e) {
	    logger.log(Level.ERROR, e.getMessage(), e);
	    return new Response("Sorry... You've got an exception");
	}
    }

    public void close(String fileName) {
	try {
	    NotebookSerializer.store(notebook, fileName);
	} catch (IOException e) {
	    logger.log(Level.ERROR, e);
	}
    }

}
