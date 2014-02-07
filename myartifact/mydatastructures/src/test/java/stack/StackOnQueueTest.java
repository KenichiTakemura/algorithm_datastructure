package stack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class StackOnQueueTest {

	@Test
	public void f() {
		Stack<Integer> sq = new StackOnQueue<Integer>();
		assertNull(sq.pop());
		sq.push(1);
		assertEquals(sq.size(), 1);
		sq.pop();
		sq.push(2);
		sq.push(3);
		assertEquals(sq.size(), 2);
		sq.pop();
		sq.push(4);
		assertEquals(sq.size(), 2);
		sq.push(5);
		assertEquals(sq.size(), 3);
		assertEquals((int)sq.pop(), 5);
		assertEquals((int)sq.pop(), 4);
		assertEquals((int)sq.pop(), 2);
		assertEquals(sq.size(), 0);
		assertNull(sq.pop());
	}
}
