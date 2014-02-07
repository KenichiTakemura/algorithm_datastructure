package utils;

import java.util.Random;

public class RandomGenerator {

	public static Integer[] generate(int N) {
		// array to store N random integers (0 - N-1)
		Integer[] nums = new Integer[N*2];

		// initialize each value at index i to the value i
		int j = 0;
		for (int i = -N; i < N; ++i) {
			nums[j++] = i;
		}

		Random randomGenerator = new Random();
		int randomIndex; // the randomly selected index each time through the
							// loop
		int randomValue; // the value at nums[randomIndex] each time through the
							// loop

		// randomize order of values
		for (int i = 0; i < nums.length; ++i) {
			// select a random index
			randomIndex = randomGenerator.nextInt(nums.length);

			// swap values
			randomValue = nums[randomIndex];
			nums[randomIndex] = nums[i];
			nums[i] = randomValue;
		}
		return nums;
	}
}