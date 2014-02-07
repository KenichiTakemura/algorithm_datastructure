package vendingmachine;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class VendingMachineTest {
	@Test
	public void f() {
		VendingMachineBuilder builder = new VendingMachineBuilder();
		VendingMachine v = builder.drinkVendingMachine();
		v.showStock("Coke");
		v.pay(7.00f);
		v.showAmount();
		v.purchase("Coke");
		v.showStock("Coke");
		v.purchase("Coke");
		assertEquals(v.getChange(), 0.00f);
		v.pay(3.60f);
		v.purchase("Coke");
		assertEquals(v.getChange(), 0.10f);
	}
}
