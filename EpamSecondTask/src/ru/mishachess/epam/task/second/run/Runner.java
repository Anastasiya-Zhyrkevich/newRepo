package ru.mishachess.epam.task.second.run;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ru.mishachess.epam.task.second.entity.Notebook;
import ru.mishachess.epam.task.second.util.NotebookSerializer;

public class Runner {
    private final static Logger log = Logger.getLogger(Runner.class.getName());

    public static void main(String[] args) {
	try {
	    Notebook notebook = NotebookSerializer.load("result.out");
	    NotebookSerializer.store(notebook, "result.out");
	} catch (IOException e) {
	    log.log(Level.SEVERE, "IOException");
	} catch (ClassNotFoundException e) {
	    log.log(Level.SEVERE, "ClassNotFoundException in load");
	} catch (IllegalArgumentException e) {
	    log.log(Level.SEVERE, e.getMessage());
	}

    }
}
