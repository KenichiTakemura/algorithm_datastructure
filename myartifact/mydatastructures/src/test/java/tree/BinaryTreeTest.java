package tree;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BinaryTreeTest {

//	final int N = 10;

	List<Integer> data = null;

	@BeforeClass
	public void beforeClass() {
		data = Arrays.asList(new Integer[] {4,2,8,5,7,6,10,9});
	}

	@Test()
	public void f1() {
		BinaryTree<Integer> tree = new BinarySearchTreeRecursive<Integer>();
		main(tree);
	}

	@Test()
	public void f2() {
		BinaryTree<Integer> tree = new BinarySearchTreeIterative<Integer>();
		main(tree);
	}

	public void main(BinaryTree<Integer> tree) {
		int N = data.size();
		for (int i = 0; i < N; i++) {
			tree.add(data.get(i));
		}
		System.out.println(tree);
		assertEquals(tree.size(), N);
		assertTrue(tree.find(8));
		tree.add(5);
		assertFalse(tree.find(3));
		assertEquals((int)tree.findMin(), 2);
		assertEquals((int)tree.findMax(), 10);
		assertEquals((int)tree.findLCA(6, 10), 8);
		assertTrue(tree.isBST());
		// Delete
		assertTrue(tree.delete(2));
		assertEquals((int)tree.findMin(), 4);
		assertTrue(tree.delete(10));
		assertTrue(tree.delete(8));
		assertEquals((int)tree.findMax(), 9);
		assertTrue(tree.isBST());
		BT<Integer> btree = new BT<Integer>();
		for (int i = 0; i < N; i++) {
			btree.add(data.get(i));
		}
		assertTrue(btree.isBST());
	}

}
