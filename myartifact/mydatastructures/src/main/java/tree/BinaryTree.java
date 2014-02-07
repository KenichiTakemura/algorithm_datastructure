package tree;

public interface BinaryTree<E extends Comparable<? super E>> {

	boolean add(E e);

	int size();

	String toString();

	boolean find(E e);
	
	boolean delete(E e);

	E findMin();

	E findMax();
	
	/**
	 * Find LCA(Least Common Ancestor) in BST tree.
	 * @return
	 */
	E findLCA(E e1, E e2);
	
	/**
	 * Find a number greater than a given number
	 */
	boolean isBST();

	/**
	 * Find next largest element in binary search tree
	 */
	
	/**
	 * Level traversal
	 */
	String levelTraversal();
	
	/**
	 * Merge two BST’s in to one balanced binary tree.
	 */
}
