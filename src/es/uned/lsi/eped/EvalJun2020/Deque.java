package es.uned.lsi.eped.EvalJun2020;

public class Deque<E> extends SequenceDL<E> implements DequeIF<E> {
	protected NodeSequence lastNode;

	public Deque() {
		this.lastNode = null;
	}

	public Deque(SequenceDL<E> s) {
		super(s);
		this.lastNode = this.firstNode;
	}

	@Override public E getFront() {
		return this.firstNode.getValue();
	}

	@Override public E getBack() {
		return this.lastNode.getValue();
	}

	@Override public void insertFront(E e) {
		NodeSequence newNode = new NodeSequence(e);
		newNode.setNext(this.firstNode);
		if(!isEmpty()) {
			this.firstNode.setPrev(newNode);
		} else {
			this.lastNode = newNode;
		}
		this.firstNode = newNode;
		this.size++;
	}

	@Override public void insertBack(E e) {
		if(isEmpty()) {
			insertFront(e);
		} else {
			NodeSequence newNode = new NodeSequence(e);
			newNode.setPrev(lastNode);
			lastNode.setNext(newNode);
			this.lastNode = newNode;
			this.size++;
		}
	}

	@Override public void removeFront() {
		if(!isEmpty()) {
			this.firstNode = this.firstNode.getNext();
			this.firstNode.setPrev(null);
			this.size--;
		}
	}

	@Override public void removeBack() {
		if(!isEmpty()) {
			this.lastNode = this.lastNode.getPrev();
			this.lastNode.setNext(null);
			this.size--;
		}
	}

	@Override public void clear() {
		super.clear();
		this.lastNode = null;
	}
}
