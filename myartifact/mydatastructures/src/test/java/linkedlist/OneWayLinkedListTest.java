package linkedlist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class OneWayLinkedListTest extends LinkedListTest {
	@Test
	public void commonTest() {
		super.commonTest(new OneWayLinkedList<Integer>());
	}

	@Test
	public void testIntersection() {
		OneWayLinkedList<Integer> ll = new OneWayLinkedList<>();
		OneWayLinkedList<Integer> other = new OneWayLinkedList<>();
		assertTrue(ll.hasIntersection(other));
		add(ll, 0, 1);
		assertFalse(ll.hasIntersection(other));
		ll.clear();
		add(other, 0, 1);
		assertFalse(ll.hasIntersection(other));
		add(ll, 0, 1);
		assertFalse(ll.hasIntersection(other));
		add(ll, 0, 2);
		add(ll, 0, 3);
		makeLoop(other, 1);
		assertFalse(ll.hasIntersection(other));
		add(ll, 0, 2);
		add(ll, 0, 3);
		makeLoop(ll, 1);
		assertFalse(ll.hasIntersection(other));
		ll.makeIntersection(2, other);
		assertTrue(ll.hasIntersection(other));
		assertTrue(other.hasLoop());
	}

	//@Test
	public void testCircularList() {
		LinkedList<Integer> ll = new OneWayLinkedList<>();
		assertNull(ll.peek());
		addFirst(ll, 1);
		ll.makeCircularList();
		assertEquals((int) ll.size(), 1);
		assertTrue(ll.hasLoop());
		assertEquals((int) ll.poll(), 1);
		assertEquals((int) ll.size(), 0);
		assertNull(ll.peek());
		ll.addFirst(1);
		ll.makeCircularList();
		assertEquals((int) ll.peek(), 1);
		assertEquals((int) ll.size(), 1);
		ll.addFirst(2);

		assertEquals((int) ll.peek(), 2);
		assertEquals((int) ll.size(), 2);
		ll.addFirst(3);

		assertEquals((int) ll.peek(), 3);
		assertEquals((int) ll.size(), 3);
		ll.addFirst(4);
		ll.addLast(5);
		ll.addLast(6);
		assertEquals((int) ll.peek(), 4);
		assertEquals((int) ll.size(), 6);
		// assertEquals((int)ll.poll(), 4);
		// assertEquals((int)ll.peek(), 3);
		// assertEquals((int)ll.size(), 5);
		// assertEquals((int)ll.poll(), 3);
		// assertEquals((int)ll.size(), 4);
		// ll.addLast(3);
		// ll.addLast(3);
		// assertFalse(ll.isSorted());
		// System.out.println(ll.traverse());
		// LinkedList<Integer> sll = ll.sort();
		// sll.addInSortedList(4);
		// sll.addInSortedList(4);
		// sll.addInSortedList(7);
		// sll.addInSortedList(0);
		// assertTrue(sll.isSorted());
		// System.out.println(sll.traverse());
		// assertEquals((int)sll.peek(), 0);
		// System.out.println(sll.reverse().traverse());
		// assertEquals((int)sll.peek(), 0);
		// sll.reverseList();
		// System.out.println(sll.traverse());
		// sll.recursiveReverseList();
		// System.out.println(sll.traverse());
		// ll.clear();
		// ll.reverseList();
		// ll.addFirst(4);
		// ll.addFirst(3);
		// ll.reverseList();
		// System.out.println(ll.traverse());
		// assertTrue(sll.hasLoop());
	}

}
