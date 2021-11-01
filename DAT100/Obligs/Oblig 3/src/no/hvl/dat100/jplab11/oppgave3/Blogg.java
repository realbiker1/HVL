package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] tabell;
	private int antall;
	private int plass = 20;

	public Blogg() {
		
		tabell = new Innlegg[plass];	
		antall = 0;
	}

	public Blogg(int lengde) {
		
		tabell = new Innlegg[lengde];
		antall = 0;
	}

	public int getAntall() {
		return antall;
	}
	
	public Innlegg[] getSamling() {
		return tabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int pos = 0;
		
		while (pos < antall) {                    //Antall mest sannsynlig feil, mener det skal være tabell.length men får nullPointerException
			
			if (tabell[pos].erLik(innlegg)) {
				return pos;
			}
			pos++;					
		}	
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		for (Innlegg e : tabell) {
			if (e != null) {
				if (e.erLik(innlegg)) {
					return true;
				}
			}		
		}
		return false;
	}

	public boolean ledigPlass() {

		if (antall < tabell.length) {
			return true;
		}
	
		return false;			
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if (antall < tabell.length) {
			tabell[antall] = innlegg;
			antall++;			
			return true;
		}
		System.out.println("Ikke nok plass!");
		
		return false;
	}
	
	@Override
	public String toString() {
		
		String str = antall + "\n";		
		
		for (Innlegg e : tabell) {
			
			str += e.toString();		
		}	
		return str;
	}
	
	
	public void utvid() {
		
		int bloggLengde = tabell.length;	
		Innlegg[] temp = new Innlegg[bloggLengde];
		
		for (int i = 0; i < bloggLengde; i++) {	
			
			if(tabell[i] != null) {
				
				temp[i] = tabell[i];
			}	
		}		
		
		tabell = new Innlegg[bloggLengde * 2];
		
		for (int i = 0; i < bloggLengde; i++) {
				
			tabell[i] = temp[i];
		}
			
	}
	
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (antall < tabell.length && !finnes(innlegg)) {
			
			for (int i = 0; i < tabell.length; i++) {
				
				if (tabell[i] == null) {
					
					tabell[i] = innlegg;
					antall++;
					System.out.println("Innlegg (ID: " + tabell[i].getId() + ") lagt til.");
					return true;
				}
				i++;
			}
			
		}	
		if (finnes(innlegg)) {
			System.out.println("Innlegget finnes allerede!");
		} else {
			System.out.println("Ikke nok plass!");
		}
		return false;		
	}
	
	
	public boolean slett(Innlegg innlegg) {
		
		if (finnes(innlegg)) {
			
			for (int i = 0; i < antall; i++) {
				
				if (tabell[i].erLik(innlegg)) {
					
					System.out.println("Innlegg (ID: " + tabell[i].getId() + ") slettet.");
					tabell[i] = null;
					antall--;
					
					for (int j = i; j < antall; j++) {
						
						tabell[j] = tabell [j+1];
					}
					return true;					
					}
				}
			}
		System.out.println("Innlegget finnes ikke!");
		return false;							
	}	
			

	public int[] search(String keyword) {
			
		int antFunn = 0;
		int i = 0;
		
		for (Innlegg e : tabell) {
			
			if(e instanceof Tekst && e.toString().contains(keyword)) {
				antFunn++;
			}
		}
		if(antFunn == 0) {
			System.out.println("Søk etter '" + keyword + "' ga ingen resultater.");
			return null;
		}	 
		int[] tab = new int[antFunn];
		
		for (Innlegg e : tabell) {
			
			if(e instanceof Tekst && e.toString().contains(keyword)) {
				tab[i] = e.getId();
				i++;
			}
		}
		System.out.println("Søk etter '" + keyword + "' ga " + antFunn + " resultater.");
		return tab;
	}
	
	
	
}