package no.hvl.dat102;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import no.hvl.dat102.adt.FilmArkivADT;

import java.io.IOException;

	public class Fil {
		
	public static void skrivTilFil(FilmArkivADT filmArkiv, String filnavn) {
		
		PrintWriter skriver = null;
		Film[] arkiv = filmArkiv.hentFilmTabell();
		int antFilmer = filmArkiv.antall();
		
		try {
			skriver = new PrintWriter(filnavn);		
			
			skriver.print(antFilmer + "\n");
			
			for (int i = 0 ; i < antFilmer; i++) {
				
				skriver.print(arkiv[i].getFilmnr() + "#");
				skriver.print(arkiv[i].getFilmSkaper() + "#");
				skriver.print(arkiv[i].getTittel() + "#");
				skriver.print(arkiv[i].getLanseringsDato() + "#");
				skriver.print(arkiv[i].getSjanger() + "#");
				skriver.print(arkiv[i].getFilmSelskap() + "\n");
			} 
		}
		catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
			System.out.println("Feil: Fant ikke filen.");
		}
		finally {
			
			if (skriver != null) {
				skriver.close();
			}		
		}	
	}
	
	public static FilmArkivADT lesFraFil(String filnavn) throws IOException {
		
		BufferedReader objReader = null;
		File fil = new File(filnavn);
		FilmArkivADT filmArkiv = null;		
		
		try {
			objReader = new BufferedReader(new FileReader(fil));
			int antFilmer = Integer.parseInt(objReader.readLine());
			filmArkiv = new FilmArkiv(antFilmer);
			String[] filmElement = null;
			
			for(int i = 0; i < antFilmer; i++) {
				
				String filmStr = objReader.readLine();
				
				filmElement = filmStr.split("#");
							
				int filmNr = Integer.parseInt(filmElement[0]);
				String filmSkaper = filmElement[1];
				String tittel = filmElement[2];
				int lanseringsDato = Integer.parseInt(filmElement[3]);
				Sjanger sjanger = Sjanger.valueOf(filmElement[4].toUpperCase());
				String filmSelskap = filmElement[5];
												
				Film film = new Film(filmNr, filmSkaper, tittel, lanseringsDato, sjanger, filmSelskap);
				filmArkiv.leggTilFilm(film);				
			}						
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.out.println("FEIL: Fil ikke funnet");
		}
		catch (IOException e2) {
			e2.printStackTrace();
			System.out.println("FEIL: Noe gikk galt");
		}		
		finally {
			
			if (objReader != null) {
				objReader.close();
			}
		}
		return filmArkiv;
	}
}
