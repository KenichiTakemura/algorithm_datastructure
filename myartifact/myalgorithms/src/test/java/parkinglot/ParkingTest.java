package parkinglot;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ParkingTest {
	@Test
	public void f() {
		Vehicle v1 = new Vehicle("513SVO");
		Vehicle v2 = new Vehicle("330EZA");
		ParkingGate gate = new ParkingGate(5, 1000);
		assertTrue(gate.isEmpty());
		v1.setTicket(gate.enter());
		v2.setTicket(gate.enter());
		System.out.println(v1);
		System.out.println(v2);
		assertFalse(gate.isFull());
		assertEquals(gate.vacancies(), 3);
		gate.exit(v1.getTicket());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		gate.exit(v2.getTicket());
		assertTrue(gate.isEmpty());
		assertEquals(gate.vacancies(), 5);
		gate.enter();
		gate.enter();
		gate.enter();
		gate.enter();
		gate.enter();
		assertTrue(gate.isFull());
		assertEquals(gate.vacancies(), 0);
		gate.enter();
	}
}
