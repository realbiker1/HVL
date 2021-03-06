package opg4;

public class BinaerTreNode<T extends Integer>{
	
	private int element;
	private BinaerTreNode<T> venstre;
	private BinaerTreNode<T> hoyre; 
	
	BinaerTreNode (T element2) {
		element = element2;
		venstre = null;
		hoyre = null;
	}

	public int getElement() {
		return element;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public BinaerTreNode<T> getVenstre() {
		return venstre;
	}

	public void setVenstre(BinaerTreNode<T> venstre) {
		this.venstre = venstre;
	}

	public BinaerTreNode<T> getHoyre() {
		return hoyre;
	}

	public void setHoyre(BinaerTreNode<T> hoyre) {
		this.hoyre = hoyre;
	}
	
	
}