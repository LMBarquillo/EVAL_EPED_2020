package es.uned.lsi.eped.EvalJun2020;

import es.uned.lsi.eped.DataStructures.QueueIF;

public class QueueDeque<E> extends Deque<E> implements QueueIF<E> {
	/* Obtiene el primer elemento de la cola */
	@Override public E getFirst() {
		if (!isEmpty()) {
			return this.firstNode.getValue();
		}
		return null;
	}

	/* Mete un nuevo elemento en la cola, en último lugar */
	@Override public void enqueue(E elem) {
		insertBack(elem);
	}

	/* Saca el primer elemento de la cola */
	@Override public void dequeue() {
		removeFront();
	}
}
