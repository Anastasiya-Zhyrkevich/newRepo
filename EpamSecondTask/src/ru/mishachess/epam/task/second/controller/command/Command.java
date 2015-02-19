package ru.mishachess.epam.task.second.controller.command;

import java.util.List;

import ru.mishachess.epam.task.second.entity.Record;
import ru.mishachess.epam.task.second.entity.bean.Request;

public interface Command {
    List<Record> execute(Request request);
}
