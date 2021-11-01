package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
			
		BufferedReader objReader = null;
		String filbane = mappe + filnavn;
		File file = new File(filbane);
		Blogg samling = null;
		
		try {
			objReader = new BufferedReader(new FileReader(file));
			int antInnlegg = Integer.parseInt(objReader.readLine());
			samling = new Blogg(antInnlegg);
			
			for (int i = 0; i < antInnlegg; i++) {
					
				String type = objReader.readLine();
				
				if (type.equals(TEKST)) {
					
								
					int id = Integer.parseInt(objReader.readLine());
					String bruker = objReader.readLine();
					String dato = objReader.readLine();
					int likes = Integer.parseInt(objReader.readLine());
					String beskrivelse = objReader.readLine();
								
					Tekst tekst = new Tekst(id, bruker, dato, likes, beskrivelse);
					samling.leggTil(tekst);	
					
				} 	
				else if (type.equals(BILDE)) {
					
					int id = Integer.parseInt(objReader.readLine());
					String bruker = objReader.readLine();
					String dato = objReader.readLine();		
					int likes = Integer.parseInt(objReader.readLine());
					String beskrivelse = objReader.readLine();
					String url = objReader.readLine();
					
					Bilde bilde = new Bilde(id, bruker, dato, likes, beskrivelse, url);
					samling.leggTil(bilde);					
				}						
			}				
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
		System.out.println(samling.toString());
		return samling;
	}
	
}
