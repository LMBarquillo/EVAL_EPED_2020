package es.uned.lsi.eped.EvalJun2020;

public class ListIP<E> extends SequenceDL<E> implements ListIPIF<E> {
	private int pointer;

	/* Constructor por defecto */
	public ListIP() {
		super();
		this.pointer = 1;
	}

	/* Constructor por copia */
	public ListIP(SequenceDL<E> s) {
		super(s);
		this.pointer = 1;
	}

	/* Obtiene la posición actual del punto de interés */
	@Override public int getPointer() {
		return this.pointer;
	}

	/* Mueve el punto de interés una posición adelante */
	@Override public void moveNext() {
		if(this.pointer <= this.size) {
			this.pointer++;
		}
	}

	/* Retrocede una posición el punto de interés */
	@Override public void movePrev() {
		if(this.pointer > 1) {
			this.pointer--;
		}
	}

	/* Mueve el puntero de interés a una posición determinada */
	@Override public void moveTo(int pos) {
		if(pos >= 1 && pos <= this.size + 1) {
			this.pointer = pos;
		}
	}

	/* Inserta un nuevo elemento en la posición del puntero de interés */
	@Override public void insert(E elem) {
		NodeSequence newNode = new NodeSequence(elem);
		if(this.pointer == 1) {
			newNode.setNext(this.firstNode);
			this.firstNode = newNode;
		} else {
			NodeSequence prevNode = getNode(this.pointer - 1);
			NodeSequence nextNode = prevNode.getNext();
			prevNode.setNext(newNode);
			newNode.setNext(nextNode);
			newNode.setPrev(prevNode);
			if (nextNode != null) {
				nextNode.setPrev(newNode);
			}
		}
		this.size++;
	}

	/* Elimina el elemento en la posición del puntero */
	@Override public void remove() {
		if(this.pointer == 1) {
			this.firstNode = this.firstNode.getNext();
		} else {
			NodeSequence prevNode = getNode(this.pointer - 1);
			NodeSequence nextNode = prevNode.getNext().getNext();
			prevNode.setNext(nextNode);
			if (nextNode != null) {
				nextNode.setPrev(prevNode);
			}
		}
		this.size--;
	}

	/* Obtiene el elemento de la posición actual del puntero */
	@Override public E getElem() {
		return getNode(this.pointer).getValue();
	}

	/* Sobrescribe el valor del elemento de la posicion actual del puntero */
	@Override public void setElem(E elem) {
		getNode(this.pointer).setValue(elem);
	}
}
