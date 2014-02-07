package linkedlist;

import java.util.Hashtable;

import linkedlist.LinkedList.ListNode;

public class OneWayLinkedList<E extends Comparable<? super E>> extends
		AbstractLinkedList<E> {


	@Override
	public String traverse() {
		StringBuffer buf = new StringBuffer();
		if (head == null)
			return "Empty";
		ListNode<E> current = head;
		while (current != null && current != last) {
			buf.append(current);
			current = current.next;
		}
		if(current == last) {
			buf.append(last);
		}
		return buf.toString();
	}

	@Override
	public E poll() {
		if(head == null) return null;
		E item = head.item;
		if(head == last) {
			head = last = null;
		} else {
			head = head.next;
			if(last.next != null) {
				last.next = head;
			}
		}
		return item;
	}

	@Override
	public void delete(int index) {
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<E> sort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<E> reverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reverseList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void recursiveReverseList() {
		last = head;
		head = recursiveReverse(head);
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
	public void addInSortedList(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeLoop(int index) {
		if(head == null) return;
		checkIndexRange(index);
		int k = 0;
		ListNode<E> current = head;
		while (k < index) {
			current = current.next;
			k++;
		}
		last.next = current;
	}

	public void makeIntersection(int index, OneWayLinkedList<E> other) {
		checkIndexRange(index);
		int k = 0;
		ListNode<E> current = head;
		while (k < index) {
			current = current.next;
			k++;
		}
		other.last.next = current;
	}

	public boolean hasIntersection(OneWayLinkedList<E> other) {
		// Both empty is true
		if (this.head == null && other.head == null)
			return true;
		if (this.head == null)
			return false;
		if (other.head == null)
			return false;
		Hashtable<ListNode<E>, Integer> table = new Hashtable<>();
		ListNode<E> current = this.head;
		while (current != null) {
			if (table.get(current) != null)
				// Loop
				break;
			table.put(current, 0);
			current = current.next;
		}
		current = other.head;
		while (current != null) {
			Integer v = table.get(current);
			if (v == null)
				table.put(current, 1);
			else if (v == 0)
				// Intersection
				return true;
			else {
				// Loop
				System.err.println(other + " has a loop");
				break;
			}
			current = current.next;
		}
		return false;
	}

}
