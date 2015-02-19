package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Glove extends Ammunition {

    private String material;
    private int fingerLength;

    public Glove(String name, double weight, double price, String material,
	    int fingerLength) {
	super(name, weight, price);
	setMaterial(material);
	setFingerLength(fingerLength);
    }

    public String getMaterial() {
	return material;
    }

    public void setMaterial(String material) {
	if (material == null) {
	    throw new IllegalArgumentException("material can't be null");
	}
	this.material = material;
    }

    public int getFingerLength() {
	return fingerLength;
    }

    public void setFingerLength(int fingerLength) {
	if (fingerLength <= 0) {
	    throw new IllegalArgumentException("fingerLength must be positive");
	}
	this.fingerLength = fingerLength;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + fingerLength;
	result = prime * result
		+ ((material == null) ? 0 : material.hashCode());
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
	Glove other = (Glove) obj;
	if (fingerLength != other.fingerLength) {
	    return false;
	}
	if (material == null) {
	    if (other.material != null) {
		return false;
	    }
	} else if (!material.equals(other.material)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Materila: " + material);
	result.append(" Finger length: " + fingerLength);
	return super.toString() + result.toString();
    }

}
