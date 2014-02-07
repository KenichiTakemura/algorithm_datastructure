package sorting;

import org.testng.annotations.Test;

import sorting.SortingAdapter.SORTTYPE;

public class MergeSortTest extends SortTest {

	@Test(dataProvider = "dp")
	public void f(Integer[] a, int m) {
		SortingAdapter adapter = new SortingAdapter(SORTTYPE.MERGE, m);
		verify(adapter.sort(a));
	}

}
