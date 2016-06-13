package ru.mishachess.epam.task.second.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.mishachess.epam.task.second.controller.command.Command;
import ru.mishachess.epam.task.second.controller.command.FindByCreationDate;
import ru.mishachess.epam.task.second.controller.command.FindByEmail;
import ru.mishachess.epam.task.second.controller.command.FindByMessage;
import ru.mishachess.epam.task.second.controller.command.FindByTopic;
import ru.mishachess.epam.task.second.controller.command.FindByTopicAndCreationDate;
import ru.mishachess.epam.task.second.controller.command.FindByMessageWord;
import ru.mishachess.epam.task.second.controller.command.NameCommandEnum;
import ru.mishachess.epam.task.second.controller.command.SortByTopic;
import ru.mishachess.epam.task.second.controller.validator.DateValidator;
import ru.mishachess.epam.task.second.controller.validator.EmailValidator;
import ru.mishachess.epam.task.second.controller.validator.Validator;
import ru.mishachess.epam.task.second.entity.Notebook;
import ru.mishachess.epam.task.second.entity.Record;
import ru.mishachess.epam.task.second.entity.bean.Request;

public class Controller {
    private Notebook notebook;
    private Validator emailValidator = new EmailValidator();
    private Validator dateValidator = new DateValidator();
    private Map<NameCommandEnum, Command> commands = new HashMap<NameCommandEnum, Command>();

    public Controller(Notebook notebook) {
	setNotebook(notebook);
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

    }

    public Notebook getNotebook() {
	return notebook;
    }

    public void setNotebook(Notebook notebook) {
	if (notebook != null) {
	    this.notebook = notebook;
	} else
	    throw new IllegalArgumentException("Notebook is null");
    }

    public void addRecord(Record record) {
	if (emailValidator.validate(record.getEmail())
		&& dateValidator.validate(record.getCreationDate())) {
	    notebook.addRecord(record);
	} else
	    throw new IllegalArgumentException("Input data isn't valid");
    }

    public List<Record> find(NameCommandEnum enumKey, String[] requestParameters) {
	Command command = commands.get(enumKey);
	return command.execute(new Request(notebook, requestParameters));
    }

    public List<Record> find(NameCommandEnum enumKey, String requestParameter) {
	Command command = commands.get(enumKey);
	return command.execute(new Request(notebook, requestParameter));
    }

    public List<Record> sort(NameCommandEnum enumKey) {
	Command command = commands.get(enumKey);
	return command.execute(new Request(notebook));
    }
}
