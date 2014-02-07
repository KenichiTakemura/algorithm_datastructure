package interviews;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.annotations.Test;

public class ArraysTest {
	@Test
	public void reserveArrayTest() {
		Integer[] a = new Integer[] {1,2,3,4,5,6,7,8,9};
		Integer[] b = new Integer[a.length] ;
		Integer[] c = new Integer[] {15,16,19,20,25,1,3,4,5,7,10,14};
		System.arraycopy(a, 0, b, 0, a.length);
		ArrayUtils.reverseArray(b, 0, b.length - 1);
		assertEquals(b, new Integer[] {9,8,7,6,5,4,3,2,1});
		System.arraycopy(a, 0, b, 0, a.length);
		ArrayUtils.leftRotateArray(b, 3, b.length - 1);
		System.out.println(Arrays.deepToString(b));
		assertEquals(b, new Integer[] {4,5,6,7,8,9,1,2,3});
		assertEquals(ArrayUtils.findPivot(b, 0, b.length), 5);
		assertEquals(ArrayUtils.findPivot(c, 0, c.length), 4);
		assertEquals(ArrayUtils.findIndexFromRotatedArray(b, 3), 8);
		assertEquals(ArrayUtils.findIndexFromRotatedArray(b, 0), -1);
		assertEquals(ArrayUtils.findIndexFromRotatedArray(c, 25), 4);
		assertEquals(ArrayUtils.findIndexFromRotatedArray(c, 1), 5);
		assertEquals(ArrayUtils.binarySearchRotated(c, 0, 8, 25), 4);
		assertEquals(ArrayUtils.binarySearchRotated(c, 0, 8, 0), -1);
	}
}
