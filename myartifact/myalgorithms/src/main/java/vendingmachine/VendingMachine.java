package vendingmachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VendingMachine {

	private Map<String, LinkedList<Item>> storage = new HashMap<>();

	private BigDecimal charges = BigDecimal.ZERO.setScale(2);

	public void add(Item item) {
		LinkedList<Item> stock = storage.get(item.getName());
		if (stock == null) {
			LinkedList<Item> newStock = new LinkedList<>();
			newStock.add(item);
			storage.put(item.getName(), newStock);
		} else {
			stock.add(item);
			storage.put(item.getName(), stock);
		}
	}

	public void showStock(String name) {
		LinkedList<Item> stock = storage.get(name);
		if (stock != null) {
			System.out.println("Stock for " + name + " " + stock.size());
		} else {
			System.out.println("No Stock for " + name);
		}
	}

	public void pay(float amount) {
		if (amount > 0.00f)
			this.charges = this.charges.add(new BigDecimal(amount));
	}
	
	public void showAmount() {
		BigDecimal remainder = this.charges;
		float amount = (remainder.compareTo(BigDecimal.ZERO) > 0) ? remainder
				.floatValue() : 0.00f;
		System.out.println("Current Amount " + amount);
	}

	public Item purchase(String name) {
		if (this.charges.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("Please pay first");
		}
		LinkedList<Item> stock = storage.get(name);
		if (stock == null) {
			throw new RuntimeException("Out of stock for " + name);
		}
		Item item = stock.peek();
		BigDecimal remainder = this.charges.subtract(new BigDecimal(item
				.getPrice())).setScale(2, BigDecimal.ROUND_UP);
		if (remainder.compareTo(BigDecimal.ZERO) < 0) {
			throw new RuntimeException("Payment is short for " + name);
		}
		this.charges = remainder;
		System.out.println("Current Amount after purchase " + this.charges.floatValue());
		return stock.poll();
	}

	public float getChange() {
		BigDecimal remainder = this.charges;
		this.charges = BigDecimal.ZERO;
		return (remainder.compareTo(BigDecimal.ZERO) > 0) ? remainder
				.floatValue() : 0.00f;
	}

}
