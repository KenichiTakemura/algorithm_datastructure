package sorting;

import java.util.Arrays;

public class MergeSort implements Sorting {

	@Override
	public Integer[] sort(Integer[] a) {
		return mergeSort(a);
	}

	private Integer[] mergeSort(Integer[] a) {
		if (a.length <= 1) {
			return a;
		}
		int mid = 0 + (a.length - 0)/2;
		Integer[] s1 = mergeSort(Arrays.copyOfRange(a, 0, mid));
		Integer[] s2 = mergeSort(Arrays.copyOfRange(a, mid, a.length));
		return merge(s1, s2);
	}

	private Integer[] merge(Integer[] a, Integer[] b) {
		Integer[] s = new Integer[a.length + b.length];
		int i = 0, j = 0, k = 0;
		for (;i < s.length; i++) {
			if (k >= b.length || j < a.length && a[j] <= b[k]) {
				s[i] = a[j++];
			} else {
				s[i] = b[k++];
			}
		}
		return s;
	}
}
