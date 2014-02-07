package interviews;

/**
 * Giving a string with number from 1-250 in random order, but miss 1 number.
 * How to find the missed number.
 * 
 * @author ktakemur
 * 
 */
public class MissingNumber {

	public int FindMissingNumber(String input, int maxNumber) {
		int missingNumber = 0;
		System.out.println("input=" + input);
		// This may overflow
		missingNumber = maxNumber * (maxNumber + 1) / 2;
		String[] numbers = input.split(",");
		for (String s : numbers) {
			if (s.matches("\\d+")) {
				missingNumber -= Integer.parseInt(s);
			}
		}
		return missingNumber;
	}

	/**
	 * 1. すべての配列要素の排他的論理和( XOR )を取り、この XOR の結果を X とする。 
	 * 2. 1 から n のすべての数値の XORを取り、この XOR を Y とする。
	 * 3. X と Y の XOR を取ると欠けている数値が得られる。
	 * 
	 * @param input
	 * @param maxNumber
	 * @return
	 */
	public int FindMissingNumberXOR(String input, int maxNumber) {
		String[] numbers = input.split(",");
		if (numbers == null) {
			throw new RuntimeException("input format error");
		}
		Integer[] a = new Integer[maxNumber];
		int i = 0;
		int k = 0;
		for (String s : numbers) {
			if (s.matches("\\d+")) {
				a[i++] = Integer.parseInt(s);
				k++;
			}
		}
		// Needs to initialize with a[0] not 0;
		int x = a[0];
		for (i = 1; i < k; i++) {
			x ^= a[i];
		}
		// Needs to set 1 and start the loop from 2 to maxNumber
		int y = 1;
		for (i = 2; i <= maxNumber; i++) {
			y ^= i;
		}
		return x ^ y;
	}
}
