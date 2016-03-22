package query;

import java.io.Serializable;

public class EdrString implements Serializable {

	private static final long serialVersionUID = -5671964965656787613L;
	/*
	 * source edr file can be added as a field
	 */
	String edrString;
	
	public String getString() {
		return edrString;
	}

	public EdrString(String str) {
		this.edrString = str;
	}
	
	

}
