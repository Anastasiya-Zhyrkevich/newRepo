package ru.mishachess.epam.task.first.entity;

/**
 * Class Ammunition is the root of ammunitions hierarchy
 * 
 * @author Mikhail Sadovsky
 * 
 */
public abstract class Ammunition {
    private String name;
    private double weight;
    private double price;

    public Ammunition(String name, double weight, double price) {
	setName(name);
	setWeight(weight);
	setPrice(price);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	if (name == null) {
	    throw new IllegalArgumentException("name can't be null");
	}
	this.name = name;
    }

    public double getWeight() {
	return weight;
    }

    public void setWeight(double weight) {
	if (weight <= 0) {
	    throw new IllegalArgumentException("weight must be positive");
	}
	this.weight = weight;
    }

    public double getPrice() {
	return price;
    }

    public void setPrice(double price) {
	if (price <= 0) {
	    throw new IllegalArgumentException("price must be positive");
	}
	this.price = price;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(weight);
	result = prime * result + (int) (temp ^ (temp >>> 32));
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
	Ammunition other = (Ammunition) obj;
	if (name == null) {
	    if (other.name != null) {
		return false;
	    }
	} else if (!name.equals(other.name)) {
	    return false;
	}
	if (Double.doubleToLongBits(price) != Double
		.doubleToLongBits(other.price)) {
	    return false;
	}
	if (Double.doubleToLongBits(weight) != Double
		.doubleToLongBits(other.weight)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(this.getClass().getName());
	result.append(" Name: " + name);
	result.append(" Weight: " + weight);
	result.append(" Price: " + price);
	return result.toString();
    }

}
