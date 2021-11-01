package no.hvl.dat100.rektangel;

public class Rektangel {
	int bredde;
	int hogde;
	// Plassering for �verste venstre hj�rne
	Punkt oversteVenstre;
	
	public Rektangel(int bredde, int hogde, int x, int y) {
		this.bredde = bredde;
		this.hogde = hogde;
		oversteVenstre = new Punkt(x, y);
	}

	public void skrivUt() {
		System.out.println("Bredde: " + bredde + ", H�gde: " + hogde);
		System.out.print("�verste venstre hj�rne: ");
		oversteVenstre.skrivUt();
	}
}
