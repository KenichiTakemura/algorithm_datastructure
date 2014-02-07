package interviews;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NumbersTest {

	@Test(dataProvider = "dp")
	public void f1(Integer[] a) {
		Numbers f = new Numbers();
		List<String> ret = f.BruteForceFindThePairs(a, 0);
		System.out.println(ret);
		// Assert.assertEquals(ret.size(), m/2 - 1);
	}

	@Test(dataProvider = "dp")
	public void f2(Integer[] a) {
		Numbers f = new Numbers();
		List<String> ret = f.HashFindThePairs(a, 0);
		System.out.println(ret);
		// Assert.assertEquals(ret.size(), m/2 - 1);
	}

	@Test
	public void exp_by_squaring() {
		Numbers f = new Numbers();
		assertEquals(f.exp_by_squaring(1.0, 0), 1.0);
		assertEquals(f.exp_by_squaring(1.0, 1), 1.0);
		assertEquals(f.exp_by_squaring(1.0, 100), 1.0);
		assertEquals(f.exp_by_squaring(2.0, 1), 2.0);
		assertEquals(f.exp_by_squaring(4.0, 3), 64.0);
		assertEquals(f.exp_by_squaring(1.0, -1), 1.0);
		assertEquals(f.exp_by_squaring(4.0, -1), 0.25);
		assertEquals(f.exp_by_squaring(2.0, -4), (double) 1 / 16);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { new Integer[] { -5, -4, -3, -2,
				-1, 0, 1, 1, 2, 2, 3, 4, 5 } } };
	}

	@Test
	public void rand7Test() {
		Numbers f = new Numbers();
		for (int i = 0; i < 100; i++) {
			System.out.print(f.rand7() + " ");
		}
		System.out.println();
	}

}
