package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.StackIF;

public class StackDeque<E> extends Deque<E> implements StackIF<E> {
	/* Obtiene el elemento de la cima de la pila */
	@Override public E getTop() {
		if(!isEmpty()) {
			return this.firstNode.getValue();
		}
		return null;
	}

	/* Pone un elemento en la cima de la pila */
	@Override public void push(E elem) {
		insertFront(elem);
	}

	/* Elimina el elemento que está en la cima de la pila */
	@Override public void pop() {
		removeFront();
	}
}
