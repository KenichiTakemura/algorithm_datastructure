package linkedlist;

import java.util.Arrays;

public class CircularLinkedList<E extends Comparable<? super E>> extends
		AbstractLinkedList<E> {

	@Override
	public String traverse() {
		StringBuffer buf = new StringBuffer();
		if (head == null)
			return "Empty";
		ListNode<E> current = head;
		do {
			buf.append(current);
			current = current.next;
		} while (current != head);
		return buf.toString();
	}

	@Override
	// TODO
	public void add(int index, E e) {
		super.add(index, e);
		last.next = head;
	}

	@Override
	public E poll() {
		ListNode<E> current = head;
		E item = head.item;
		if (current.next != head) {
			while (current.next != head) {
				current = current.next;
			}
			current.next = head.next;
			head = head.next;
		} else {
			head = null;
		}
		return item;
	}

	@Override
	public void delete(int index) {
		// TODO Auto-generated method stub
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		int size = size();
		if (a.length < size)
			a = (T[]) java.lang.reflect.Array.newInstance(a.getClass()
					.getComponentType(), size);
		int i = 0;
		Object[] result = a;
		ListNode<E> current = head;
		do {
			result[i++] = current.item;
			current = current.next;
		} while (current != head);

		if (a.length > size)
			a[size] = null;

		return a;
	}

	@Override
	public LinkedList<E> sort() {
		@SuppressWarnings("unchecked")
		E[] a = (E[]) this.toArray(new Comparable[0]);
		Arrays.sort(a);
		LinkedList<E> list = new CircularLinkedList<E>();
		for (int i = 0; i < a.length; i++) {
			list.addLast(a[i]);
		}
		return list;
	}

	@Override
	public void addInSortedList(E e) {
		ListNode<E> node = newNode(e);
		ListNode<E> current = head;
		if (head == null) {
			head = node;
			node.next = node;
		} else {
			ListNode<E> temp = null;
			while (current.next != head && current.item.compareTo(e) < 0) {
				temp = current;
				current = current.next;
			}
			if (current.item.compareTo(e) < 0) {
				// Inset e into the last
				node.next = current.next;
				current.next = node;
			} else {
				node.next = current;
				if (temp != null)
					temp.next = node;
				else {
					// Inset e into the first
					current = head;
					while (current.next != head) {
						current = current.next;
					}
					head = node;
					current.next = head;
				}
			}
		}
	}

	@Override
	public LinkedList<E> reverse() {
		LinkedList<E> list = new CircularLinkedList<E>();
		if (head == null) {
			return list;
		}
		ListNode<E> current = head;
		while (current.next != head) {
			list.addFirst(current.item);
			current = current.next;
		}
		list.addFirst(current.item);
		return list;
	}

	@Override
	public void reverseList() {
		if (head == null) {
			return;
		}
		ListNode<E> tail = head;
		while (tail.next != head) {
			tail = tail.next;
		}
		ListNode<E> current = head;
		ListNode<E> temp = tail;
		ListNode<E> next = null;
		while (current.next != head) {
			next = current.next;
			current.next = temp;
			temp = current;
			current = next;
		}
		current.next = temp;
		head = current;
	}

	@Override
	public void recursiveReverseList() {
		recursiveReverse(head);
	}

	private ListNode<E> recursiveReverse(ListNode<E> node) {
		if (node == null)
			return null;
		if (node.next == null)
			return node;
		ListNode<E> nextNode = node.next;
		node.next = null;
		ListNode<E> reversed = recursiveReverse(nextNode);
		nextNode.next = node;
		return reversed;
	}

	@Override
	public void makeLoop(int index) {
		// Already circulated
	}

}
