package opg4;


public class Main {

	public static void main(String[] args) {
		
		BinaerTre<Integer> tre1 = new BinaerTre<Integer>();
		BinaerTre<Integer> tre2 = new BinaerTre<Integer>();
					
		tre1.lagEksempelTre_1();	
		tre2.lagEksempelTre_2();
		
		BinaerTre<Integer> tre3 = new BinaerTre<Integer>(tre1, tre2, 4);
		
		int sokTall = 5;
		
		//Tre 1 
		System.out.print("Tre 1:");
		
			tre1.visInOrden();
			tre1.visPreOrden();
			tre1.visPostOrden();
			tre1.visReversInOrden();
			tre1.visNivOrden();
			
			System.out.println("\n\nMinst: " + tre1.finnMinste());
			System.out.println("Høyde: " + tre1.hoyde());
			System.out.println("Sum: " + tre1.sum());
			System.out.print("Fins tallet " + sokTall + "? ");
			if (tre1.finnes(sokTall)) {
				System.out.println("JA");
			} else {
				System.out.println("NEI");
			}
			System.out.print("- - - - - - - - - - - - - - - - - - - - - -");
		//Tre 2
		System.out.print("\nTre 2:");
		
			tre2.visInOrden();
			tre2.visPreOrden();			
			tre2.visPostOrden();
			tre2.visReversInOrden();
			tre2.visNivOrden();
			
			System.out.println("\n\nMinst: " + tre2.finnMinste());
			System.out.println("Høyde: " + tre2.hoyde());
			System.out.println("Sum: " + tre2.sum());
			System.out.print("Fins tallet " + sokTall + "? ");
			if (tre2.finnes(sokTall)) {
				System.out.println("JA");
			} else {
				System.out.println("NEI");
			}
			System.out.print("- - - - - - - - - - - - - - - - - - - - - -");
		//Tre 3
		System.out.print("\nTre 3:");
		
		
			tre3.visInOrden();
			tre3.visPreOrden();			
			tre3.visPostOrden();
			tre3.visReversInOrden();
			tre3.visNivOrden();
			System.out.println("\n\nMinst: " + tre3.finnMinste());	
			System.out.println("Høyde: " + tre3.hoyde());
			System.out.println("Sum: " + tre3.sum());
			System.out.print("Fins tallet " + sokTall + "? ");
			if (tre3.finnes(sokTall)) {
				System.out.println("JA");
			} else {
				System.out.println("NEI");
			}
	}

}