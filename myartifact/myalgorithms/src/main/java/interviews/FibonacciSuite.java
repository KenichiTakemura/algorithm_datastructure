package interviews;

/**
 * Write a function that takes an integer N and returns the Nth number of a
 * Fibonacci suite.
 * 
 * @author ktakemur
 * 
 */
public class FibonacciSuite {

	public long fibonacciNth(int N) {
		return fibonacci(N);
	}

	private long fibonacci(int n) {
		if(n <=0) {
			throw new IllegalArgumentException("must be positive");
		}
		if(n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
