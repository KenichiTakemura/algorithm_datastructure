package linkedlist;

public interface LinkedList<E extends Comparable<? super E>> {

	int size();

	boolean isEmpty();

	E peek();

	void clear();

	String traverse();

	void addFirst(E e);

	void add(int index, E e);

	void addLast(E e);

	E poll();

	void deleteFirst();

	void delete(int index);

	void deleteLast();

	<T> T[] toArray(T[] a);

	LinkedList<E> sort();

	LinkedList<E> reverse();

	void reverseList();

	void recursiveReverseList();

	boolean isSorted();

	void addInSortedList(E e);
	
	void makeCircularList();

	void makeLoop(int index);

	boolean hasLoop();

	public static class ListNode<E extends Comparable<? super E>> implements
			Comparable<ListNode<E>> {
		E item;
		ListNode<E> next;
		ListNode<E> prev;

		ListNode(E item, ListNode<E> next, ListNode<E> prev) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}

		ListNode(E item, ListNode<E> next) {
			this.item = item;
			this.next = next;
			this.prev = null;
		}

		ListNode(E item) {
			this.item = item;
			this.next = null;
			this.prev = null;
		}

		public int compareTo(ListNode<E> o) {
			return item.compareTo(o.item);
		}

		public String toString() {
			return "[V:" + item.toString() + " Prev:"
					+ (prev == null ? "-" : prev.item) + " Next:"
					+ (next == null ? "-" : next.item) + "]";
		}
	}

}
