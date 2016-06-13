package ru.mishachess.epam.task.first.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Equipment {

    private List<Ammunition> ammunitionList = new ArrayList<Ammunition>();

    public Equipment() {

    }

    public void addAmmunition(Ammunition ammunition) {
	if (ammunition != null) {
	    ammunitionList.add(ammunition);
	}
    }

    public void deleteAmmunition(Ammunition ammunition) {
	if (ammunitionList.contains(ammunition)) {
	    ammunitionList.remove(ammunition);
	}
    }

    public Ammunition getAmmunition(int index) {
	if (index < 0 || index > ammunitionList.size()) {
	    throw new IllegalArgumentException(
		    " No such index in ammunition list");
	}
	return ammunitionList.get(index);
    }

    public void setAmmunition(int index, Ammunition ammunition) {
	if (index >= 0 && index <= ammunitionList.size() && ammunition != null) {
	    ammunitionList.set(index, ammunition);
	}
    }

    public List<Ammunition> getAmmunitionList() {
	return Collections.unmodifiableList(ammunitionList);
    }

    public void setAmmunitionList(List<Ammunition> ammunitions) {
	if (ammunitions != null) {
	    this.ammunitionList = ammunitions;
	}
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((ammunitionList == null) ? 0 : ammunitionList.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Equipment other = (Equipment) obj;
	if (ammunitionList == null) {
	    if (other.ammunitionList != null) {
		return false;
	    }
	} else if (!ammunitionList.equals(other.ammunitionList)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "Equipment ammunitions=" + ammunitionList;
    }

}
