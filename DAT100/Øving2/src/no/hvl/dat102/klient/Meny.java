package no.hvl.dat102.klient;

import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

import no.hvl.dat102.Fil;
import no.hvl.dat102.Film;
import no.hvl.dat102.FilmArkiv;
import no.hvl.dat102.Tekstgrensesnitt;
import no.hvl.dat102.adt.FilmArkivADT;

public class Meny {
	
	private Tekstgrensesnitt tekstgr;
	private FilmArkivADT filma;
	
	public Meny(FilmArkivADT filma) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filma;
	}
	
	public void Start() throws IOException  {
		
		Scanner scan = new Scanner(System.in);
		String filnavn = "";
		String sok;
		int inp = 0;
		
		System.out.println("1. Opprette nytt filmarkiv \n2. Eksisterende filmarkiv");
		
		// Do-while sørger for kun 1 og 2 er gyldige inputs.
		do {
			inp = scan.nextInt();
		} while (inp != 1 && inp != 2);
			
		switch (inp) {	
		
		case 1:			
			//Oppretter nytt arkiv med størrelse 0, gir brukeren mulighet til å velge navn på arkivet.
			filma = new FilmArkiv(0);			
			System.out.println("Navn på nytt arkiv:");
			String tom = scan.nextLine();
			filnavn = scan.nextLine() + ".txt";		
			Fil.skrivTilFil(filma, filnavn);		
			break;
			
		case 2:		
			// Gjør slik at objektvariabelen filma blir fyllt med filmer fra .txt filen som brukeren taster inn.
			System.out.println("Hvilket filmarkiv?");
			tom = scan.nextLine();
			filnavn = scan.nextLine() + ".txt";			
			filma = Fil.lesFraFil(filnavn);			
			break; 
		}
		
		System.out.println("1. Legg til film");
		System.out.println("2. Slett film");
		System.out.println("3. Søk tittel");
		System.out.println("4. Søk produsent");
		System.out.println("5. Skriv ut statistikk");
		
		// Kun 1 - 5 gyldige inputs.
		do {
			inp = scan.nextInt();
		} while (inp != 1 && inp != 2 && inp != 3 && inp != 4 && inp != 5);
		
		switch(inp) {
		case 1:	//Legg til film
			System.out.println("Legg til film: ");
			filma.leggTilFilm(tekstgr.lesFilm());
			Fil.skrivTilFil(filma, filnavn);
			break;
				
		case 2: //Slett film
			System.out.println("Slett film (ID): ");
			inp = scan.nextInt();
			filma.slettFilm(inp);
			Fil.skrivTilFil(filma, filnavn);
			break;
				
		case 3: //Søk filmtittel
			System.out.println("Søk tittel: ");		
			String tom = scan.nextLine();
			sok = scan.nextLine();	
			tekstgr.skrivUtFilmDelstrengITittel(filma, sok);
			break;
				
		case 4: //Søk produsent
			System.out.println("Søk produsent: ");			
			tom = scan.nextLine();
			sok = scan.nextLine();
			tekstgr.skrivUtFilmProdusent(filma, sok);
			break;
								
		case 5: //Skriv ut statistikk
			tekstgr.skrivUtStatistikk(filma);
			break;
		}
		// lukker scanneren							
		if (scan != null) {
			scan.close();
		}
		
	}
	
}
		
		
			
			
			
			
			

		
	
	
	

