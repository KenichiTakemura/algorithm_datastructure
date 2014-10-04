package interviews;

/**
 * This CircularQueue class has two pointers, head and last.
 * Head points to the front element
 * Last points to the last element
 * enqueue method inserts data at Last position if not queue is full
 * dequeue method retrieves data from Head and removes it from queue
 * if not queue is empty
 *
 */
public class CircularQueue {

	// Define the initial value for head and last
	int INIT_VALUE = -1;

	// The pointer to the head position of queue
	int head = INIT_VALUE;
	// The pointer to the last position of queue
	int last = INIT_VALUE;
	// Queue capacity
	int capacity = 0;
	// Array of data
	Integer[] array = null;

	/**
	 * Initialize a Circular Queue with the user-specified size Set head and
	 * last pointers to the initial positions
	 * 
	 * @param size
	 */
	public synchronized void initialize(int size) {
		if (size < 1) {
			throw new RuntimeException("Queue size is too short.");
		}
		if (capacity > 0) {
			throw new RuntimeException("Queue is already initialized.");
		}
		capacity = size;
		array = new Integer[size];
	}

	/**
	 * Check if queue is empty
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return head == INIT_VALUE;
	}

	/**
	 * Check if queue is full
	 * 
	 * @return
	 */
	public boolean isFull() {
		// Last position
		return ((last + 1) % capacity) == head;
	}

	/**
	 * Rrturn the size of queue
	 * 
	 * @return
	 */
	public int size() {
		if(head == INIT_VALUE) {
			return 0;
		}
		return (last - head) + 1;
	}

	/**
	 * Insert data at the end of queue
	 * 
	 * @param data
	 *            Data to be inserted
	 */
	public synchronized void enqueue(int data) {
		if (isFull()) {
			System.err.println("Queue is full.");
			return;
		}
		// Move last pointer forward
		last = (last + 1) % capacity;
		// Insert data at last position
		array[last] = data;
		if (head == INIT_VALUE) {
			// When this is the first data
			// Move head to the same position as last
			head = last;
		}
	}

	/**
	 * Return data from the fron of queue The data is removed from queue
	 * 
	 * @return data Data from the fron of queue
	 */
	public synchronized int dequeue() {
		if (isEmpty()) {
			System.err.println("Queue is empty.");
			// It can throw an exception
			return -1;
		}
		// Get data from the head position
		int data = array[head];
		if (head == last) {
			// Queue is empty
			head = INIT_VALUE;
			last = INIT_VALUE;
		} else {
			// Move head to the next position
			head = (head + 1) % capacity;
		}
		return data;
	}
}
