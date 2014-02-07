package stack;

import queue.Queue;
import queue.QueueOnLinkedList;

/**
 * Implement stack using queues
 * 
 * @author ktakemur
 * 
 * @param <E>
 */
public class StackOnQueue<E extends Comparable<? super E>> implements Stack<E> {

	private Queue<E> queue1 = new QueueOnLinkedList<E>();
	private Queue<E> queue2 = new QueueOnLinkedList<E>();

	public void push(E e) {
		// If Q1 is empty then enqueue e to Q2
		// If Q1 is not empty but Q2 is empty enqueue e to Q1
		if (queue1.isEmpty()) {
			queue2.enQueue(e);
		} else {
			queue1.enQueue(e);
		}
	}

	public E pop() {
		if (!queue2.isEmpty()) {
			int size = queue2.size();
			int i = 0;
			while (i < size - 1) {
				queue1.enQueue(queue2.deQueue());
				i++;
			}
			return queue2.deQueue();
		} else if (!queue1.isEmpty()) {
			int size = queue1.size();
			int i = 0;
			while (i < size - 1) {
				queue2.enQueue(queue1.deQueue());
				i++;
			}
			return queue1.deQueue();
		}
		return null;
	}

	public int size() {
		return queue1.isEmpty() ? queue2.size() : queue1.size();
	}

	public void clear() {
		if (queue1.isEmpty())
			queue2.clear();
		else
			queue1.clear();
	}

	public boolean isEmpty() {
		return queue1.isEmpty() && queue2.isEmpty();
	}
}
