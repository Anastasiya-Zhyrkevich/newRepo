package ru.mishachess.epam.task.first.util;

import java.util.Comparator;

import ru.mishachess.epam.task.first.entity.Ammunition;

/**
 * @author Mikhail Sadovsky
 *
 */
public final class SorterByWeight implements Comparator<Ammunition> {

    @Override
    public int compare(Ammunition ammunition1, Ammunition ammunition2) {

	double weight1 = ammunition1.getWeight();
	double weight2 = ammunition2.getWeight();

	if (weight2 > weight1) {
	    return 1;
	} else if (weight2 < weight1) {
	    return -1;
	} else {
	    return 0;
	}
    }
}
