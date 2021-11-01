package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {
	
	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		boolean status = false;	
		PrintWriter skriver = null;
		Innlegg[] innhold = samling.getSamling();
		int antInnlegg = samling.getAntall();
		
		try {
			skriver = new PrintWriter(mappe + filnavn);		
				
			skriver.println(antInnlegg);
			
			for (int i = 0 ; i < antInnlegg; i++) {
				
				skriver.println(innhold[i].toString());
				status = true;
			} 
		}
		catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
			status = false;
		}
		finally {
			
			if (skriver != null) {
				skriver.close();
			}
			
		}
		return status;	
	}
	
}
