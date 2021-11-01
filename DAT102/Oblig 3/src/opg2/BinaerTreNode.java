package opg2;

public class BinaerTreNode{
	
	private Integer element;
	private BinaerTreNode venstre;
	private BinaerTreNode hoyre; 
	
	BinaerTreNode (Integer el) {
		element = el;
		venstre = null;
		hoyre = null;
	}

	public Integer getElement() {
		return element;
	}

	public void setElement(Integer element) {
		this.element = element;
	}

	public BinaerTreNode getVenstre() {
		return venstre;
	}

	public void setVenstre(BinaerTreNode venstre) {
		this.venstre = venstre;
	}

	public BinaerTreNode getHoyre() {
		return hoyre;
	}

	public void setHoyre(BinaerTreNode hoyre) {
		this.hoyre = hoyre;
	}
	
	
}
	
	