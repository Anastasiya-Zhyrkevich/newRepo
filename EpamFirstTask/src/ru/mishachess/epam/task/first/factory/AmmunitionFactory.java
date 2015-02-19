package ru.mishachess.epam.task.first.factory;

import ru.mishachess.epam.task.first.entity.Ammunition;
import ru.mishachess.epam.task.first.entity.Boot;
import ru.mishachess.epam.task.first.entity.Glove;
import ru.mishachess.epam.task.first.entity.Helmet;
import ru.mishachess.epam.task.first.entity.Pants;

/**
 * This class is designed for creating objects in accordance with the parameters
 * obtained from EquipmentManager class.
 * 
 * @author Mikhail Sadovsky
 * 
 */
public final class AmmunitionFactory {

    private AmmunitionFactory() {

    }

    /**
     * @param type
     *            - determines the type of ammunition
     * @return new Boot or Helmet object
     */
    public static Ammunition getAmmunition(String type, String name,
	    double weight, double price, int... concreteAmmunitionProperties) {
	AmmunitionType inputType = AmmunitionType.valueOf(type.toUpperCase());
	switch (inputType) {
	case BOOT:
	    return new Boot(name, weight, price,
		    concreteAmmunitionProperties[0],
		    concreteAmmunitionProperties[1],
		    concreteAmmunitionProperties[2]);
	case HELMET:
	    return new Helmet(name, weight, price,
		    concreteAmmunitionProperties[0],
		    concreteAmmunitionProperties[1],
		    concreteAmmunitionProperties[2]);
	default:
	    throw new IllegalArgumentException(
		    "No such type of ammunition with this arguments");
	}
    }

    /**
     * @return new Glove object
     */
    public static Ammunition getAmmunition(String type, String name,
	    double weight, double price, String material, int fingerLength) {
	if (!type.toUpperCase().equals(AmmunitionType.GLOVE.name())) {
	    throw new IllegalArgumentException(
		    "No such type of ammunition with this arguments");
	}
	return new Glove(name, weight, price, material, fingerLength);
    }

    /**
     * @return new Pants object
     */
    public static Ammunition getAmmunition(String type, String name,
	    double weight, double price, int length, String season,
	    int pocketsNumber) {
	if (!type.toUpperCase().equals(AmmunitionType.PANTS.name())) {
	    throw new IllegalArgumentException(
		    "No such type of ammunition with this arguments");
	}
	return new Pants(name, weight, price, length, season, pocketsNumber);
    }
}
