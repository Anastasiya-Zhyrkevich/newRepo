package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public abstract class Shoes extends Ammunition {

    private int height;
    private int footSize;

    public Shoes(String name, double weight, double price, int height,
	    int footSize) {
	super(name, weight, price);
	setHeight(height);
	setFootSize(footSize);
    }

    public int getHeight() {
	return height;
    }

    public void setHeight(int height) {
	if (height <= 0) {
	    throw new IllegalArgumentException("height must be positive");
	}
	this.height = height;
    }

    public int getFootSize() {
	return footSize;
    }

    public void setFootSize(int footSize) {
	if (footSize <= 0) {
	    throw new IllegalArgumentException("footSize must be positive");
	}
	this.footSize = footSize;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + footSize;
	result = prime * result + height;
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
	Shoes other = (Shoes) obj;
	if (footSize != other.footSize) {
	    return false;
	}
	if (height != other.height) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Length: " + height);
	result.append(" Foot size: " + footSize);
	return super.toString() + result.toString();
    }

}
