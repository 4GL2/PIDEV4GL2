package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{
	
	private String rue;
	
	private String ville;

	public Address() {
		super();
	}

	public Address(String rue, String ville) {
		super();
		this.rue = rue;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	

}
