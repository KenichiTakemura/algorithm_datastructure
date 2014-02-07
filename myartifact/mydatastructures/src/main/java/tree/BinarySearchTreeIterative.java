package tree;

import java.util.PriorityQueue;
import java.util.Stack;

public class BinarySearchTreeIterative<E extends Comparable<? super E>> extends
		AbstractBirnarySearchTree<E> {

	public boolean add(E e) {
		if (root == null) {
			root = newNode(e);
			return true;
		}
		Node<E> node = this.root;
		while (node != null) {
			if (e.compareTo(node.item) < 0) {
				if (node.left == null) {
					node.left = newNode(e);
					return true;
				} else {
					node = node.left;
				}
			} else if (e.compareTo(node.item) > 0) {
				if (node.right == null) {
					node.right = newNode(e);
					return true;
				} else {
					node = node.right;
				}
			} else {
				// e equals node.item
				return true;
			}
		}
		return false;
	}

	public int size() {
		int size = 0;
		if (this.root != null) {
			PriorityQueue<Node<E>> queue = new PriorityQueue<Node<E>>();
			queue.add(root);
			while (!queue.isEmpty()) {
				Node<E> node = queue.poll();
				size++;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return size;
	}

	public String toString() {
		return levelTraversal();
	}

	public boolean find(E e) {
		return findNode(e) != null;
	}

	public boolean delete(E e) {
		return deleteR(this.root, e) != null;
	}

	// private Node<E> findParantNode(Node<E> childNode) {
	// if (this.root != null) {
	// Node<E> node = this.root;
	// while (node != null) {
	// if(childNode.item.compareTo(node.item) == 0) {
	// return null;
	// }
	// if(node.left != null) {
	// if(childNode.item.compareTo(node.left.item) == 0) {
	// return node;
	// }
	// }
	// if(node.right != null) {
	// if(childNode.item.compareTo(node.right.item) == 0) {
	// return node;
	// }
	// }
	// if(childNode.item.compareTo(node.item) < 0) {
	// node = node.left;
	// } else {
	// node = node.right;
	// }
	// }
	// }
	// return null;
	// }

	public E findMin() {
		if (this.root == null)
			return null;
		Node<E> node = this.root;
		while (node.left != null) {
			node = node.left;
		}
		return node.item;
	}

	public E findMax() {
		Node<E> node = findMaxNode(this.root);
		return (node != null) ? node.item : null;
	}

	private Node<E> findMaxNode(Node<E> node) {
		if (node != null) {
			while (node.right != null) {
				node = node.right;
			}
		}
		return node;
	}

	private void addI(E e) {

	}

	public String levelTraversal() {
		StringBuffer buf = new StringBuffer();
		if (this.root != null) {
			Stack<Node<E>> stack = new Stack<Node<E>>();
			Node<E> node = this.root;
			while (true) {
				while (node != null) {
					buf.append(node);
					stack.push(node);
					node = node.left;
				}
				if (stack.isEmpty())
					break;
				node = stack.pop();
				node = node.right;
			}
		}
		return buf.toString();
	}

}
