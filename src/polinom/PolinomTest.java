/**
 *
 * PolinomTest class
 * The polinom tester class
 * 
 * @author Nagy Lilla
 * @version 12 Mar 2017
 */

package polinom;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PolinomTest {

	/**
    *
    * Tests the case of adding two polinomials
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomAdd() {
		Polinom polinom1 = new Polinom();
		polinom1.addMonom(new MonomInt(1, 2));
		polinom1.addMonom(new MonomInt(2, 1));
		polinom1.addMonom(new MonomInt(1, 0));
		Polinom polinom2 = new Polinom();
		polinom2.addMonom(new MonomInt(3, 3));
		polinom2.addMonom(new MonomInt(3, 1));
		polinom2.addMonom(new MonomInt(2, 0));
		Polinom result = polinom1.addPolinom(polinom2);
		assertEquals("0", 3, result.getMonoms().get(0).getCoeff());
		assertEquals("0", 3, result.getMonoms().get(0).getGrad());
		assertEquals("1", 1, result.getMonoms().get(1).getCoeff());
		assertEquals("1", 2, result.getMonoms().get(1).getGrad());
		assertEquals("2", 5, result.getMonoms().get(2).getCoeff());
		assertEquals("2", 1, result.getMonoms().get(2).getGrad());
		assertEquals("3", 3, result.getMonoms().get(3).getCoeff());
		assertEquals("3", 0, result.getMonoms().get(3).getGrad());		
	}
	
	/**
    *
    * Tests the case of subtracting two polinomials
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomSubtract() {
		Polinom polinom1 = new Polinom();
		polinom1.addMonom(new MonomInt(1, 2));
		polinom1.addMonom(new MonomInt(2, 1));
		polinom1.addMonom(new MonomInt(1, 0));
		Polinom polinom2 = new Polinom();
		polinom2.addMonom(new MonomInt(3, 3));
		polinom2.addMonom(new MonomInt(3, 1));
		polinom2.addMonom(new MonomInt(2, 0));
		Polinom result = polinom1.subtractPolinom(polinom2);
		assertEquals("0", -3, result.getMonoms().get(0).getCoeff());
		assertEquals("0", 3, result.getMonoms().get(0).getGrad());
		assertEquals("1", 1, result.getMonoms().get(1).getCoeff());
		assertEquals("1", 2, result.getMonoms().get(1).getGrad());
		assertEquals("2", -1, result.getMonoms().get(2).getCoeff());
		assertEquals("2", 1, result.getMonoms().get(2).getGrad());
		assertEquals("3", -1, result.getMonoms().get(3).getCoeff());
		assertEquals("3", 0, result.getMonoms().get(3).getGrad());		
	}
	
	/**
    *
    * Tests the case of multiplying two polinoms
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomMultiply() {
		Polinom polinom1 = new Polinom();
		polinom1.addMonom(new MonomInt(1, 2));
		polinom1.addMonom(new MonomInt(2, 1));
		polinom1.addMonom(new MonomInt(1, 0));
		Polinom polinom2 = new Polinom();
		polinom2.addMonom(new MonomInt(3, 3));
		polinom2.addMonom(new MonomInt(3, 1));
		polinom2.addMonom(new MonomInt(2, 0));
		Polinom result = polinom1.multiplyPolinom(polinom2);
		assertEquals("0", 3, result.getMonoms().get(0).getCoeff());
		assertEquals("0", 5, result.getMonoms().get(0).getGrad());
		assertEquals("1", 6, result.getMonoms().get(1).getCoeff());
		assertEquals("1", 4, result.getMonoms().get(1).getGrad());
		assertEquals("2", 6, result.getMonoms().get(2).getCoeff());
		assertEquals("2", 3, result.getMonoms().get(2).getGrad());
		assertEquals("3", 8, result.getMonoms().get(3).getCoeff());
		assertEquals("3", 2, result.getMonoms().get(3).getGrad());
		assertEquals("4", 7, result.getMonoms().get(4).getCoeff());
		assertEquals("4", 1, result.getMonoms().get(4).getGrad());
		assertEquals("5", 2, result.getMonoms().get(5).getCoeff());
		assertEquals("5", 0, result.getMonoms().get(5).getGrad());		
	}
	
	/**
    *
    * Tests the case of dividing two polinoms
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomDivide() {
		Polinom polinom1 = new Polinom();
		polinom1.addMonom(new MonomInt(1, 2));
		polinom1.addMonom(new MonomInt(2, 1));
		polinom1.addMonom(new MonomInt(1, 0));
		Polinom polinom2 = new Polinom();
		polinom2.addMonom(new MonomInt(3, 3));
		polinom2.addMonom(new MonomInt(3, 1));
		polinom2.addMonom(new MonomInt(2, 0));
		List<Polinom> result = polinom2.dividePolinom(polinom1);
		assertEquals("q0", 3.0, result.get(0).getMonoms().get(0).getCoeff());
		assertEquals("q0", 1, result.get(0).getMonoms().get(0).getGrad());
		assertEquals("q1", -6.0, result.get(0).getMonoms().get(1).getCoeff());
		assertEquals("q1", 0, result.get(0).getMonoms().get(1).getGrad());
		assertEquals("r0", 12.0, result.get(1).getMonoms().get(0).getCoeff());
		assertEquals("r0", 1, result.get(1).getMonoms().get(0).getGrad());
		assertEquals("r1", 8.0, result.get(1).getMonoms().get(1).getCoeff());
		assertEquals("r1", 0, result.get(1).getMonoms().get(1).getGrad());
	}
	
	/**
    *
    * Tests the case of differentiating a polynomial
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomDifferentiate() {
		Polinom polinom = new Polinom();
		polinom.addMonom(new MonomInt(3, 3));
		polinom.addMonom(new MonomInt(3, 1));
		polinom.addMonom(new MonomInt(2, 0));
		Polinom result = polinom.differentiatePolinom();
		assertEquals("0", 9, result.getMonoms().get(0).getCoeff());
		assertEquals("0", 2, result.getMonoms().get(0).getGrad());
		assertEquals("1", 3, result.getMonoms().get(1).getCoeff());
		assertEquals("1", 0, result.getMonoms().get(1).getGrad());
	}

	/**
    *
    * Tests the case of integrating a polynomial
    *
    * @see PolinomTest
    */
	@Test
	public void testPolinomIntegrate() {
		Polinom polinom = new Polinom();
		polinom.addMonom(new MonomInt(3, 3));
		polinom.addMonom(new MonomInt(2, 1));
		polinom.addMonom(new MonomInt(2, 0));
		Polinom result = polinom.integratePolinom();
		assertEquals("0", 0.75, result.getMonoms().get(0).getCoeff());
		assertEquals("0", 4, result.getMonoms().get(0).getGrad());
		assertEquals("1", 1.0, result.getMonoms().get(1).getCoeff());
		assertEquals("1", 2, result.getMonoms().get(1).getGrad());
		assertEquals("2", 2.0, result.getMonoms().get(2).getCoeff());
		assertEquals("2", 1, result.getMonoms().get(2).getGrad());
	}
}
