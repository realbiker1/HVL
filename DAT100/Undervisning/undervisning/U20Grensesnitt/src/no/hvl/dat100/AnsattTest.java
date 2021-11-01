package no.hvl.dat100;




/*
 *  Testprogram for klassen AnsattSamling.
 */

public class AnsattTest {

  public static void main(String[] args) {

	// Setter av plass til 100 ansatte
	 ObjektSamling ansatte = new ObjektSamling(100);
   
   
    // Setter inn 3 ansatte etter tur
	 Ansatt a = new Ansatt(1, "Ole", "Hansen", 500000);
	 boolean ok = ansatte.settInn(a);
	 if (ok) {
		 System.out.println("Satt inn: " + a.toString());
	 } else {
		 System.out.println("FEIL ved innsetting av: " + a.toString());
	 }
    
	 a = new Ansatt(2, "Kari", "Hansen", 500000);
	 ok = ansatte.settInn(a);
	 if (ok) {
		 System.out.println("Satt inn: " + a.toString());
	 } else {
		 System.out.println("FEIL ved innsetting av: " + a.toString());
	 }
	 
	 
	 a = new Ansatt(313, "Anna", "Karlsen", 600000);
	 ok = ansatte.settInn(a);
	 if (ok) {
		 System.out.println("Satt inn: " + a.toString());
	 } else {
		 System.out.println("FEIL ved innsetting av: " + a.toString());
	 }
	 
    // Viser innholdet av ansatt-samlingen
	 System.out.println();
     System.out.println(ansatte.toString());   
    
    // S�ker fram en ansatt og oppdaterer l�nnen
     Ansatt b = (Ansatt) ansatte.finn("2");
     if (b != null) {
    	 b.setL�nn(b.getL�nn() + 10000);
     } else {
    	 System.out.println("Fant ikke ansatt med gitt nr");
     }
   
     System.out.println();
     System.out.println(ansatte.toString());
    // Merk at ansatt-samlingen er oppdatert
   
    
    
    // Sletter ansatt 1
     ansatte.slett("1");
       
    // Viser innholdet
     System.out.println();
     System.out.println(ansatte.toString());
	  
  }
 
}
