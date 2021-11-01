package hvl.no;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {
	
	private int antBurgere;
	private int totBurgere;
	private int kapasitet;
	private Queue<Burger> brett;
	
	public HamburgerBrett(int kapasitet) {
		brett = new LinkedList<Burger>();
		this.kapasitet = kapasitet;
		antBurgere = 0;
		totBurgere = 0;
	}
	
	public Burger addBurger() {
		
		if (antBurgere < kapasitet) {
			Burger hamburger = new Burger(getTotBurgere() + 1);
			brett.add(hamburger);
			antBurgere++;
			totBurgere++;
			return hamburger;
		} else {
			System.out.println("FEIL! Brettet er fullt!!!");
			return null;
		}	
	}
	
	public Burger removeBurger() {
		
		if (!erTom()) {
			Burger burger = getNeste();
			brett.remove();
			antBurgere--;
			return burger;
		} else {
			System.out.println("FEIL! Brettet er tomt!!!");
			return null;
		}	
	}
	
	public boolean erTom() {
		
		if (antBurgere == 0) {
			return true;
		} else {
			return false;
		}	
	}
	
	public int getAntBurgere() {
		return this.antBurgere;
	}
	
	public int getTotBurgere() {
		return totBurgere;
	}

	public void setTotBurgere(int totBurgere) {
		this.totBurgere = totBurgere;
	}
	
	@Override
	public String toString() {	
		return "Brett: " + brett.toString();	
	}

	public Burger getNeste() {
		
		if (!erTom()) {
			return brett.peek();
		}
		return null;	
	}

	public int getKapasitet() {
		return kapasitet;
	}

	
	
	
	

}
