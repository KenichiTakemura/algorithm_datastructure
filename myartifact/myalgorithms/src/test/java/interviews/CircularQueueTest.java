package interviews;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CircularQueueTest {

	CircularQueue queue = null;

	@Before
	public void beforeTest() {
		queue = new CircularQueue();
	}

	@Test(expected = RuntimeException.class)
	public void test1() {
		queue.initialize(0);
	}

	@Test(expected = RuntimeException.class)
	public void test2() {
		queue.initialize(1);
		queue.initialize(1);
	}

	@Test
	public void test3() {
		queue.initialize(1);
		queue.enqueue(1);
		assertEquals(queue.size(), 1);
		queue.enqueue(2);
		assertEquals(queue.size(), 1);
	}
	
	@Test
	public void test4() {
		queue.initialize(1);
		queue.enqueue(1);
		assertEquals(queue.size(), 1);
		assertTrue(queue.isFull());
		assertEquals(queue.dequeue(),1);
		assertTrue(queue.isEmpty());
		assertEquals(queue.size(), 0);
		queue.dequeue();
	}

	@Test
	public void test5() {
		queue.initialize(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		assertEquals(queue.size(), 3);
		assertEquals(queue.dequeue(),1);
		assertEquals(queue.dequeue(),2);
		assertEquals(queue.dequeue(),3);
		assertEquals(queue.size(), 0);
	}
}
