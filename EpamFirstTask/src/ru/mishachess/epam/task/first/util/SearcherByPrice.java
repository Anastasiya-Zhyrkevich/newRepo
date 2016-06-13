package ru.mishachess.epam.task.first.util;

import java.util.ArrayList;
import java.util.List;

import ru.mishachess.epam.task.first.entity.Ammunition;
import ru.mishachess.epam.task.first.entity.Equipment;

/**
 * @author Mikhail Sadovsky
 * 
 */
public final class SearcherByPrice {

    private SearcherByPrice() {

    }

    public static List<Ammunition> search(Equipment equipment,
	    double minPrice, double maxPrice) {

	List<Ammunition> ammunitionList = new ArrayList<Ammunition>();
	for (Ammunition ammunition : equipment.getAmmunitionList()) {
	    if (ammunition.getPrice() >= minPrice
		    && ammunition.getPrice() <= maxPrice) {
		ammunitionList.add(ammunition);
	    }
	}
	return ammunitionList;
    }
}
