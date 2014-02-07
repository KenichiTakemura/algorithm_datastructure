package stack;

public interface Stack<E> {

	void push(E e);

	E pop();

	int size();

	void clear();

	boolean isEmpty();
}
