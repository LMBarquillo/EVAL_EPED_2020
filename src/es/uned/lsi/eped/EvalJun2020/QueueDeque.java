package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.QueueIF;

public class QueueDeque<E> extends Deque<E> implements QueueIF<E> {
	@Override public E getFirst() {
		if(!isEmpty()) {
			return this.firstNode.getValue();
		}
		return null;
	}

	@Override public void enqueue(E elem) {
		insertBack(elem);
	}

	@Override public void dequeue() {
		removeFront();
	}
}
