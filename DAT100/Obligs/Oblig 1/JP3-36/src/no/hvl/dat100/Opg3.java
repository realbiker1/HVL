package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Opg3 {

	public static void main(String[] args) {
		
		int x = Integer.parseInt(showInputDialog("Tall"));
		double n = Double.parseDouble(showInputDialog("Opphlyd"));
		int y = x;
		
		double m = Math.pow(x,n);
			
		while (n > 1) {
				x = x*y;
				n--;
				
		}	
			System.out.println("Math metoden: " + m);
			System.out.println("While metoden: " + x);				
	}
}
