package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.FilmArkiv2;
import no.hvl.dat102.Sjanger;

public interface FilmArkivADT {
	
	/**
	 * Metoden returnerer filmtabellen.
	 * @return
	 */
	Film[] hentFilmTabell();
	
	/**
	 * Metoden legger til et filmobjekt i filmarkivet.
	 * @param nyFilm
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 * Metoden sletter et filmobjekt, gitt filmnr som parameter,
	 * returnerer true om slettet, false ellers.
	 * @param filmnr
	 * @return
	 */
	boolean slettFilm(int filmnr);
	
	/**
	 * Metoden returnerer en tabell med Filmobjekter som inneholder delstreng
	 * i variabel tittel.
	 * @param delstreng
	 * @return
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 * Metoden returnerer en tabell med Filmobjekter som inneholder delstreng
	 * i variabel filmSkaper.
	 * @param delstreng
	 * @return
	 */
	Film[] soekProdusent(String delstreng);
	
	/**
	 * Metoden returnerer antall filmer som er i sjangeren gitt ved parameteret fra arkivet.
	 * @param sjanger
	 * @return
	 */
	int antall(Sjanger sjanger);
	
	/**
	 * Metoden returnerer antall filmer i arkivet.
	 * @return
	 */
	int antall();
	
	/**
	 * Metoden returnerer true hvis ID gitt ved parameter ikke finnes hos noen andre filmobjekter,
	 * returnerer false om den finnes.
	 * @param ID
	 * @return
	 */
	public boolean sjekkUnikID(int ID);
	
	/**
	 * Metoden øker størrelsen på filmtabellen med 1.
	 * @param filmTab
	 */
	public void okTabell(Film[] filmTab);

	


	

	
}
