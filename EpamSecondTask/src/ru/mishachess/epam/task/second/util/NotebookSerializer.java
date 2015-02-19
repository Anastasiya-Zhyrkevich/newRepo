package ru.mishachess.epam.task.second.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.mishachess.epam.task.second.entity.Notebook;

public final class NotebookSerializer {

    private NotebookSerializer() {

    }

    public static void store(Notebook notebook, String fileName)
	    throws IOException {
	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
		fileName));
	out.writeObject(notebook);
	out.close();
    }

    @SuppressWarnings("resource")
    public static Notebook load(String fileName) throws IOException,
	    ClassNotFoundException {
	ObjectInputStream in = new ObjectInputStream(new FileInputStream(
		fileName));
	return (Notebook) in.readObject();
    }
}
