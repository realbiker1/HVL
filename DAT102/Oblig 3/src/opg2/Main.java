package opg2;

public class Main {

	public static void main(String[] args) {
		
		BinaerTre tre1 = new BinaerTre();
		BinaerTre tre2 = new BinaerTre();
				
		tre1.lagEksempelTre_1();	
		tre2.lagEksempelTre_2();
		
		int sokTall = 1;
		
		//Tre 1 
		System.out.println("Tre 1:");
			tre1.visPostOrden();
			System.out.println("\nHøyde: " + tre1.hoyde());
			System.out.println("Sum: " + tre1.sum());
			System.out.println("Fins " + sokTall + "? "+ tre1.finnes(sokTall));
		//Tre 2
		System.out.println("\nTre 2:");
			tre2.visPostOrden();
			System.out.println("\nHøyde: " + tre2.hoyde());
			System.out.println("Sum: " + tre2.sum());
			System.out.println("Fins " + sokTall + "? "+ tre2.finnes(sokTall));

	}

}
