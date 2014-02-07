package sorting;

public class BubbleSort implements Sorting {

	@Override
	public Integer[] sort(Integer[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		System.arraycopy( a, 0, b, 0, a.length );
		while (true) {
			boolean swapped = false;
			for (int i = 1; i < n; i++) {
				if (b[i - 1] > b[i]) {
					// swap
					int t = b[i];
					b[i] = b[i - 1];
					b[i - 1] = t;
					swapped = true;
				}
			}
			n = n -1;
			if(!swapped) break;
		}
		return b;
	}
}
