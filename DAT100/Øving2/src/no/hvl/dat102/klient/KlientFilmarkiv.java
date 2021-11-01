package no.hvl.dat102.klient;

import java.io.IOException;

import no.hvl.dat102.FilmArkiv;
import no.hvl.dat102.adt.FilmArkivADT;

public class KlientFilmarkiv {

	public static void main (String[] args) throws IOException {
		
		FilmArkivADT bravo = new FilmArkiv();	
		Meny menyBravo = new Meny(bravo);
		menyBravo.Start();
	}

}
