package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.StackIF;

public class StackDeque<E> extends Deque<E> implements StackIF<E> {
	@Override public E getTop() {
		if(!isEmpty()) {
			return this.firstNode.getValue();
		}
		return null;
	}

	@Override public void push(E elem) {
		insertFront(elem);
	}

	@Override public void pop() {
		removeFront();
	}
}
