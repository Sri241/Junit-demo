package testcode;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import businesscode.Calculator;

public class CalculatorTest {
	
//create a object of a class to be tested	
	private  static Calculator calc;

	/*  Expensive Methods annotated with @Before Class are exceted only once 
	 * before running all Test */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calc=new Calculator();
	}

	/*Methods annotated with @AfterClass are executed only once
     * after running all the Tests  */
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		calc=null;
	}

	@Test
	public void testAdd() {
		double add=calc.add(10.5, 20.32);
		//Assert is a method which determines pass or fail
		assertEquals(30.82,add,0);
	}

	@Test
	public void testSubtract() {
		double sub=calc.subtract(100.5, 100);
        assertEquals(.5, sub, 0);
	}

	@Test
	public void testMultiply() {
		double mul=calc.multiply(2.5, 100);
        assertEquals(250, mul, 0);
	}

	@Test
	public void testDivide() {
		double div=calc.divide(100, 10);
        assertEquals(10, div, 0.001);
	}
    
	@Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calc.divide(100, 0);
       
    }
}
