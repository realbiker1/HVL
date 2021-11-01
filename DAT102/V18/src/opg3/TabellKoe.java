package opg3;

	
public class TabellKoe<T> implements KoeADT<T>{
	
	private final static int STDK = 100;
	private int bak;
	private T[] koe;
		 
	public TabellKoe() {
		this(STDK);
	}
	
	public TabellKoe (int startKapasitet){
		bak = 0;
		koe = (T[])(new Object[startKapasitet]);
	}
	
	public void innKoe(T element) {
		
		if (antall() == koe.length) {
			utvid();
		}
		
		koe[bak] = element;	
		bak++;
	}
	
	public T utKoe(){
		
		T resultat = koe[0];
		bak--;
		
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i+1];
		}
		
		koe[bak] = null;
		return resultat;
	}
	
	public T foerste(){
		
		if (erTom()) {
			throw new EmptyCollection("Koe");
		}
		
		return koe[0];
	}
	
	private void utvid() {
		
		if (erTom()) {
			throw new EmptyCollection("Koe");
		}
		
		T[] nyKoe = (T[]) (new Object[koe.length * 2]);
		int i = 0;
		
		while (koe[i] != null) {
			nyKoe[i] = koe[i];
		}
		koe = nyKoe;
	}
	
	public boolean erTom() {
		return (bak == 0);
	}
	
	public int antall() {
		return bak;
	}
	
}
