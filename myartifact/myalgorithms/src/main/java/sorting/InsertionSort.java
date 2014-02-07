package sorting;

public class InsertionSort implements Sorting {

	@Override
	public Integer[] sort(Integer[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		System.arraycopy(a, 0, b, 0, n);
		for(int i=1; i<n; i++) {
			int x = b[i];
			int j = i;
			while(j > 0 && b[j-1] > x) {
				b[j] = b[j-1];
				j--;
			}
			b[j] = x;
		}
		return b;
	}

}
