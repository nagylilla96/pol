/**
 * PolinomTest class
 * The Monom tester class
 *
 * @author Nagy Lilla
 * @version 12 Mar 2017
 */

package polinom;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonomTest {	
	
	/**
    *
    * Tests the case of adding two monoms with integer coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testAddMonomIntInt() {
		Monom m1 = new MonomInt(2, 3);
		Monom m2 = new MonomInt(2, 3);
		Monom result1 = m1.add(m2);
		assertEquals("Result should be coeff = 4", 4, result1.getCoeff());
		assertEquals("Result should be grad = 3", 3, result1.getGrad());
	}

	/**
    *
    * Tests the case of adding two monoms, one with real and the other one with integer coefficients
    *
    * @see MonomTest
    */
	@Test
	public void testAddMonomRealInt() {
		Monom m3 = new MonomReal(2.4, 1);
		Monom m4 = new MonomInt(3, 1);
		Monom result2 = m3.add(m4);
		assertEquals("Result should be coeff = 5.4", 5.4, result2.getCoeff());
		assertEquals("Result should be grad = 1", 1, result2.getGrad());
	}
	
	
	/**
    *
    * Tests the case of adding two monoms with integer coefficient and zero grad
    *
    * @see MonomTest
    */
	@Test
	public void testAddMonomZeroInt() {
		Monom m3 = new MonomInt(2, 0);
		Monom m4 = new MonomInt(3, 0);
		Monom result2 = m3.add(m4);
		assertEquals("Result should be coeff = 5", 5, result2.getCoeff());
		assertEquals("Result should be grad = 0", 0, result2.getGrad());
	}
	
	
	/**
    *
    * Tests the case of adding two monoms with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testAddMonomRealReal() {
		Monom m3 = new MonomReal(2.5, 0);
		Monom m4 = new MonomReal(3.5, 0);
		Monom result2 = m3.add(m4);
		assertEquals("Result should be coeff = 6.0", 6.0, result2.getCoeff());
		assertEquals("Result should be grad = 0", 0, result2.getGrad());
	}

	/**
    *
    * Tests the case of subtracting two monoms with integer coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testSubMonomIntInt() {
		Monom m1 = new MonomInt(5, 2);
		Monom m2 = new MonomInt(3, 2);
		Monom result1 = m1.subtract(m2);
		assertEquals("Result should be coeff = 2", 2, result1.getCoeff());
		assertEquals("Result should be grad = 2", 2, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of subtracting two monoms, one with real and one with integer coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testSubMonomRealInt() {
		Monom m1 = new MonomReal(7.2, 2);
		Monom m2 = new MonomInt(3, 2);
		Monom result1 = m1.subtract(m2);
		assertEquals("Result should be coeff = 4.2", 4.2, result1.getCoeff());
		assertEquals("Result should be grad = 2", 2, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of subtracting two monoms, one with integer and one with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testSubMonomIntReal() {
		Monom m1 = new MonomInt(7, 2);
		Monom m2 = new MonomReal(3.2, 2);
		Monom result1 = m1.subtract(m2);
		assertEquals("Result should be coeff = 3.8", 3.8, result1.getCoeff());
		assertEquals("Result should be grad = 2", 2, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of subtracting two monoms with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testSubMonomRealReal() {
		Monom m1 = new MonomReal(7.2, 2);
		Monom m2 = new MonomReal(4.2, 2);
		Monom result1 = m1.subtract(m2);
		assertEquals("Result should be coeff = 3.0", 3.0, result1.getCoeff());
		assertEquals("Result should be grad = 2", 2, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of multiplying two monoms with integer coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testMulMonomIntInt() {
		Monom m1 = new MonomInt(5, 2);
		Monom m2 = new MonomInt(3, 2);
		Monom result1 = m1.multiply(m2);
		assertEquals("Result should be coeff = 15", 15, result1.getCoeff());
		assertEquals("Result should be grad = 4", 4, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of multiplying two monoms, one with real and one with integer coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testMulMonomRealInt() {
		Monom m1 = new MonomReal(7.2, 2);
		Monom m2 = new MonomInt(1, 2);
		Monom result1 = m1.multiply(m2);
		assertEquals("Result should be coeff = 7.2", 7.2, result1.getCoeff());
		assertEquals("Result should be grad = 4", 4, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of multiplying two monoms with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testMulMonomRealReal() {
		Monom m1 = new MonomReal(1.5, 2);
		Monom m2 = new MonomReal(1.5, 2);
		Monom result1 = m1.multiply(m2);
		assertEquals("Result should be coeff = 2.25", 2.25, result1.getCoeff());
		assertEquals("Result should be grad = 4", 4, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of dividing two monoms with integer coefficient, integer result
    *
    * @see MonomTest
    */
	@Test
	public void testDivMonomIntIntInt() {
		Monom m1 = new MonomInt(6, 2);
		Monom m2 = new MonomInt(2, 2);
		Monom result1 = m1.divide(m2);
		assertEquals("Result should be coeff = 3.0", 3.0, result1.getCoeff());
		assertEquals("Result should be grad = 0", 0, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of dividing two monoms with integer coefficient, real result
    *
    * @see MonomTest
    */
	@Test
	public void testDivMonomIntIntReal() {
		Monom m1 = new MonomInt(5, 2);
		Monom m2 = new MonomInt(2, 2);
		Monom result1 = m1.divide(m2);
		assertEquals("Result should be coeff = 2.5", 2.5, result1.getCoeff());
		assertEquals("Result should be grad = 0", 0, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of differentiating a monom with integer coefficient and nonzero grad
    *
    * @see MonomTest
    */
	@Test
	public void testDiffMonomIntNnull() {
		Monom m1 = new MonomInt(5, 1);
		Monom result1 = m1.differentiate();
		assertEquals("Result should be coeff = 5", 5, result1.getCoeff());
		assertEquals("Result should be grad = 0", 0, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of differentiating a monom with integer coefficient and zero grad
    *
    * @see MonomTest
    */
	@Test
	public void testDiffMonomIntNull() {
		Monom m1 = new MonomInt(3, 0);
		Monom result1 = m1.differentiate();
		assertEquals("Result should be coeff = 0", 0, result1.getCoeff());
		assertEquals("Result should be grad = 0", 0, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of differentiating a monom with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testDiffMonomReal() {
		Monom m1 = new MonomReal(2.25, 2);
		Monom result1 = m1.differentiate();
		assertEquals("Result should be coeff = 4.5", 4.5, result1.getCoeff());
		assertEquals("Result should be grad = 1", 1, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of integrating a monom with integer coefficient and nonzero grad
    *
    * @see MonomTest
    */
	@Test
	public void testIntMonomIntNnull() {
		Monom m1 = new MonomInt(5, 1);
		Monom result1 = m1.integrate();
		assertEquals("Result should be coeff = 2.5", 2.5, result1.getCoeff());
		assertEquals("Result should be grad = 2", 2, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of integrating a monom with integer coefficient and zero grad
    *
    * @see MonomTest
    */
	@Test
	public void testIntMonomIntNull() {
		Monom m1 = new MonomInt(3, 0);
		Monom result1 = m1.integrate();
		assertEquals("Result should be coeff = 3.0", 3.0, result1.getCoeff());
		assertEquals("Result should be grad = 1", 1, result1.getGrad());
	}
	
	/**
    *
    * Tests the case of differentiating a monom with real coefficient
    *
    * @see MonomTest
    */
	@Test
	public void testIntMonomReal() {
		Monom m1 = new MonomReal(3.6, 2);
		Monom result1 = m1.integrate();
		assertEquals("Result should be coeff = 1.2", 1.2, result1.getCoeff());
		assertEquals("Result should be grad = 3", 3, result1.getGrad());
	}
}
