package ru.mishachess.epam.task.first.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.mishachess.epam.task.first.entity.Ammunition;
import ru.mishachess.epam.task.first.entity.Equipment;
import ru.mishachess.epam.task.first.factory.AmmunitionFactory;
import ru.mishachess.epam.task.first.util.SearcherByPrice;
import ru.mishachess.epam.task.first.util.SorterByWeight;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class EquipmentManager {

    private Equipment equipment;
    private SorterByWeight sorterByWeight = new SorterByWeight();

    public EquipmentManager() {
	equipment = new Equipment();
    }

    public Equipment getEquipment() {
	return equipment;
    }

    public void setEquipment(Equipment equipment) {
	if (equipment == null) {
	    throw new IllegalArgumentException("Equipment is null");
	}
	this.equipment = equipment;
    }

    /**
     * Add ammunition to equipment. Types of ammunition with these parameters -
     * boot and helmet.
     * 
     * @params concreteAmmunitionProperties - property values with the names of
     *         the respective type of ammunition
     * 
     */
    public void addAmmunition(String type, String name, double weight,
	    double price, int... concreteAmmunitionProperties) {
	if (type == null) {
	    throw new IllegalArgumentException("Equipment type is null");
	}
	equipment.addAmmunition(AmmunitionFactory.getAmmunition(type, name,
		weight, price, concreteAmmunitionProperties[0],
		concreteAmmunitionProperties[1],
		concreteAmmunitionProperties[2]));
    }

    /**
     * Add ammunition to equipment. Type of ammunition with these parameters -
     * glove.
     */
    public void addAmmunition(String type, String name, double weight,
	    double price, String material, int fingerLength) {
	if (type == null) {
	    throw new IllegalArgumentException("Equipment type is null");
	}
	equipment.addAmmunition(AmmunitionFactory.getAmmunition(type, name,
		weight, price, material, fingerLength));
    }

    /**
     * Add ammunition to equipment. Type of ammunition with these parameters -
     * pants.
     */
    public void addAmmunition(String type, String name, double weight,
	    double price, int length, String season, int pocketsNumber) {
	if (type == null) {
	    throw new IllegalArgumentException("Equipment type is null");
	}
	equipment.addAmmunition(AmmunitionFactory.getAmmunition(type, name,
		weight, price, length, season, pocketsNumber));
    }

    public double calcEquipmentPrice() {
	double equipmentPrice = 0;
	List<Ammunition> ammunitionList = equipment.getAmmunitionList();
	if (ammunitionList != null) {
	    for (Ammunition ammunition : ammunitionList) {
		equipmentPrice += ammunition.getPrice();
	    }
	}
	return equipmentPrice;
    }

    public List<Ammunition> sortByWeight() {
	List<Ammunition> ammunitionList = new ArrayList<Ammunition>(
		equipment.getAmmunitionList());
	if (ammunitionList == null || ammunitionList.size() == 0) {
	    return Collections.emptyList();
	}
	Collections.sort(ammunitionList, sorterByWeight);
	return ammunitionList;
    }

    public List<Ammunition> search(double minPrice, double maxPrice) {
	return SearcherByPrice.search(equipment, minPrice, maxPrice);
    }

}
