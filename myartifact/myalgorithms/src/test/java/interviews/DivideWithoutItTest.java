package interviews;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.TestIntercepter;

public class DivideWithoutItTest extends TestIntercepter {
	@Test
	public void f() {
		DivideWithoutIt divider = new DivideWithoutIt();
		Assert.assertEquals(0, divider.divide(0, 1));
		Assert.assertEquals(1, divider.divide(1, 1));
		Assert.assertEquals(5, divider.divide(10, 2));
		Assert.assertEquals(10, divider.divide(10, 1));
		Assert.assertEquals(1, divider.divide(10, 10));
		Assert.assertEquals(3, divider.divide(10, 3));
//		Assert.assertEquals(5, divider.divide(-10, -2));
//		Assert.assertEquals(10, divider.divide(-10, -1));
//		Assert.assertEquals(1, divider.divide(-10, -10));
//		Assert.assertEquals(3, divider.divide(-10, -3));
//		Assert.assertEquals(-5, divider.divide(-10, 2));
//		Assert.assertEquals(-10, divider.divide(-10, 1));
//		Assert.assertEquals(-1, divider.divide(-10, 10));
//		Assert.assertEquals(-3, divider.divide(-10, 3));
//		Assert.assertEquals(-5, divider.divide(10, -2));
//		Assert.assertEquals(-10, divider.divide(10, -1));
//		Assert.assertEquals(-1, divider.divide(10, -10));
//		Assert.assertEquals(-3, divider.divide(10, -3));
	}

	@Test
	public void f1() {
		DivideWithoutIt divider = new DivideWithoutIt();
		Assert.assertEquals(0, divider.divideByBitShift(0, 1));
		Assert.assertEquals(1, divider.divideByBitShift(1, 1));
		Assert.assertEquals(5, divider.divideByBitShift(10, 2));
		Assert.assertEquals(10, divider.divideByBitShift(10, 1));
		Assert.assertEquals(1, divider.divideByBitShift(10, 10));
		Assert.assertEquals(3, divider.divideByBitShift(10, 3));
//		Assert.assertEquals(5, divider.divideByBitShift(-10, -2));
//		Assert.assertEquals(10, divider.divideByBitShift(-10, -1));
//		Assert.assertEquals(1, divider.divideByBitShift(-10, -10));
//		Assert.assertEquals(3, divider.divideByBitShift(-10, -3));
//		Assert.assertEquals(-5, divider.divideByBitShift(-10, 2));
//		Assert.assertEquals(-10, divider.divideByBitShift(-10, 1));
//		Assert.assertEquals(-1, divider.divideByBitShift(-10, 10));
//		Assert.assertEquals(-3, divider.divideByBitShift(-10, 3));
//		Assert.assertEquals(-5, divider.divideByBitShift(10, -2));
//		Assert.assertEquals(-10, divider.divideByBitShift(10, -1));
//		Assert.assertEquals(-1, divider.divideByBitShift(10, -10));
//		Assert.assertEquals(-3, divider.divideByBitShift(10, -3));
	}
}
