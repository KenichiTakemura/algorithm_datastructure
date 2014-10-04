package interviews;

import java.util.LinkedList;

/**
 * This class has a function to print a tree level by level When printing add a
 * new line for a new level
 * Assumption: Tree is a binary tree
 * 
 */
public class PrintTree {

	/**
	 * Print a tree level by level
	 * 
	 * @param root
	 *            The root of a tree
	 */
	public void printTree(Node root) {
		if (root == null) {
			// Nothing to print
			return;
		}
		// Use LinkedList from jdk as a queue implementation
		LinkedList<Node> currentLevel = new LinkedList<Node>();
		currentLevel.add(root);
		while (true) {
			LinkedList<Node> nextLevel = new LinkedList<Node>();
			while (!currentLevel.isEmpty()) {
				Node node = currentLevel.remove();
				// Print the current node
				// This adds an extra space at the end of current level...
				System.out.print(node.data + " ");
				if (node.left != null) {
					// Node has left child
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					// Node has left child
					nextLevel.add(node.right);
				}
			}
			// End of current Level
			System.out.println();
			currentLevel.clear();
			if (nextLevel.isEmpty()) {
				// There is no next Level. Break the loop.
				break;
			}
			// Process next Level
			currentLevel = nextLevel;
		}
	}

	/**
	 * Insert data into a tree This is required to test printTree
	 * In case of binary tree we can insert data under any node that
	 * left or right child node is null
	 * 
	 * @param root
	 *            The root of a tree
	 * @param data
	 *            Data
	 * @return The root of a tree
	 */
	public Node insertInTree(Node root, int data) {
		Node newNode = new Node(data, null, null);
		if(root == null) {
			root = newNode;
			return root;
		}
		// Use LinkedList from jdk as a queue implementation
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if(node.left != null) {
				queue.add(node.left);
			} else {
				node.left = newNode;
				queue.clear();
				return root;
			}
			if(node.right != null) {
				queue.add(node.right);
			} else {
				node.right = newNode;
				queue.clear();
				return root;
			}
		}
		queue.clear();
		return root;
	}
}
