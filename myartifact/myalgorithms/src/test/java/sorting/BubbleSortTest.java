package sorting;

import org.testng.annotations.Test;

import sorting.SortingAdapter.SORTTYPE;

public class BubbleSortTest extends SortTest {

	@Test(dataProvider = "dp")
	public void f(Integer[] a, int m) {
		SortingAdapter adapter = new SortingAdapter(SORTTYPE.BUBBLE, m);
		verify(adapter.sort(a));
	}
}
