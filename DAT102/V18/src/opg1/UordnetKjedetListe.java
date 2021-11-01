package opg1;

public class UordnetKjedetListe<T extends Comparable<T>> implements
	UordnetKjedetListeADT<T>{
	
	private int antall;
	private LinearNode<T> foerste;
	private LinearNode<T> siste;
	
	public UordnetKjedetListe (){
		antall = 0;
		foerste = null;
		siste = null;
	}
	
	public int antallLike(T el) {
		
		LinearNode<T> aktuell = foerste;
		int antLike = 0;
		
		for (int i = 0; i < antall; i++) {
			
			if (aktuell.getElement() == el) {
				antLike++;
			}
			
			if (aktuell.getNeste() != null) {
				aktuell = aktuell.getNeste();
			}
			
		}
		return antLike;
	}
	
	public T minste() {
		
		if (foerste == null) {
			return null;
		}
		
		LinearNode<T> aktuell = foerste;
		T minste = aktuell.getElement();
		
		while (aktuell.getNeste() != null) {
			
			if(aktuell.getElement().compareTo(aktuell.getNeste().getElement()) > 0) {
				minste = aktuell.getNeste().getElement();
			}
			aktuell = aktuell.getNeste();
		}
		return minste;
	}
	
	public boolean inneholder(T element){
		
		return inneholderRek(foerste, element);
	}
	private boolean inneholderRek(LinearNode<T> denne, T element){
		
		if (denne == null) {
			return false;
		}
		
		if (denne.getElement().equals(element)) {
			return true;
		}
		return inneholderRek(denne.getNeste(), element);
	}
}
