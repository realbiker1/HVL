package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.dat102.adt.FilmArkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en FILM fra tastatur
	 public Film lesFilm(){
		 Scanner scan = new Scanner(System.in);
		 		 
		 System.out.println("Filmnr:");		
		 int filmnr = scan.nextInt();	
		 
		 System.out.println();
		 
		 System.out.println("Filmskaper:");
		 String tom = scan.nextLine();	 
		 String filmSkaper = scan.nextLine();
		 System.out.println();
		 
		 System.out.println("Tittel:");
		 String tittel = scan.nextLine();
		 System.out.println();
		 
		 System.out.println("Lanseringsdato:");
		 int lanseringsDato = scan.nextInt();
		 System.out.println();
		 
		 System.out.println("Sjanger:");
		 tom = scan.nextLine();
		 Sjanger sjanger = Sjanger.valueOf(scan.nextLine().toUpperCase());
		 System.out.println();
		 
		 System.out.println("Filmselskap:");
		 String filmSelskap = scan.nextLine();
		 System.out.println();

		 scan.close();

		 Film nyFilm = new Film(filmnr, filmSkaper, tittel, lanseringsDato, sjanger, filmSelskap);		 
		 return nyFilm;
		 
	 }
	// viser en film med alle opplysninger på skjerm
	 public void visFilm(Film film){
		 System.out.println(film.toString());
	 }
	// Skriver ut alle Filmer med en spesiell delstreng i tittelen
	 public void skrivUtFilmDelstrengITittel(FilmArkivADT film, String delstreng){
		 Film[] tab = film.soekTittel(delstreng);
		 
		 for (int i = 0; i < tab.length; i++) {
			 if (tab[i] != null) {
				 visFilm(tab[i]);
				 System.out.println();				 
			 }		 
		 }
	 }
	// Skriver ut alle Filmer av en produsent / en gruppe
	 public void skrivUtFilmProdusent(FilmArkivADT film, String delstreng) {
		 Film[] tab = film.soekProdusent(delstreng);
		 
		 for (int i = 0; i < tab.length; i++) {
			 if (tab[i] != null) {
				 visFilm(tab[i]);
				 System.out.println();				 
			 }
		 }
	 }
	// Skriver ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	 public void skrivUtStatistikk(FilmArkivADT film){
		 
		 System.out.println("Antall filmer: " + film.antall());
		 
		 for (Sjanger s : Sjanger.values()) {
			 System.out.println(s.toString() + ": " + film.antall(s));
		 }	
	 }
	 
	
	
	}
