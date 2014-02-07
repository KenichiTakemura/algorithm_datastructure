package linkedlist;


public abstract class AbstractLinkedList<E extends Comparable<? super E>>
		implements LinkedList<E> {

	protected ListNode<E> head = null;

	// Hold a pointer reference to the last node has a great benefit to reduce
	// liner search for the least node every time required
	protected ListNode<E> last = null;

	ListNode<E> newNode(E e) {
		return new ListNode<E>(e);
	}

	void checkIndexRange(int index) {
		int size = this.size();
		if (0 > index || this.size() < index) {
			throw new IndexOutOfBoundsException(index + " is out of range. size: " + size);
		}
	}

	@Override
	public int size() {
		if (head == null)
			return 0;
		ListNode<E> current = head;
		int count = 0;
		do {
			current = current.next;
			count++;
			// List ending condition
			// OnewayList current == null
			// CircularList current == head or current == last
		} while (current != null && current != head && current != last);
		if(head != last && current == last) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		ListNode<E> current = head;
		ListNode<E> next = null;
		while (current != null && current != head) {
			next = current.next;
			current.item = null;
			current.next = null;
			current.prev = null;
			current = next;
		}
		head = null;
		last = null;
	}

	@Override
	public E peek() {
		if (head != null) {
			return head.item;
		}
		return null;
	}

	@Override
	public boolean isSorted() {
		if (head == null)
			return true;
		ListNode<E> current = head;
		ListNode<E> temp = head;
		while (current.next != head) {
			current = current.next;
			if (temp.item.compareTo(current.item) > 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean hasLoop() {
		ListNode<E> slowPtr = head;
		ListNode<E> fastPtr = head;
		while (slowPtr != null && fastPtr != null) {
			fastPtr = fastPtr.next;
			// This == is pointers check
			if (fastPtr == slowPtr)
				return true;
			if (fastPtr == null)
				return false;
			fastPtr = fastPtr.next;
			if (fastPtr == slowPtr)
				return true;
			slowPtr = slowPtr.next;
		}
		return false;
	}

	@Override
	public void deleteFirst() {
		delete(0);
	}

	@Override
	public abstract void delete(int index);

	@Override
	public void deleteLast() {
		delete(this.size() - 1);
	}

	@Override
	public void addFirst(E e) {
		add(0, e);
	}

	@Override
	public void add(int index, E e) {
		checkIndexRange(index);
		ListNode<E> node = newNode(e);
		if (head == null) {
			head = node;
			last = node;
		} else {
			int k = 0;
			ListNode<E> current = head;
			ListNode<E> prev = null;
			while (k < index) {
				prev = current;
				current = current.next;
				k++;
			}
			node.next = current;
			if (prev == null) {
				head = node;
			} else {
				prev.next = node;
				if (current == null || current == head) {
					last = node;
					if(current == head)
						last.next = head;
				}
			}
		}
	}

	public void addLast(E e) {
		add(this.size(), e);
	}

	public void makeCircularList() {
		makeLoop(0);
	}
	
	public abstract void makeLoop(int index);
}
