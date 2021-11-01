package opg2;

public class DobbelKjedetOrdnetListe<T extends Comparable <T>>
			implements DobbelKjedetOrdnetListeADT<T> {
	
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetOrdnetListe(T minVerdi, T maksVerdi) {
		
		antall = 0;
		foerste = new DobbelNode<T>(minVerdi);
		siste = new DobbelNode<T>(maksVerdi);
		
		foerste.setNeste(siste);
		siste.setForrige(foerste);
	}
	
	public void leggTil(T el) {
		
		DobbelNode<T> nyNode = new DobbelNode<T>(el);
		DobbelNode<T> aktuell = foerste;
		
		while (el.compareTo(aktuell.getElement()) > 0) {
			aktuell = aktuell.getNeste();
		}
			nyNode.setNeste(aktuell);
			nyNode.setForrige(aktuell.getForrige());
			aktuell.getForrige().setNeste(nyNode);
			aktuell.setForrige(nyNode);
					
			antall++;
		}
		

		
		
	
}

