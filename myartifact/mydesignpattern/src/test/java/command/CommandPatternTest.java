package command;

import org.testng.annotations.Test;

/**
 * Command pattern is a data driven design pattern and falls under behavioral
 * pattern category. A request is wrapped under a object as command and passed
 * to invoker object. Invoker object looks for the appropriate object which can
 * handle this command and pass the command to the corresponding object and that
 * object executes the command.
 * 
 * @author ktakemur
 * 
 */
public class CommandPatternTest {
	@Test
	public void f() {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}
