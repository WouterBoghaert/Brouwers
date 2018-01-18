package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Adres implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotBlank
	@Length(min=1, max=50)
	@SafeHtml
	private String straat;
	@NotBlank
	@Length(min=1, max=7)
	@SafeHtml
	private String huisNr;
	@NotNull
	@Min(1000) 
	@Max(9999)
	private Integer postcode;
	@NotBlank
	@Length(min=1,max=50)
	@SafeHtml
	private String gemeente;
	
	public Adres() {
		
	}
	
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
