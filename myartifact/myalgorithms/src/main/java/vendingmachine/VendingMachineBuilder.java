package vendingmachine;

public class VendingMachineBuilder {

	public VendingMachine drinkVendingMachine() {
		VendingMachine v = new VendingMachine();
		v.add(new Coke());
		v.add(new Coke());
		v.add(new Coke());
		return v;
	}
}
