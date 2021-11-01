package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Opg6 {

	public static void main(String[] args) {
	
	
		long n = Integer.parseInt(showInputDialog("Finn fakultet av tall 1-20."));
		long o = 1;
		long p = n;
		
		if (n > 0 && n <= 20) {
			while (n > 0) {
				o *= n;
				n--;
				
				if (n == 0)	{
					System.out.println("- - - - - - - - - - - - - - - - - - - - -");	
					System.out.println(p + "! = " + o);	
					System.out.println("- - - - - - - - - - - - - - - - - - - - -");
				}	else {
						System.out.println(o + " * " + n + " = " + o*n);	
					}
			}			
		}	else {
				showMessageDialog(null, "Feil! Kun positive heltall opp til 20.");
			}
	}
}
