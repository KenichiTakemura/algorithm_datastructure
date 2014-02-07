package queue;

import linkedlist.CircularLinkedList;
import linkedlist.LinkedList;

public class QueueOnLinkedList<E extends Comparable<? super E>> implements Queue<E> {

	private LinkedList<E> queue = new CircularLinkedList<E>();

	public void enQueue(E e) {
		queue.addLast(e);
	}

	public E deQueue() {
		E e = queue.poll();
		return e;
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public void clear() {
		queue.clear();
	}
}
