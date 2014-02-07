package factory;

import org.testng.annotations.Test;

/**
 * Factory pattern is one of most used design pattern in Java. This type of
 * design pattern comes under creational pattern as this pattern provides one of
 * the best ways to create an object. In Factory pattern, we create object
 * without exposing the creation logic to the client and refer to newly created
 * object using a common interface.
 * 
 * @author ktakemur
 * 
 */
public class FactoryPatternTest {

	@Test
	public void f() {
		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape shape1 = shapeFactory.getShape("CIRCLE");

		// call draw method of Circle
		shape1.draw();

		// get an object of Rectangle and call its draw method.
		Shape shape2 = shapeFactory.getShape("RECTANGLE");

		// call draw method of Rectangle
		shape2.draw();

		// get an object of Square and call its draw method.
		Shape shape3 = shapeFactory.getShape("SQUARE");

		// call draw method of circle
		shape3.draw();
	}

}
