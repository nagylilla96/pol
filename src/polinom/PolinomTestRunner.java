/**
 * PolinomTestRunneer class
 * The PolinomTest runner class
 * Runs all the tests found in the MonomTest and PolinomTest classes
 *
 * @author Nagy Lilla
 * @version 10 Mar 2017
 */

package polinom;	

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PolinomTestRunner {

	public static void main(String[] args){
		Result resultMonom = JUnitCore.runClasses(MonomTest.class);
	    for (Failure failure : resultMonom.getFailures()) {
	      System.out.println(failure.toString());
	    }
	    System.out.println(resultMonom.wasSuccessful());
	    Result resultPolinom = JUnitCore.runClasses(PolinomTest.class);
	    for (Failure failure : resultPolinom.getFailures()) {
	      System.out.println(failure.toString());
	    }
	    System.out.println(resultPolinom.wasSuccessful());
	}
}
