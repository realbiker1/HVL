package opg2;

import opg1.LinearNode;

public class DobbelNode<T> {
	
	 private DobbelNode<T> neste, forrige;
	 private T element;
	 
	 public DobbelNode() {
		 neste = null;
		 forrige = null;
		 element = null;
	 }

	 public DobbelNode(T elem) {
		 forrige = null;
		 neste = null;
		 element = elem;
	 }

	 public DobbelNode<T> getNeste() {
		 return neste;
	 }

	 public void setNeste(DobbelNode<T> node) {
		 neste = node;
	 }
	 
	 public DobbelNode<T> getForrige() {
		 return forrige;
	 }

	 public void setForrige(DobbelNode<T> node) {
		 neste = forrige;
	 }

	 public T getElement() {
		 return element;
	 }
	 
	 public void setElement(T elem) {
		 element = elem;
	 }

}
