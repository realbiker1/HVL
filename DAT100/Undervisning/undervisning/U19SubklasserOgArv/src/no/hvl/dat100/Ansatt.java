package no.hvl.dat100;

/*
 *  Klasse for representasjon av ansatt-data.
 */
public class Ansatt {

	protected int ansNr;
	protected String fornavn;
	protected String etternavn;
	protected double l�nn;

	public Ansatt(int ansNr, String fornavn, String etternavn, double l�nn) {
		this.ansNr = ansNr;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.l�nn = l�nn;
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


