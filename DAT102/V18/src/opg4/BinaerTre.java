package opg4;


public class BinaerTre<T> {
	
	private BinaerTreNode<Integer> rot;
	private int antall = 0;
		
	public BinaerTre() {
		rot = null;
		antall = 0;
	}
	
	public BinaerTre(Integer element) {
		rot = new BinaerTreNode<Integer>(element);
		antall = 1;
	}
	
	public BinaerTre(BinaerTre<Integer> vt, BinaerTre<Integer> ht, int element) {
		
		rot = new BinaerTreNode<Integer>(element);
		rot.setVenstre(vt.getRot());
		rot.setHoyre(ht.getRot());
		
		antall = vt.getAntall() + ht.getAntall() + 1;
	}
	
	public BinaerTreNode<Integer> getRot() {
		return rot;
	}

	public void setRot(BinaerTreNode<Integer> rot) {
		this.rot = rot;
	}

	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}
	
	public int Hoyde(BinaerTreNode<Integer> rot) {
		return HoydeRek(rot);
	}
	
	public int HoydeRek(BinaerTreNode<Integer> n) {
		
		if (n == null) {
			return -1;
		}		
		int vHoyde = HoydeRek(n.getVenstre());
		int hHoyde = HoydeRek(n.getHoyre());
	
		if (hHoyde > vHoyde) {
			return hHoyde + 1;
		} else {
			return vHoyde + 1;
		}
	}

	//inorden
	public void visInOrden() {
		System.out.println();
		visInOrdenHjelp(rot);
		System.out.print(" (Inorden)");
	}
	
	private void visInOrdenHjelp(BinaerTreNode<Integer> n) {
		
		if(n == null) {
			return;
		}
		visInOrdenHjelp(n.getVenstre());
		System.out.print(n.getElement() + " ");
		visInOrdenHjelp(n.getHoyre());
	}//inorden end
	
	//preorden
	public void visPreOrden() {
		System.out.println();
		visPreOrdenHjelp(rot);
		System.out.print(" (Preorden)");
	}
	
	private void visPreOrdenHjelp(BinaerTreNode<Integer> n) {
		
		if(n == null) {
			return;
		}
		System.out.print(n.getElement() + " ");
		visPreOrdenHjelp(n.getVenstre());
		visPreOrdenHjelp(n.getHoyre());
	}//preorden end
		
	//postorden	
	public void visPostOrden() {
		System.out.println();
		visPostOrdenHjelp(rot);
		System.out.print(" (Postorden)");
	}
	
	private void visPostOrdenHjelp(BinaerTreNode<Integer> n) {
		
		if (n == null) {
			return;
		}
		visPostOrdenHjelp(n.getVenstre());		
		visPostOrdenHjelp(n.getHoyre());		
		System.out.print(n.getElement() + " ");
	}//postorden end
	
	//revers inorden
	public void visReversInOrden() {
		System.out.println();
		visReversInOrdenHjelp(rot);
		System.out.print(" (Revers inorden)");
	}
	
	private void visReversInOrdenHjelp(BinaerTreNode<Integer> n) {
		
		if(n == null) {
			return;
		}
		visReversInOrdenHjelp(n.getHoyre());
		System.out.print(n.getElement() + " ");
		visReversInOrdenHjelp(n.getVenstre());
	}//revers inorden end
	
	//niv� orden
	public void visNivOrden() {
		
		System.out.println();
		//For l�kke printer ut elementene i hvert niv�.
		for (int i = 0; i <= hoyde(); i++) {
			visNivOrdenHjelp(rot, i);
		}
		System.out.print(" (Niv� orden)");		
	}
	
	private void visNivOrdenHjelp(BinaerTreNode<Integer> n, int niv) {
		
		if(n == null) {
			return;
		}
		if (niv == 0) {
			System.out.print(n.getElement() + " ");
		}else if (niv > 0) {
			visNivOrdenHjelp(n.getVenstre(), niv-1);
			visNivOrdenHjelp(n.getHoyre(), niv-1);
		}		
	}//niv� orden end
	
	public boolean finnes(int e) {
		return finnesHjelp(e, rot);
	}
	
	private boolean finnesHjelp(int e, BinaerTreNode<Integer> n) {
		
		if (n == null) {
			return false;
		}		
		if (n.getElement() == e) {
			return true;
		}
		return finnesHjelp(e, n.getVenstre()) || finnesHjelp(e, n.getHoyre());
	}
	
	public int sum() {
		return sumHjelp(rot);
	}
	
	private int sumHjelp(BinaerTreNode<Integer> n) {
		
		if (n == null) {
			return 0;
		}
		int sum = n.getElement() + sumHjelp(n.getVenstre()) + 
								   sumHjelp(n.getHoyre());
		return sum;		
	}
	
	public int finnMinste() {
		return finnMinsteHjelp(rot);
	}
	
	public int finnMinsteHjelp(BinaerTreNode<Integer> n) {
						
		if (n == null) {
			return Integer.MAX_VALUE;
		} 
		
		int resultat = n.getElement();
		int venstreRes = finnMinsteHjelp(n.getVenstre());
		int hoyreRes = finnMinsteHjelp(n.getHoyre());
			
		if(venstreRes < resultat) {
			resultat = venstreRes;
		}
		if(hoyreRes < resultat) {
			resultat = hoyreRes;
		}	
		return resultat;
	}
	
	@SuppressWarnings("null")
	
	public int finnMinBStre() {
		
		if (rot == null) {
			return (Integer)null;
		} else {
			
			BinaerTreNode<Integer> n = rot;
	
			while(n.getVenstre() != null) {
				n = n.getVenstre();
			}
			return n.getElement();
		}
	}
	
	
	public BinaerTreNode<Integer> sortTabTilBST(Integer[] tab) {
		return sortTabTilBSTRek(tab, 0, tab.length-1);
	}
	
	private BinaerTreNode<Integer> 
	sortTabTilBSTRek (Integer[] tab, int min, int maks) {
		
		BinaerTreNode<Integer> rot = null;
		
		if (min > maks) {
			return null;
		}	
		int mid = (min + maks)/2;	
		rot = new BinaerTreNode<Integer>(tab[mid]);
		
		rot.setVenstre(sortTabTilBSTRek(tab, min  , mid-1));
		  rot.setHoyre(sortTabTilBSTRek(tab, mid+1, maks));
		
		return rot;		
	}
	
	
	
	public int hoyde() {
		return hoydeHjelp(rot);
	}
	
	private int hoydeHjelp(BinaerTreNode<Integer> n) {
		
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
		BinaerTreNode<Integer> v = new BinaerTreNode<Integer>(7);
		BinaerTreNode<Integer> h = new BinaerTreNode<Integer>(1);
		BinaerTreNode<Integer> r1 = new BinaerTreNode<Integer>(2);	
		r1.setVenstre(v);
		r1.setHoyre(h);
		
		v = new BinaerTreNode<Integer>(5);
		h = new BinaerTreNode<Integer>(15);
		v.setHoyre(h);
		h = new BinaerTreNode<Integer>(1);
		BinaerTreNode<Integer> r2 = new BinaerTreNode<Integer>(9);
		r2.setVenstre(v);
		r2.setHoyre(h);
		
		rot = new BinaerTreNode<Integer>(13);
		rot.setVenstre(r1);
		rot.setHoyre(r2);
	}
	
	public void lagEksempelTre_2() {
		
		BinaerTreNode<Integer> n1 = new BinaerTreNode<Integer>(2);	
		BinaerTreNode<Integer> v = new BinaerTreNode<Integer>(6);
		BinaerTreNode<Integer> h = new BinaerTreNode<Integer>(3);
		n1.setHoyre(h);
		
		BinaerTreNode<Integer> n2 = new BinaerTreNode<Integer>(7);
		h = new BinaerTreNode<Integer>(8);
		n2.setVenstre(v);
		n2.setHoyre(h);
		
		v = new BinaerTreNode<Integer>(1);
		h = new BinaerTreNode<Integer>(5);
		v.setHoyre(n1);
		h.setHoyre(n2);		
		
		rot = new BinaerTreNode<Integer>(4);		
		rot.setVenstre(v);
		rot.setHoyre(h);	
	}
		
}
