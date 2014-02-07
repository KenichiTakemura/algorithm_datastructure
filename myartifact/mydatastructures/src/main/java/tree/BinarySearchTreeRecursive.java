package tree;

public class BinarySearchTreeRecursive<E extends Comparable<? super E>> extends
		AbstractBirnarySearchTree<E> {

	public boolean add(E e) {
		if (root == null) {
			root = newNode(e);
		} else {
			addR(root, e);
		}
		return true;
	}

	public int size() {
		return sizeR(root);
	}

	public String toString() {
		return toStringR(root);
	}

	public boolean find(E e) {
		return findNodeR(root, e) != null;
	}

	public boolean delete(E e) {
		return deleteR(root, e) != null;
	}

	public E findMin() {
		return findMinR(root);
	}

	public E findMax() {
		Node<E> node = findMaxR(root);
		return node != null ? node.item : null;
	}

	/*
	 * Private methods
	 */
	private Node<E> addR(Node<E> node, E e) {
		if (node == null) {
			node = newNode(e);
		} else {
			if (e.compareTo(node.item) < 0) {
				node.left = addR(node.left, e);
			} else if (e.compareTo(node.item) > 0) {
				node.right = addR(node.right, e);
			}
		}
		return node;
	}

	private int sizeR(Node<E> node) {
		if (node == null)
			return 0;
		int left = sizeR(node.left);
		int right = sizeR(node.right);
		return 1 + left + right;
	}

	private String toStringR(Node<E> node) {
		if (node == null)
			return "-";
		return "[V:" + node.item + " L:" + toStringR(node.left) + " R:"
				+ toStringR(node.right) + "]";
	}

	private Node<E> findNodeR(Node<E> node, E e) {
		if (node == null)
			return null;
		if (e.compareTo(node.item) < 0) {
			return findNodeR(node.left, e);
		} else if (e.compareTo(node.item) > 0) {
			return findNodeR(node.right, e);
		}
		return node;
	}

	private E findMinR(Node<E> node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.item;
		else
			return findMinR(node.left);
	}

	public String levelTraversal() {
		throw new RuntimeException("Not implemented");
	}
}
