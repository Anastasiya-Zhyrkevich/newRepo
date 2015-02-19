package com.epam.mishachess.task.second.run;

import com.epam.mishachess.task.second.controller.Controller;
import com.epam.mishachess.task.second.controller.command.NameCommandEnum;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Runner {

    public static void main(String[] args) {
	Controller controller = new Controller("result.out");
	System.out.println(controller.execute(NameCommandEnum.SORT_BY_TOPIC));
	System.out.println(controller.execute(
		NameCommandEnum.FIND_BY_MESSAGE_WORD, "is"));
	System.out.println(controller.execute(NameCommandEnum.FIND_BY_EMAIL,
		"mishachess@mail.ru"));
	controller.close("result.out");
    }
}
