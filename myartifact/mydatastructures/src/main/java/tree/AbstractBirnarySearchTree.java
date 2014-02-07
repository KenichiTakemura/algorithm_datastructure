package tree;


public abstract class AbstractBirnarySearchTree<E extends Comparable<? super E>>
		extends AbstractBirnaryTree<E> {

	protected Node<E> deleteR(Node<E> node, E e) {
		if (node != null) {
			if (e.compareTo(node.item) < 0) {
				node.left = deleteR(node.left, e);
			} else if (e.compareTo(node.item) > 0) {
				node.right = deleteR(node.right, e);
			} else {
				// Found item
				if (node.left != null && node.right != null) {
					// Have two children
					Node<E> maxLeft = findMaxR(node.left);
					node.item = maxLeft.item;
					node.left = deleteR(node.left, maxLeft.item);
				} else {
					if (node.left == null) {
						node = node.right;
					} else if (node.right == null) {
						node = node.left;
					}
				}
			}
		}
		return node;
	}

	protected Node<E> findMaxR(Node<E> node) {
		if (node == null)
			return null;
		if (node.right == null)
			return node;
		else
			return findMaxR(node.right);
	}

	protected Node<E> findNode(E e) {
		if (this.root != null) {
			Node<E> node = this.root;
			while (node != null) {
				if (e.compareTo(node.item) == 0) {
					return node;
				} else if (e.compareTo(node.item) < 0) {
					node = node.left;
				} else {
					node = node.right;
				}
			}
		}
		return null;
	}

	public E findLCA(E e1, E e2) {
		Node<E> node1 = findNode(e1);
		Node<E> node2 = findNode(e2);
		Node<E> node = this.root;
		while (true) {
			if ((node1.item.compareTo(node.item) < 0 && node2.item
					.compareTo(node.item) > 0)
					|| (node1.item.compareTo(node.item) > 0 && node2.item
							.compareTo(node.item) < 0)) {
				return node.item;
			}
			if (node1.item.compareTo(node.item) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
	}

}
