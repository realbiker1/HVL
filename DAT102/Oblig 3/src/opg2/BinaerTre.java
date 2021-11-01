package opg2;

public class BinaerTre {
		
	private BinaerTreNode rot;
		
	public int antall() {
		return 0;
	}
		
	public BinaerTre() {
		rot = null;
	}
		
	public void visPostOrden() {
		visPostOrdenHjelp(rot);
	}
	
	private void visPostOrdenHjelp(BinaerTreNode n) {
		
		if (n == null) {
			return;
		}
		//Venstre
		visPostOrdenHjelp(n.getVenstre());		
		//Høyre
		visPostOrdenHjelp(n.getHoyre());		
		//Element Print
		System.out.print(n.getElement() + " ");
	}
	
	public boolean finnes(Integer e) {
		return finnesHjelp(e, rot);
	}
	
	private boolean finnesHjelp(Integer e, BinaerTreNode n) {
		
		if (n == null) {
			return false;
		}	
		if (n.getElement().compareTo(e) == 0) {
			return true;
		}		
		//return finnesHjelp(e, n.getVenstre()) || finnesHjelp(e, n.getHoyre());		//Inneffektiv pga hvis vi fant i venstre, må vi fremdeles søke gjennom høyre
		
		if (finnesHjelp(e, n.getVenstre())) {
			return true;
		}		
		return finnesHjelp(e, n.getHoyre());
	}
	
	public int sum() {
		return sumHjelp(rot);
	}
	
	private int sumHjelp(BinaerTreNode n) {
		
		if (n == null) {
			return 0;
		}
		//n.getElement() er den faktiske summen som blir "lagt til".
		return sumHjelp(n.getVenstre()) + sumHjelp(n.getHoyre()) + n.getElement();		
	}
	
	public int hoyde() {
		return hoydeHjelp(rot);
	}
	
	private int hoydeHjelp(BinaerTreNode n) {
		
		if (n == null) {
			return -1;
		}
		
		int venstreHoyde = hoydeHjelp(n.getVenstre());
		int hoyreHoyde = hoydeHjelp(n.getHoyre());
		
		if (venstreHoyde > hoyreHoyde) {
			return venstreHoyde + 1;		
		} else {
			return hoyreHoyde + 1;
		}
	}
	
	public void lagEksempelTre_1() {
		BinaerTreNode v = new BinaerTreNode(7);
		BinaerTreNode h = new BinaerTreNode(1);
		BinaerTreNode r1 = new BinaerTreNode(2);	
		r1.setVenstre(v);
		r1.setHoyre(h);
		
		v = new BinaerTreNode(5);
		h = new BinaerTreNode(15);
		v.setHoyre(h);
		h = new BinaerTreNode(1);
		BinaerTreNode r2 = new BinaerTreNode(9);
		r2.setVenstre(v);
		r2.setHoyre(h);
		
		rot = new BinaerTreNode(13);
		rot.setVenstre(r1);
		rot.setHoyre(r2);
	}
	
	public void lagEksempelTre_2() {
		
		BinaerTreNode n1 = new BinaerTreNode(1);	
		BinaerTreNode v = new BinaerTreNode(2);
		BinaerTreNode h = new BinaerTreNode(5);
		BinaerTreNode temp = new BinaerTreNode(69);
		n1.setHoyre(h);
		
		BinaerTreNode n2 = new BinaerTreNode(17);
		v = new BinaerTreNode(3);
		h = new BinaerTreNode(8);
		n2.setVenstre(v);
		n2.setHoyre(h);
		
		v = new BinaerTreNode(8);
		h = new BinaerTreNode(11);
		v.setHoyre(n1);
		h.setHoyre(n2);		
		
		rot = new BinaerTreNode(4);		
		rot.setVenstre(v);
		rot.setHoyre(h);	
	}
		
}
