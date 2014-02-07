package vendingmachine;

public abstract class Drink implements Item {

	@Override
	public abstract String getName();

	@Override
	public abstract float getPrice();
}
