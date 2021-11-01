package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Opg5 {

	public static void main(String[] args) {
		
		String karakter;
		
		int poeng; 
		
		int student = 10;
		
		for (int i = 1 ; i <= student ; i++) {
			poeng = Integer.parseInt(showInputDialog("Poeng, student " + i));
			if (poeng >= 0 && poeng <= 100) {
				if (poeng <= 100 && poeng >= 90 ) {									
					karakter = "A";			
				}
				else if (poeng < 90 && poeng >= 80) {									 
					karakter = "B";			
				}
				else if (poeng < 80 && poeng >= 60) {									
					karakter = "C";
				}
				else if (poeng < 60 && poeng >= 50) {									
					karakter = "D";
				}
				else if (poeng < 50 && poeng >= 40) {									
					karakter = "E";
				} 	
				else {									
					karakter = "F";
				}
				showMessageDialog(null, "Student nummer " + i + " har karakter: " + karakter);
				
			}	else {
				showMessageDialog(null, "Ugyldig poengsum!");
				i--;
			}
		}		
	}
}