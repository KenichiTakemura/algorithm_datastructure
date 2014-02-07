package interviews;

public class ArrayUtils {

	/**
	 * 入力配列を、 AB ただし、部分配列が A = Array[0 .. d − 1] 、 B = Array[d .. n − 1]
	 * とする。アルゴリズムのアイデアは次のとおり。 A を反転して ArB /* Ar は A の反転 B を反転して ArBr /* Br は B
	 * の反転 全体を反転して (ArBr)r = BA
	 */
	public static void leftRotateArray(Integer[] a, int k, int n) {
		reverseArray(a, 0, k - 1);
		reverseArray(a, k, n);
		reverseArray(a, 0, n);
	}

	/**
	 * Reverse an array
	 * 
	 * @param Array
	 * @param start
	 * @param end
	 */
	public static void reverseArray(Integer[] a, int start, int end) {
		if (a == null || a.length <= 0)
			return;
		if (start < 0 || end >= a.length) {
			throw new IllegalArgumentException("start | end our of range");
		}
		int temp;
		while (start < end) {
			temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

	public static int findPivot(Integer[] a, int start, int finish) {
		if (finish - start == 0)
			return start;
		else if (start == (finish - 1)) {
			if (a[start] >= a[finish])
				return start;
			else
				return finish;
		} else {
			int mid = start + (finish - start) / 2;
			if (a[start] >= a[mid])
				return findPivot(a, start, mid);
			else
				return findPivot(a, mid, finish);
		}
	}

	public static int findIndexFromRotatedArray(Integer[] a, int x) {
		int n = a.length;
		int pivot = findPivot(a, 0, n);
		if (a[pivot] == x) {
			return pivot;
		}
		if (a[pivot] <= x)
			return binarySearch(a, 0, pivot - 1, x);
		else
			return binarySearch(a, pivot + 1, n - 1, x);
	}

	private static int binarySearch(Integer[] a, int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (x == a[mid])
				return mid;
			if (x > a[mid])
				return binarySearch(a, (mid + 1), high, x);
			else
				return binarySearch(a, low, (mid - 1), x);
		}
		return -1;
	}

	public static int binarySearchRotated(Integer a[], int start, int finish,
			int data) {
		int mid;
		if (start > finish)
			return -1;
		mid = start + (finish - start) / 2;
		if (data == a[mid])
			return mid;
		else if (a[start] <= a[mid]) { // 前半は整列順
			if (data >= a[start] && data < a[mid])
				return binarySearchRotated(a, start, mid - 1, data);
			else
				return binarySearchRotated(a, mid + 1, finish, data);
		} else { // A[mid] <= A[finish] 、後半は整列順
			if (data > a[mid] && data <= a[finish])
				return binarySearchRotated(a, mid + 1, finish, data);
			else
				return binarySearchRotated(a, start, mid - 1, data);
		}
	}
}
