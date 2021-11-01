package opg5;

import java.util.Random;

public class Tabell {
	
	public static int[] lagTabell(int size, int min, int max) {
		
		Random r = new Random(0);
		int[] tab = new int[size];
		
		for(int i = 0; i < size; i++) {
			tab[i] = r.nextInt((max + 1) - min) + min;
		}
		return tab;
	}
	
	public static void printTab(int[] tab) {
		
		if (erTom(tab)) {
			System.out.println("Tabellen er tom");
		} else {
			String toPrint = "[ ";
			for (int i : tab) {
				toPrint = toPrint + i + ", ";
			}
			System.out.println(toPrint.substring(0, toPrint.length()-2) + " ]");
		}	
	}
	
	private static boolean erTom(int[] tab) {
		return tab.length == 0;		
	}
	
	

}
