package no.hvl.dat102;

import no.hvl.dat102.adt.FilmArkivADT;

public class FilmArkiv2 implements FilmArkivADT{
	
	private int antall;
	private LinearNode<Film> start;

	@Override
	public Film[] hentFilmTabell() {
		Film[] filmTab = new Film[antall];
		
		LinearNode<Film> curr = start;
		
		for (int i = 0; i < antall; i++) {
			filmTab[i] = curr.getElement();
			curr = curr.getNeste();
		}
		return filmTab;	
	}
	
	@Override
	public void leggTilFilm(Film nyFilm) {
		
		LinearNode<Film> neste = new LinearNode<Film>();
		neste.setElement(nyFilm);
		LinearNode<Film> p = start;
		
		if(sjekkUnikID(nyFilm.getFilmnr())) {
			
			while(p.getNeste() != null) {
				p = p.getNeste();
			}
			p.setNeste(neste);
			antall++;
		} else {
			System.out.println("Prøv igjen, det finnes allerede en film med ID: " + nyFilm.getFilmnr());
		}	
	}

	@Override
	public boolean slettFilm(int filmnr) {
		
		boolean funnet = false;
		LinearNode<Film> forrige = null;
		LinearNode<Film> p = start;
		
		// skal denne vekk
		if(p.getElement().getFilmnr() == filmnr) {
			start = p.getNeste();
			funnet = true;
		}
		
		for (int sok = 0; sok < antall && !funnet; sok++) {
			if(p.getElement().getFilmnr() == filmnr) {
				forrige.setNeste(p.getNeste());
				funnet = true;
				antall--;
			}else {
				forrige = p;
				p = p.getNeste();
			}
			
		}
	return funnet;
	}
		
	@Override
	public Film[] soekTittel(String delstreng) {

		LinearNode<Film> denne = start;
		Film[] bibern = new Film[antall];
		int antallFilmer = 0;
		
		while (denne.getNeste() != null) {
			
			if(denne.getElement().getTittel().contains(delstreng)) {
				bibern[antallFilmer] = denne.getElement();
				antallFilmer++;
			}
			denne = denne.getNeste();
		}
		return bibern;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {

		LinearNode<Film> denne = start;
		Film[] bibern = new Film[antall];
		int antallFilmer = 0;
		
		while (denne.getNeste() != null) {
			
			if(denne.getElement().getFilmSkaper().contains(delstreng)) {
				bibern[antallFilmer] = denne.getElement();
				antallFilmer++;
			}
			denne = denne.getNeste();
		}
		return bibern;
	}

	@Override
	public int antall(Sjanger sjanger) {
		
		int antallFilmer = 0;
		LinearNode<Film> denne = start;
		
		for (int i = 0; i < antall; i++) {
			if(sjanger == denne.getElement().getSjanger()) {
				antallFilmer++;
			}
		}
		return antallFilmer;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean sjekkUnikID(int ID) {
		
		boolean unik = true;
		LinearNode<Film> denne = start;
		
		for (int i = 0; i < antall; i++) {
			if(ID == denne.getElement().getFilmnr()) {
				unik = false;
			}
			
		}
		return unik;
	}

	@Override
	public void okTabell(Film[] filmTab) {
		// Unødvendig å ha i denne implementasjon.		
	}

}

	


