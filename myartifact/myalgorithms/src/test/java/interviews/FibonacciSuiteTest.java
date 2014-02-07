package interviews;

import junit.framework.Assert;

import org.testng.annotations.Test;

public class FibonacciSuiteTest {

	@Test
	public void f() {
		FibonacciSuite f = new FibonacciSuite();
		Assert.assertEquals(1, f.fibonacciNth(1));
		Assert.assertEquals(1, f.fibonacciNth(2));
		Assert.assertEquals(2, f.fibonacciNth(3));
		Assert.assertEquals(3, f.fibonacciNth(4));
		Assert.assertEquals(5, f.fibonacciNth(5));
		Assert.assertEquals(8, f.fibonacciNth(6));
		Assert.assertEquals(13, f.fibonacciNth(7));
		Assert.assertEquals(21, f.fibonacciNth(8));
		Assert.assertEquals(34, f.fibonacciNth(9));
		Assert.assertEquals(55, f.fibonacciNth(10));
	}
}
