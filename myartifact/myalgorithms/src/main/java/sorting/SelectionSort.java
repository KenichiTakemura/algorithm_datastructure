package sorting;

public class SelectionSort implements Sorting {

	@Override
	public Integer[] sort(Integer[] a) {
		int n = a.length;
		Integer[] b = new Integer[n];
		System.arraycopy(a, 0, b, 0, n);
		for(int i=0; i<n-1; i++) {
			int iMin = i;
			for(int j=i+1;j<n;j++) {
				if(b[j] < b[iMin]) {
					iMin = j;
				}
			}
			if(iMin != i) {
				int t = b[i];
				b[i] = b[iMin];
				b[iMin] = t;
			}
		}
		return b;
	}

}
