package be.vdab.valueobjects;

import java.io.Serializable;

public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String straat;
	private final String huisNr;
	private final int postcode;
	private final String gemeente;
	
	public Adres (String straat, String huisNr, int postcode, String gemeente) {
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getGemeente() {
		return gemeente;
	}
}
