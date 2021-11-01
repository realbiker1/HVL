package no.hvl.dat100;

/*
 *  Klasse for representasjon av ansatt-data.
 */
public class Ansatt implements Element{

	private int ansNr;
	private String fornavn;
	private String etternavn;
	private double l�nn;

	public Ansatt(int ansNr, String fornavn, String etternavn, double l�nn) {
		this.ansNr = ansNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.l�nn = l�nn;
	}

	public String nokkel() {
		return "" + ansNr;
	}
	
	public int getAnsNr() {
		return ansNr;
	}

	public void setAnsNr(int ansNr) {
		this.ansNr = ansNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public double getL�nn() {
		return l�nn;
	}

	public void setL�nn(double l�nn) {
		this.l�nn = l�nn;
	}

	public String toString() {
		return ansNr + ": " + fornavn + " " + etternavn + " - l�nn kr. " + l�nn;
	}

}


