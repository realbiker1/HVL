package opg5;

public class Main {

	public static void main(String[] args) {
		
		int[] tab = Tabell.lagTabell(20, 1, 10);
		int[] tab2 = {3, 7, 8, 1, 9, 4};
		
		System.out.println("Usortert Tabell:");
		Tabell.printTab(tab2);
		
		System.out.println("Sortert Tabell:");
		
		Sortering.quickSort(tab2, 0, tab2.length-1);
		Tabell.printTab(tab2);
		
	}

}
