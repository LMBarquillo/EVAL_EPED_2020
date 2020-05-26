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
		if(getNode(this.pointer).getNext() != null) {
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
		if(pos >= 1 && pos <= size()) {
			this.pointer = pos;
		}
	}

	@Override public void insert(E elem) {
		// TODO
	}

	@Override public void remove() {
		// TODO
	}

	@Override public E getElem() {
		return getNode(this.pointer).getValue();
	}

	@Override public void setElem(E elem) {
		getNode(this.pointer).setValue(elem);
	}
}
