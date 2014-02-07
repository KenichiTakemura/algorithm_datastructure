package utils;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestIntercepter {

	long time;

	@BeforeTest
	public void beforeTest() {
		time = System.nanoTime();
	}

	@AfterTest
	public void afterTest() {
		long time1 = System.nanoTime();
		System.out.println("Time: " + (time1 - time) + " nsec");
	}

}
