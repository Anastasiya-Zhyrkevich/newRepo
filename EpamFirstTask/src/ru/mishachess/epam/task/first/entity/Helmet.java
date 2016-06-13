package ru.mishachess.epam.task.first.entity;

/**
 * @author Mikhail Sadovsky
 * 
 */
public class Helmet extends Ammunition {

    private int visibility;
    private int lateralVisibility;
    private int audibility;

    public Helmet(String name, double weight, double price, int visibility,
	    int lateralVisibility, int audibility) {
	super(name, weight, price);
	setVisibility(visibility);
	setLateralVisibility(lateralVisibility);
	setAudibility(audibility);
    }

    public int getVisibility() {
	return visibility;
    }

    public void setVisibility(int visibility) {
	if (visibility < 0) {
	    throw new IllegalArgumentException(
		    "visibility must be positive or ziro");
	}
	this.visibility = visibility;
    }

    public int getLateralVisibility() {
	return lateralVisibility;
    }

    public void setLateralVisibility(int lateralVisibility) {
	if (lateralVisibility < 0) {
	    throw new IllegalArgumentException(
		    "lateralVisibility must be positive or ziro");
	}
	this.lateralVisibility = lateralVisibility;
    }

    public int getAudibility() {
	return audibility;
    }

    public void setAudibility(int audibility) {
	if (audibility < 0) {
	    throw new IllegalArgumentException(
		    "audibility must be positive or ziro");
	}
	this.audibility = audibility;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + audibility;
	result = prime * result + lateralVisibility;
	result = prime * result + visibility;
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
	Helmet other = (Helmet) obj;
	if (audibility != other.audibility) {
	    return false;
	}
	if (lateralVisibility != other.lateralVisibility) {
	    return false;
	}
	if (visibility != other.visibility) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	StringBuilder result = new StringBuilder();
	result.append(" Visibility: " + visibility);
	result.append(" Lateral visibility: " + lateralVisibility);
	result.append(" Audibility: " + audibility);
	return super.toString() + result.toString();
    }

}
