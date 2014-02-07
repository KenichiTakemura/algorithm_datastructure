package linkedlist;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

public abstract class LinkedListTest {

	protected void add(LinkedList<Integer> ll, int index, Integer e) {
		int size = ll.size();
		Integer h = ll.peek();
		ll.add(index, e);
		dump("Add at " + index + ": ", ll);
		if (index <= 0) {
			assertEquals(ll.peek(), e);
		} else {
			assertEquals(ll.peek(), h);
		}
		assertEquals(ll.size(), size + 1);
	}

	protected void addFirst(LinkedList<Integer> ll, Integer e) {
		int size = ll.size();
		ll.addFirst(e);
		assertEquals(ll.peek(), e);
		assertEquals(ll.size(), size + 1);
		dump("Add First: ", ll);
	}

	protected void addLast(LinkedList<Integer> ll, Integer e) {
		int size = ll.size();
		Integer h = ll.peek();
		ll.addLast(e);
		if (h == null) {
			assertEquals(ll.peek(), e);
		} else {
			assertEquals(ll.peek(), h);
		}
		assertEquals(ll.size(), size + 1);
		dump("Add Last: ", ll);
	}

	public void commonTest(LinkedList<Integer> ll) {
		assertNull(ll.peek());
		addFirst(ll, 1);
		addFirst(ll, 2);
		addFirst(ll, 3);
		addFirst(ll, 4);
		ll.recursiveReverseList();
		dump("Reversed List: ", ll);
		addLast(ll, 5);
		ll.clear();
		addLast(ll, 1);
		ll.clear();
		add(ll, 0, 1);
		add(ll, 1, 2);
		add(ll, 2, 3);
		add(ll, 3, 4);
		try {
			add(ll, 5, 5);
			fail("Expection expected");
		} catch (Exception e) {
		}
		assertFalse(ll.hasLoop());
		ll.makeLoop(1);
	}

	protected void dump(String text, LinkedList<?> ll) {
		System.out.println(text + ll.traverse());
	}

	protected void makeLoop(LinkedList<Integer> ll, int index) {
		assertFalse(ll.hasLoop());
		ll.makeLoop(index);
		dump("Make Loop at " + index + " : ", ll);
		assertTrue(ll.hasLoop());
	}
}
