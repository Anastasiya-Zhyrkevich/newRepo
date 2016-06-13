package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public abstract class Clothing extends Ammunition {

    private int length;
    private String season;

    public Clothing(String name, double weight, double price, int length,
	    String season) {
	super(name, weight, price);
	setLength(length);
	setSeason(season);
    }

    public int getLength() {
	return length;
    }

    public void setLength(int length) {
	if (length <= 0) {
	    throw new IllegalArgumentException("lenght must be positive");
	}
	this.length = length;
    }

    public String getSeason() {
	return season;
    }

    public void setSeason(String season) {
	if (season == null) {
	    throw new IllegalArgumentException("season can't be null");
	}
	this.season = season;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + length;
	result = prime * result + ((season == null) ? 0 : season.hashCode());
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
	Clothing other = (Clothing) obj;
	if (length != other.length) {
	    return false;
	}
	if (season == null) {
	    if (other.season != null) {
		return false;
	    }
	} else if (!season.equals(other.season)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Length: " + length);
	result.append(" Season: " + season);
	return super.toString() + result.toString();
    }

}
