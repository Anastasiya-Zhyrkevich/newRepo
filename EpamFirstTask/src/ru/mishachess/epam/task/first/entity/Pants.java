package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Pants extends Clothing {

    private int pocketsNumber;

    public Pants(String name, double weight, double price, int length,
	    String season, int pocketsNumber) {
	super(name, weight, price, length, season);
	setPocketsNumber(pocketsNumber);
    }

    public int getPocketsNumber() {
	return pocketsNumber;
    }

    public void setPocketsNumber(int pocketsNumber) {
	if (pocketsNumber < 0) {
	    throw new IllegalArgumentException(
		    "pocketsNumber must be positive or ziro");
	}
	this.pocketsNumber = pocketsNumber;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + pocketsNumber;
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Pants other = (Pants) obj;
	if (pocketsNumber != other.pocketsNumber) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Pockets number: " + pocketsNumber);
	return super.toString() + result.toString();
    }

}
