package com.pawan.learning_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private int a;
	private int b;
	private Calculator cal;
	
	public CalculatorTest() {
		this.a = 10;
		this.b = 3;
		this.cal = new Calculator();
	}
	
	@Test
	public void testAddition() {
		int result = this.cal.add(a, b);
		assertEquals(13, result);
	}
	
	@Test
	public void testSubtration() {
		int result = this.cal.sub(a, b);
		assertEquals(7, result);
	}
	
	@Test
	public void testMultiplication() {
		int result = this.cal.product(a, b);
		assertEquals(30, result);
	}
	
	@Test
	public void testDivision() {
		float result = this.cal.divide(a, b);
		assertEquals(3.3333332538604736, result);
	}
}