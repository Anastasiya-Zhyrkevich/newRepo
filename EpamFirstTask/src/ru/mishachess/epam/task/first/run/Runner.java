package ru.mishachess.epam.task.first.run;

import ru.mishachess.epam.task.first.logic.EquipmentManager;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Runner {

    public static void main(String[] args) {
	try {
	    EquipmentManager manager = new EquipmentManager();
	    manager.addAmmunition("glove", "Cotton glove", 3, 25, "cotton", 8);
	    manager.addAmmunition("glove", "Cotton glove", 1, 25, "cotton", 8);
	    manager.addAmmunition("boot", "Valenok", 5, 55, 15, 38, 5);
	    manager.addAmmunition("boot", "Valenok", 5, 55, 15, 38, 5);
	    manager.addAmmunition("helmet", "Steel helmet", 8, 100, 110, 120,
		    20);
	    manager.addAmmunition("pants", "Autumn ponts", 2.3, 75, 48,
		    "autumn", 2);
	    System.out.println(manager.calcEquipmentPrice());
	    System.out.println(manager.search(50, 80));
	    System.out.println(manager.sortByWeight());
	} catch (IllegalArgumentException e) {
	    System.out.println(e.getMessage());
	}
    }
}
