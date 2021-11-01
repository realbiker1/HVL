package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Opg2 {

	public static void main(String[] args) {
		
		int nedregrense = Integer.parseInt(showInputDialog("Nedre grense"));
		int ovregrense = Integer.parseInt(showInputDialog("Øvre grense"));
		String tall = "";
		
		if (nedregrense % 2 != 1) {
			nedregrense++;
		}
		
		while (nedregrense <= ovregrense) {
			tall = tall + nedregrense + ", ";
			nedregrense += 2;
		}
		showMessageDialog(null, "Oddetallene er " + tall);
	}
}
