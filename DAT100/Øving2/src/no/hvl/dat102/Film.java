package no.hvl.dat102;

public class Film {
	
	private int filmnr;
	private String filmSkaper;
	private String tittel;
	private int lanseringsDato;
	private Sjanger sjanger;
	private String filmSelskap;
	
	
	// Konstruktører for film
	public Film() {
		
	}
	
	public Film(int filmnr, String filmSkaper, String tittel, int lanseringsDato, Sjanger sjanger, String filmSelskap) {
		this.filmnr = filmnr;
		this.filmSkaper = filmSkaper;
		this.tittel = tittel;
		this.lanseringsDato = lanseringsDato;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;
	}
	
	// Getters/setters
	public int getFilmnr() {
		return filmnr;
	}

	public void setFilmnr(int filmnr) {
		this.filmnr = filmnr;
	}

	public String getFilmSkaper() {
		return filmSkaper;
	}

	public void setFilmSkaper(String filmSkaper) {
		this.filmSkaper = filmSkaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsDato() {
		return lanseringsDato;
	}

	public void setLanseringsDato(int lanseringsDato) {
		this.lanseringsDato = lanseringsDato;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}
	
	// Informasjon om film til streng
	@Override
	public String toString() {
		return "Filmnr: " + filmnr + 
				"\nTittel: " + tittel + 
				"\nSjanger: " + sjanger + 
				"\nLansert: " + lanseringsDato + 
				"\nFilmskaper: " + filmSkaper + 
				"\nFilmselskap: " + filmSelskap;
	}
	

}


