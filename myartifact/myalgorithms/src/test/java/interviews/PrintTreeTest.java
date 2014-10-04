package interviews;

import org.junit.Before;
import org.junit.Test;

public class PrintTreeTest {

	PrintTree pt = null;

	@Before
	public void beforeTest() {
		pt = new PrintTree();
	}
	
	@Test
	public void testNullTree() {
		Node root = null;
		pt.printTree(null);
	}
	
	@Test
	public void testLeveOneTree() {
		Node root = null;
		root = pt.insertInTree(root, 1);
		pt.printTree(root);
	}
	
	@Test
	public void testLevelTwoTree() {
		Node root = null;
		for(int i=1;i<8;i++) {
			root = pt.insertInTree(root, i);
		}
		pt.printTree(root);
	}
	
	@Test
	public void testLevelThreeTree() {
		Node root = null;
		for(int i=1;i<16;i++) {
			root = pt.insertInTree(root, i);
		}
		pt.printTree(root);
	}
}
