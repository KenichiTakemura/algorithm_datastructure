package tree;

public class Node<E extends Comparable<? super E>> implements
		Comparable<Node<E>> {
	E item;
	Node<E> left;
	Node<E> right;

	Node(E item, Node<E> left, Node<E> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public int compareTo(Node<E> o) {
		return item.compareTo(o.item);
	}

	public String toString() {
		return "[V:" + item.toString() + " L:" + (left == null ? "-" : left.item)
				+ " R:" + (right == null ? "-" : right.item) + "]";
	}

}
