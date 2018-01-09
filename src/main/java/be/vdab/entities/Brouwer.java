package be.vdab.entities;

import java.io.Serializable;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long brouwerNr;
	private String naam;
	private Integer omzet;
	private Adres adres;
	
	public Brouwer(String naam, Integer omzet, Adres adres) {
		this.naam = naam;
		this.omzet = omzet;
		this.adres = adres;
	}

	public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
		this(naam, omzet, adres);
		this.brouwerNr = brouwerNr;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}	
}
