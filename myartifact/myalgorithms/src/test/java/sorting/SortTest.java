package sorting;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

import utils.RandomGenerator;

public class SortTest {

	int N = 100;

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { RandomGenerator.generate(N), N } };
	}

	protected void verify(Integer[] b) {
		int j = 0;
		for (int i = -N; i < N; ++i) {
			assertTrue(b[j++] == i, Arrays.deepToString(b));
		}
	}
}
