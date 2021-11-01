package hvl.no;

public class Burger {
	
	public int burgerID;

	public Burger(int burgerID) {
		this.burgerID = burgerID;
	}

	public int getBurgerNr() {
		return burgerID;
	}

	public void setBurgerNr(int burgerNr) {
		this.burgerID = burgerNr;
	}
	
	@Override
	public String toString() {
		return "(|" + burgerID + "|)";
	}

}
