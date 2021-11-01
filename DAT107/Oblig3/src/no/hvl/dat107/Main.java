package no.hvl.dat107;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat107.dao.AnsattDAO;
import no.hvl.dat107.dao.AvdelingDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class Main {

	public static void main(String[] args) {
		
		AnsattDAO ansatt = new AnsattDAO();
		AvdelingDAO avdeling = new AvdelingDAO();
		boolean sleep = false;
		Scanner scan = new Scanner(System.in);
		
		while (!sleep) {
			
			System.out.println("Tast inn for hva du vil gj�re:");
			System.out.println("1: S�k etter ansatt med ID. \n"
							 + "2: S�k etter ansatt med brukernavn. \n"
							 + "3: Skriv ut alle ansatte. \n"
							 + "4: Oppdatere ansatt. \n"
							 + "5: Lagre ny ansatt. \n"
							 + "6: S�ke etter avdeling med ID. \n"
							 + "7: Skriv ut alle ansatte p� en avdeling \n"
							 + "8: Endre avdeling til ansatt \n"
							 + "9: Legge til ny avdeling \n"
							 + "zzz: avslutt program.");
			
			String inp = scan.nextLine();
					
			switch(inp) {
			case "1":
				System.out.println("S�k eter ansatt med ID.");
				System.out.println("Tast inn ID...");
				inp = scan.nextLine();			
				System.out.println(ansatt.finnAnsattMedID(inp));
				break;
				
			case "2":
				System.out.println("S�k eter ansatt med brukernavn.");
				System.out.println("Tast inn brukernavn...");
				inp = scan.nextLine();	
				System.out.println(ansatt.finnAnsattMedBrukernavn(inp));
				break;
				
			case "3":
				System.out.println("Henter alle ansatte...");
				List<Ansatt> ansattListe = ansatt.finnAlleAnsatte();
				System.out.println();
				ansattListe.forEach(System.out::println);
				
				break;
				
			case "4":
				System.out.println("Oppdatere ansatt.");		
				System.out.println("Angi ID til ansatt som skal oppdateres?...");
				inp = scan.nextLine();			
				//If setningen s�rger for at vi bare g�r videre om det finnes en ansatt med ID bruker taster inn
				if (ansatt.finnAnsattMedID(inp) != null) {
								
					String id = inp;
					System.out.println(ansatt.finnAnsattMedID(inp));								
					System.out.println("Tast inn tall for hva du vil oppdatere: \n"
									 + "1: Stilling \n"
									 + "2: L�nn \n"
									 + "3: Stilling og l�nn");
					inp = scan.nextLine();
								
					if (inp.equals("1") || inp.equals("3")) {
						System.out.println("Angi ny stilling...");
						String stilling = scan.nextLine();
						ansatt.oppdatereStilling(Integer.parseInt(id), stilling);
					}
					
					if (inp.equals("2") || inp.equals("3")) {
						
						boolean gyldig = false;
					
						while (!gyldig) {
							System.out.println("Angi ny m�nedsl�nn...");
							inp = scan.nextLine();
							try {
								ansatt.oppdatereLoenn(Integer.parseInt(id), Integer.parseInt(inp));
								gyldig = true;
							} catch (Exception e) {
								System.out.println("M�nedsl�nn m� v�re et tall!");
							}
						}
					}
					System.out.println("Oppdaterte " + ansatt.finnAnsattMedID(id));
				} else {
					System.out.println("Fant ingen ansatte med ID " + inp + ". Pr�v igjen.");
				}
				break;	
				
			case "5":
				boolean gyldig = false;
				System.out.println("Lagre ny ansatt.");
				
				System.out.println("Tast inn Brukernavn...");
				String brukernavn = scan.nextLine();
				
				System.out.println("Tast inn Fornavn...");
				String fornavn = scan.nextLine();
				
				System.out.println("Tast inn Etternavn...");
				String etternavn = scan.nextLine();
				
				LocalDate ansDato = null;			
				while (!gyldig) {
	
					System.out.println("Angi ansettelses�r... (YYYY)");
					String YYYY = scan.nextLine();
					System.out.println("Angi ansettelsesm�ned... (MM)");
					String MM = scan.nextLine();
					System.out.println("Angi ansettelsesdato... (DD)");
					String DD = scan.nextLine();	
					String fullDato = YYYY + "-" + MM + "-" + DD;		
					try {
						ansDato = LocalDate.parse(fullDato);
						gyldig = true;
					} catch (Exception e) {
						System.out.println("Ugyldig format");
					}
				}
				gyldig = false;
				
				System.out.println("Tast inn stilling...");
				String stilling = scan.nextLine();
				
				int maanedsLoenn = 0;
				while (!gyldig) {
					System.out.println("Tast inn m�nedsl�nn...");	
					try {
						maanedsLoenn = scan.nextInt();
						gyldig = true;
					} catch (Exception e) {
						System.out.println("M�nedsl�nn m� v�re et tall");
					}
				}
				scan.nextLine();
				System.out.println("Tast inn avdelingsID...");			
				Avdeling avdeling1 = null;
				
				while (avdeling1 == null) {
					inp = scan.nextLine();			
					avdeling1 = avdeling.finnAvdelingMedId(inp);
					if (avdeling1 == null) {
						System.out.println("Ingen avdeling med ID: " + inp);
						System.out.println("\nTast inn avdelingsID...");
					}
				}				
				Ansatt nyAnsatt = new Ansatt(brukernavn, fornavn, etternavn, ansDato, stilling, maanedsLoenn, avdeling1);
				ansatt.lagreNyAnsatt(nyAnsatt);
				System.out.println("Ny " + ansatt.finnAnsattMedBrukernavn(brukernavn));
				break;
			case "6":
				System.out.println("S�ke etter avdeling med ID.");
				System.out.println("Tast inn ID...");
				inp = scan.nextLine();
				System.out.println(avdeling.finnAvdelingMedId(inp));
				
				break;
			
			case "7":
				System.out.println("Skriv alle ansatte p� en avdeling.");
				System.out.println("Tast inn ID...");
				inp = scan.nextLine();
		
				avdeling.finnAvdelingMedId(inp).skrivUtMedAnsatte();
				
				break;
				
			case "8":
				System.out.println("Endre avdeling til en ansatt.");
				
				inp = scan.nextLine();
				break;
	
			case "9":
				System.out.println("Legge til en ny avdeling.");
				System.out.println("Navn p� ny avdeling...");
				String avdNavn = scan.nextLine();
				System.out.println("AnsattID til sjef for " + avdNavn + "...");
				String nySjefID = scan.nextLine();
				
				if (ansatt.finnAnsattMedID(nySjefID) != null) {
					Ansatt nySjef = ansatt.finnAnsattMedID(nySjefID);
					avdeling.lagreNyAvdeling(avdNavn, nySjef);
				} else {
					System.out.println("Ingen ansatte med ID: " + nySjefID);
				}
				break;
				
			case "zzz":
				sleep = true;
				break;
			default:
				System.out.println("Feil input, pr�v igjen.");
			}
			
			System.out.println("Tast 'zzz' om ferdig. (Enter for � forsette)");
				inp = scan.nextLine();
			
				if (inp.toUpperCase().equals("ZZZ")) {
					System.out.println("Ha det bra :)");
					sleep = true;
				}			
		}
		scan.close();
	}
}
