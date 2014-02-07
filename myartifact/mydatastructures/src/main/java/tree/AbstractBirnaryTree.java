package tree;

import queue.Queue;
import queue.QueueOnLinkedList;

public abstract class AbstractBirnaryTree<E extends Comparable<? super E>>
		implements BinaryTree<E> {

	Node<E> root = null;

	public transient int size = 0;

	Node<E> newNode(E e) {
		size++;
		return new Node<E>(e, null, null);
	}

	public boolean add(E e) {
		if (this.root == null) {
			this.root = newNode(e);
			return true;
		}
		Queue<Node<E>> queue = new QueueOnLinkedList<Node<E>>();
		queue.enQueue(this.root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.deQueue();
			if (node.left == null) {
				node.left = newNode(e);
				return true;
			} else {
				queue.enQueue(node.left);
			}
			if (node.right == null) {
				node.right = newNode(e);
				return true;
			} else {
				queue.enQueue(node.right);
			}
		}
		return false;
	}
	
	public int size() {
		if(this.root == null) return 0;
		return 0;
	}

	public boolean isBST() {
		return isBST(this.root);
	}

	private boolean isBST(Node<E> node) {
		if (node == null)
			return true;
		if (node.left != null && node.left.item.compareTo(node.item) > 0) {
			return false;
		}
		if (node.right != null && node.right.item.compareTo(node.item) < 0) {
			return false;
		}
		if (!isBST(node.left) || !isBST(node.right)) {
			return false;
		}
		return true;
	}
}
