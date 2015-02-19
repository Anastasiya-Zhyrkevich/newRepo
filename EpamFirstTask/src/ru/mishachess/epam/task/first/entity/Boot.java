package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Boot extends Shoes {

    private int durability;

    public Boot(String name, double weight, double price, int height,
	    int footSize, int durability) {
	super(name, weight, price, height, footSize);
	setDurability(durability);
    }

    public int getDurability() {
	return durability;
    }

    public void setDurability(int durability) {
	if (durability <= 0) {
	    throw new IllegalArgumentException("durability must be positive");
	}
	this.durability = durability;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + durability;
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
	Boot other = (Boot) obj;
	if (durability != other.durability) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Durability: " + durability);
	return super.toString() + result.toString();
    }

}
