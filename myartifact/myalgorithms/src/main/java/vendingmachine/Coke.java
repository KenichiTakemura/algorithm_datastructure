package vendingmachine;

public class Coke extends Drink {

	String name = "Coke";

	float price = 3.50f;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + name.hashCode();
		hash = hash * 31 + (new Float(price)).hashCode();
		// hash = hash * 17 + employeeId;
		// hash = hash * 31 + name.hashCode();
		// hash = hash * 13 + (dept == null ? 0 : dept.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof Coke) {
			if(name.equals(((Coke) other).name) &&
					price == ((Coke)other).price) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
