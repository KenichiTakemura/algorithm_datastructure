package facade;

import org.testng.annotations.Test;

/**
 * Facade pattern hides the complexities of the system and provides an interface
 * to the client using which the client can access the system. This type of
 * design pattern comes under structural pattern as this pattern adds an
 * interface to exiting system to hide its complexities. This pattern involves a
 * single class which provides simplified methods which are required by client
 * and delegates calls to existing system classes methods.
 * 
 * @author ktakemur
 * 
 */
public class FacadePatternTest {
	@Test
	public void f() {
		ShapeMaker shapeMaker = new ShapeMaker();
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}
