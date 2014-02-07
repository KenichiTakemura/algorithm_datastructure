package sorting;

public class HeapSort implements Sorting {

	@Override
	public Integer[] sort(final Integer[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		System.arraycopy(a, 0, b, 0, n);
		for (int i = (n - 2) / 2; i >= 0; i--) {
			downheap(b, i, n - 1);
		}
		for (int i = n - 1; i > 0; i--) {
			int t = b[0];
			b[0] = b[i];
			b[i] = t;
			downheap(b, 0, i - 1);
		}
		return b;
	}

	private void downheap(Integer a[], int k, int r) {
		int j, v;
		v = a[k];
		while (true) {
			j = 2 * k + 1;
			if (j > r)
				break;
			if (j != r) {
				if (a[j + 1] > a[j]) {
					j = j + 1;
				}
			}
			if (v >= a[j])
				break;
			a[k] = a[j];
			k = j;
		}
		a[k] = v;
	}

}
