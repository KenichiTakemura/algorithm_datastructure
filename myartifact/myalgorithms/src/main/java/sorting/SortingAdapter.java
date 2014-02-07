package sorting;

public class SortingAdapter implements Sorting {

	private Sorting algorithm;

	public enum SORTTYPE {
		BUBBLE, BUCKET, MERGE, SELECTION, INSERTION, QUICK, SHELL, HEAP
	}

	public SortingAdapter(SORTTYPE type, int m) {
		if (type == SORTTYPE.BUBBLE) {
			algorithm = new BubbleSort();
		} else if (type == SORTTYPE.BUCKET) {
			algorithm = new BucketSort(m);
		} else if (type == SORTTYPE.MERGE) {
			algorithm = new MergeSort();
		} else if (type == SORTTYPE.SELECTION) {
			algorithm = new SelectionSort();
		} else if (type == SORTTYPE.INSERTION) {
			algorithm = new InsertionSort();
		} else if (type == SORTTYPE.HEAP) {
			algorithm = new HeapSort();
		} else if (type == SORTTYPE.QUICK) {
			algorithm = new QuickSort();
		} else {
			throw new IllegalArgumentException("Unknown Sort type");
		}
	}

	@Override
	public Integer[] sort(Integer[] a) {
		Integer[] b = algorithm.sort(a);
		return b;
	}

}
