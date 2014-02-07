package interviews;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Write a function that, given an array and a number as input, finds all pairs
 * in the array that add up to that number. Number can be +ve/-ve. Write most
 * space (or) time efficient algorithm. How will it handle duplicate pairs.
 * 
 * @author ktakemur
 * 
 */
public class Numbers {

	public List<String> BruteForceFindThePairs(Integer[] input, int target) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < (input.length - 1); i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == target) {
					String pair = input[i] + "+" + input[j];
					ret.add(pair);
				}
			}
		}
		return ret;
	}

	public List<String> HashFindThePairs(Integer[] input, int target) {
		List<String> ret = new ArrayList<String>();
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			Integer value = table.get(input[i]);
			int key = target - input[i];
			if (value != null) {
				if (value == 0) {
					System.err.println("Duplicate: " + input[i]);
				} else {
					String pair = value + "+" + input[i];
					ret.add(pair);
					table.put(input[i], 0);
				}
			} else {
				table.put(key, input[i]);
			}
		}
		return ret;
	}

	/**
	 * Exponentiation by squaring
	 * http://en.wikipedia.org/wiki/Exponentiation_by_squaring In mathematics
	 * and computer programming, exponentiating by squaring is a general method
	 * for fast computation of large positive integer powers of a number, or,
	 * more generally of an element of a ring, like a polynomial or a square
	 * matrix. Some variants are commonly referred to as square-and-multiply
	 * algorithms or binary exponentiation. These can be of quite general use,
	 * for example in modular arithmetic or powering of matrices. This method is
	 * also used for exponentiation in groups. For groups for which additive
	 * notation is commonly used, like elliptic curves used in cryptography,
	 * this method is also referred to as double-and-add.
	 * 
	 * Function exp-by-squaring(x,n) if n<0 then return exp-by-squaring(1/x,
	 * -n); else if n=0 then return 1; else if n=1 then return x; else if n is
	 * even then return exp-by-squaring(x2, n/2); else if n is odd then return x
	 * * exp-by-squaring(x2, (n-1)/2).
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public double exp_by_squaring(double x, int n) {
		if (n < 0) {
			return exp_by_squaring(1 / x, -n);
		} else if (n == 0) {
			return 1.0;
		} else if (n == 1) {
			return x;
		} else if (n % 2 == 0) {
			return exp_by_squaring(x * x, n / 2);
		} else {
			return x * exp_by_squaring(x * x, (n - 1) / 2);
		}
	}

	/**
	 * Generate random integer 1 - 5
	 * 
	 * @return
	 */
	public int rand5() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(5) + 1;
	}

	public int rand7() {
		int v;
		do {
			v = rand5() * 5 + rand5() - 6;
		} while (v > 21);
		return v % 7 + 1;
	}

}
