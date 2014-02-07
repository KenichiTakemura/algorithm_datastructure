package interviews;

public class DivideWithoutIt {

	public int divide(int dividend, int divisor) {
		int quotient = 0;
		int d = Math.abs(dividend);
		int v = Math.abs(divisor);
		if (divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero");
		}
		while (d >= v) {
			d -= v;
			quotient++;
		}
		if (dividend * divisor > 0)
			return quotient;
		else
			return -1 * quotient;
	}

	int divisor;
	int remainder;

	public int divideByBitShift(int dividend, int divisor) {
		this.divisor = divisor;
		return division(dividend, divisor);
	}

	private int division(int tempdividend, int tempdivisor) {
		int quotient = 1;

		if (tempdivisor == tempdividend) {
			remainder = 0;
			return 1;
		} else if (tempdividend < tempdivisor) {
			remainder = tempdividend;
			return 0;
		}

		while (tempdivisor <= tempdividend) {
			/*
			 * Here divisor <> divisor and quotient
			 */
			tempdivisor = tempdivisor << 1;
			quotient = quotient << 1;
		}

		/*
		 * We have reached the point where divisor > dividend, therefore divide
		 * divisor and quotient by two
		 */
		tempdivisor = tempdivisor >> 1;
		quotient = quotient >> 1;

		/*
		 * Call division recursively for the difference to get the exact
		 * quotient
		 */
		quotient = quotient + division(tempdividend - tempdivisor, this.divisor);

		return quotient;
	}
}
