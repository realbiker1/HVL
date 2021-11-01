package no.hvl.dat102;

import no.hvl.dat102.adt.FilmArkivADT;

public class FilmArkiv implements FilmArkivADT {
	
	private Film[] filmTabell;
	private int antall;
	
	//Konstruktører
	public FilmArkiv() {		
	}
	
	public FilmArkiv(int maksAntall) {
		antall = 0;
		filmTabell = new Film[maksAntall];
	}
	
	@Override
	public Film[] hentFilmTabell() {
		return filmTabell;
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		
		// Legger til ny film, sjekker om IDen er unik, øker deretter tabellen med 1 og legger inn.
		if (sjekkUnikID(nyFilm.getFilmnr())) {
			okTabell(filmTabell);			
			filmTabell[antall] = nyFilm;
			antall++;
			System.out.println(nyFilm.getTittel() + " lagt inn i arkivet");
		} else {
			System.out.println("FEIL: Det finnes allerede en film med ID: " + nyFilm.getFilmnr());
		}
						
	}
	
	@Override
	public boolean sjekkUnikID(int ID) {
		
		boolean unik = true;
		
		for (int i = 0; i < antall(); i++) {
			if(filmTabell[i].getFilmnr() == ID) {
				unik = false;
			}
		}		
		return unik;
	}
	
	@Override
	public void okTabell(Film[] filmTab) {
		
		Film[] nyTab = new Film[filmTab.length + 1];
		
		for (int i = 0; i < filmTab.length; i++) {
			nyTab[i] = filmTab[i];
		}
		this.filmTabell = nyTab;
	}
	
	@Override
	public boolean slettFilm(int filmnr) {
			
		boolean funnet = false;
		// For løkke for å finne filmnr.
		for (int i = 0; i < antall; i++) {
			
			if (filmTabell[i].getFilmnr() == filmnr) {
				
				System.out.println("'" + filmTabell[i].getFilmnr() + "' Slettet");
				filmTabell[i] = null;
				funnet = true;
				antall--;		
			}
			
			if(!funnet) {			

				System.out.println(filmnr + " finnes ikke i arkivet.");
				return funnet;          //For å slippe unødvendig kode.
			}
				
			if (funnet && i < antall-1) {				
			
				filmTabell[i] = filmTabell[i+1];
				filmTabell[i+1] = null;
			}
		}
		
		return funnet;
	}
	
	@Override
	public Film[] soekTittel(String delstreng) {
		
		int antallTreff = 0;
		
		//Finner først ut hvor stor tabellen skal være
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				antallTreff++;
				System.out.println(filmTabell[i].getTittel() + " inneholder " + delstreng);
			}
		}	
		if (antallTreff == 0) {
			System.out.println("Ingen treff på søkeord: " + delstreng);
			return null;		//returnerer null her hvis ingen treff for å slippe unødvendig kode.
		}
		System.out.println("Antall treff: " + antallTreff);
		
		Film[] treffTab = new Film[antallTreff];
		int j = 0;
		
		//Genererer tabellen
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getTittel().contains(delstreng)) {
				treffTab[j] = filmTabell[i];
				j++;
			}
		}
		return treffTab;		
	}
	
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		
		int antallTreff = 0;
		
		//Finner først ut hvor stor tabellen skal være
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getFilmSkaper().contains(delstreng)) {
				antallTreff++;
				System.out.println(filmTabell[i].getFilmSkaper() + " inneholder " + delstreng);
			}
		}	
		
		if (antallTreff == 0) {
			System.out.println("Ingen treff på søkeord: " + delstreng);
			return null;	//returnerer null her hvis ingen treff for å slippe unødvendig kode.
		}
		
		System.out.println("Antall treff: " + antallTreff);
		
		Film[] treffTab = new Film[antallTreff];
		int j = 0;
		
		//Genererer tabellen
		for (int i = 0; i < antall; i++) {
			if (filmTabell[i].getFilmSkaper().contains(delstreng)) {
				treffTab[j] = filmTabell[i];
				j++;
			}
		}
		return treffTab;		
	}	
	
	@Override
	public int antall(Sjanger sjanger) {
		
		int antallFilmer = 0;
		
		for (int i = 0; i < antall; i++) {
			if (sjanger == filmTabell[i].getSjanger()) {
				antallFilmer++;
			}
		}
		return antallFilmer;		
	}
	
	@Override
	public int antall() {
		
		return antall;
	}
	

	
}
