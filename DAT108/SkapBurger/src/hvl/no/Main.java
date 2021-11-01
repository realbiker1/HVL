package hvl.no;

public class Main {
	
	public static void main(String[] args) {
		
		final String[] kokker = {"Nils", "Lise", "John"};
		final String[] servitorer = {"Ole", "Ola"};
		final int KAPASITET = 4;
	
		printHeader(kokker, servitorer, KAPASITET);
				
		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		
		for(String navn : kokker) {
			new Kokk(brett, navn).start();
		}
		for(String navn : servitorer) {
			new Servitor(brett, navn).start();
		}
	}
	
	private static void printHeader(String[] kokker, String[] servitorer, int KAPASITET) {
		
		String s = "Kokker: ";
		int i = 0;
		
		for(String navn : kokker) {
			if (i < kokker.length - 2) {
				s += navn + ", ";
				i++;
			} else if (i < kokker.length - 1) {
				s += navn + " og ";
				i++;
			} else {
				s += navn + ".\nServitører: ";
				i = 0;
			}
		}
		
		for(String navn : servitorer) {
			if (i < servitorer.length - 2) {
				s += navn + ", ";
				i++;
			} else if (i < servitorer.length - 1) {
				s += navn + " og ";
				i++;
			} else {
				s += navn + ".\n";
			}
		}
		
		System.out.println(s + "Brettet har plass til " + KAPASITET + " hamburgere. \nStarter burgerproduksjon...");
		System.out.println("______________________________________");
	}
}
