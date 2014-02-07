package sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QuickSort implements Sorting {

	@Override
	public Integer[] sort(Integer[] a) {
		// List<Integer> sorted = quickSortList(Arrays.asList(a));
		// return sorted.toArray(new Integer[sorted.size()]);
		int n = a.length;
		Integer[] b = new Integer[n];
		System.arraycopy(a, 0, b, 0, n);
		quickSort(b, 0, n-1);
		return b;
	}

	private void quickSort(Integer a[], int low, int high) {
		int pivot;
		System.out.println("quickSort: " + low + " " + high);
		if (high > low) {
			pivot = partition(a, low, high);
			quickSort(a, low, pivot - 1);
			quickSort(a, pivot + 1, high);
		}
	}

	private void swap(Integer a[], int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	private int partition(Integer a[], int low, int high) {
		int left, right, pivot_item = a[low];
		left = low;
		right = high;
		System.out.println("pivot_item: " + pivot_item);
		while (left < right) {
			while (a[left] <= pivot_item && left < right)
				left++;
			while (a[right] > pivot_item && right >= 0)
				right--;
			if (left < right)
				swap(a, left, right);
		}
		a[low] = a[right];
		a[right] = pivot_item;
		return right;
	}

	public <E extends Comparable<? super E>> List<E> quickSortList(List<E> arr) {
		if (!arr.isEmpty()) {
			E pivot = arr.get(0); // This pivot can change to get faster results

			List<E> less = new LinkedList<E>();
			List<E> pivotList = new LinkedList<E>();
			List<E> more = new LinkedList<E>();

			// Partition
			for (E i : arr) {
				if (i.compareTo(pivot) < 0)
					less.add(i);
				else if (i.compareTo(pivot) > 0)
					more.add(i);
				else
					pivotList.add(i);
			}

			// Recursively sort sublists
			less = quickSortList(less);
			more = quickSortList(more);

			// Concatenate results
			less.addAll(pivotList);
			less.addAll(more);
			return less;
		}
		return arr;

	}
}
