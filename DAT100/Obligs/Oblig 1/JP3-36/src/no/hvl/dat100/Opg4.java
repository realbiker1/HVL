package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class Opg4 {
	
	public static void main(String[] args) {
		
		int brutto = Integer.parseInt(showInputDialog("Bruttoinntekt"));
		
		double trinn1 = 1.9/100;																							//Deklarasjoner, sats.
	    double trinn2 = 4.2/100;
		double trinn3 = 13.2/100;
		double trinn4 = 16.2/100;
		
		int klasse1 = 180800;																								//Deklarasjoner, øvre klasse.
		int klasse2 = 254500;
		int klasse3 = 639750;
		int klasse4 = 999550;
		
		double skatt1 = (klasse2-klasse1)*trinn1;																			//Deklarasjoner for maks skatt i klasse X.
		double skatt2 = (klasse3-klasse2)*trinn2+skatt1;
		double skatt3 = (klasse4-klasse3)*trinn3+skatt2;
		
		double totskatt = 0;
		
		if (brutto >= 0) {
			if (brutto <= klasse1) {																						//Trinn 0.
				totskatt = 0;				
			}
			else if (brutto > klasse1 && brutto <= klasse2) {																//Trinn 1.
				totskatt = (brutto-klasse1)*trinn1;
			}
			else if (brutto > klasse2 && brutto <= klasse3) {																//Trinn 2.
				totskatt = (brutto-klasse2)*trinn2+skatt1;
			}
			else if (brutto > klasse3 && brutto <= klasse4) {																//Trinn 3.
				totskatt = (brutto-klasse3)*trinn3+skatt2;	
			}	else  {
				totskatt = (brutto-klasse4)*trinn4+skatt3;																	//Trinn 4.
			}
			showMessageDialog(null, "Med en inntekt på " + brutto + " kroner, blir skattebeløpet: " + totskatt + ".");		//Svar hvis brutto er et positivt tall.	
		} 	else {																											
				showMessageDialog(null, "Kan ikke taste inn negativt beløp.");												//Svar hvis brutto er et negativt tall.
		}		
		
	}		
	
}