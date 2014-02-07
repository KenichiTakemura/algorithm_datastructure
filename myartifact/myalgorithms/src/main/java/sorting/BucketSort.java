package sorting;

public class BucketSort implements Sorting {

	int m;

	public BucketSort(int m) {
		this.m = m;
	}

	@Override
	public Integer[] sort(Integer[] a) {
		int n = a.length;
		Integer[] o = new Integer[m];
		Integer[] b = new Integer[n];
		for(int i=0;i<m;i++) {
			o[i] = -1;
		}
		for(int i=0;i<n;i++) {
			o[a[i]] = a[i];
		}
		for(int i=0,j=0;i<m;i++) {
			if(o[i] >= 0) b[j++] = o[i];
		}
		return b;
	}
}
