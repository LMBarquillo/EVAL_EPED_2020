package es.uned.lsi.eped.EvalJun2020;

public class Deque<E> extends SequenceDL<E> implements DequeIF<E> {
	protected NodeSequence lastNode;

	/* Constructor por defecto */
	public Deque() {
		this.lastNode = null;
	}

	/* Constructor por copia */
	public Deque(SequenceDL<E> s) {
		super(s);
		this.lastNode = this.firstNode;
	}

	/* Obtiene el último nodo de la secuencia */
	public NodeSequence getLastNode() {
		return lastNode;
	}

	/* Obtiene el primer elemento de la colección */
	@Override public E getFront() {
		return isEmpty() ? null : this.firstNode.getValue();
	}

	/* Obtiene el último elemento de la colección */
	@Override public E getBack() {
		return isEmpty() ? null : this.lastNode.getValue();
	}

	/* Inserta un nuevo elemento en la primera posición */
	@Override public void insertFront(E e) {
		NodeSequence newNode = new NodeSequence(e);
		newNode.setNext(this.firstNode);
		if (!isEmpty()) {
			this.firstNode.setPrev(newNode);
		} else {
			this.lastNode = newNode;
		}
		this.firstNode = newNode;
		this.size++;
	}

	/* Inserta un nuevo elemento en la última posición */
	@Override public void insertBack(E e) {
		if (isEmpty()) {
			insertFront(e);
		} else {
			NodeSequence newNode = new NodeSequence(e);
			newNode.setPrev(lastNode);
			lastNode.setNext(newNode);
			this.lastNode = newNode;
			this.size++;
		}
	}

	/* Elimina el primer elemento de la lista */
	@Override public void removeFront() {
		if (!isEmpty()) {
			this.firstNode = this.firstNode.getNext();
			if (this.firstNode != null) {
				this.firstNode.setPrev(null);
			}
			this.size--;
		}
	}

	/* Elimina el último elemento de la lista */
	@Override public void removeBack() {
		if (!isEmpty()) {
			this.lastNode = this.lastNode.getPrev();
			if (this.lastNode != null) {
				this.lastNode.setNext(null);
			}
			this.size--;
		}
	}

	/* Sobrecarga de método clear. Necesaria para poner lastNode a null */
	@Override public void clear() {
		super.clear();
		this.lastNode = null;
	}
}
