/**
 * Polinom class
 * The class is for polinoms 
 *
 * @author Nagy Lilla
 * @version 12 Mar 2017
 */

package polinom;

import java.util.*;

public class Polinom{
	List<Monom> monoms = new LinkedList<>();

	/**
	 *
	 * Polinom constructor which calls super()
	 *
	 * @see Polinom
	 */
	public Polinom() {
		super();
	}

	/**
	 *
	 * Adds a new monom to the list of monoms from the Polinom and sorts it in descending order
	 *
	 * @param m Monom
	 * @return Polinom
	 * @see Polinom
	 */
	protected Polinom addMonom(Monom m) {
		if (m.getClass().equals(MonomInt.class)) {
			if ((int)m.getCoeff() == 0) {
				return this;
			}
		}
		if (m.getClass().equals(MonomReal.class)) {
			if ((double)m.getCoeff() == 0.0) {
				return this;
			}
		}
		this.getMonoms().add(m);	
		this.monoms.sort((s1, s2) -> -Integer.compare((int) s1.getGrad(), (int) s2.getGrad()));
		return this;
	}

	/**
	 *
	 * Gets the set of monoms from the Polinom
	 *
	 * @return Set<Monom> the set of monoms
	 * @see Polinom
	 */
	public List<Monom> getMonoms() {
		return this.monoms;
	}

	/**
	 *
	 * Sets the set of monoms of the Polinom
	 *
	 * @param monoms of Set<Monom> type
	 * @see Polinom
	 */
	public void setMonoms(List<Monom> monoms) {
		this.monoms = monoms;
	}

	/**
	 *
	 * Inverts the coefficients of all monoms from this class
	 *
	 * @see Polinom
	 */
	private void invertMonoms() {
		for (Monom i: this.monoms) {
			i.invertCoeff();
		}
	}

	/**
	 *
	 * Copies the elements of one polinom into another polinom
	 *
	 * @param p of type Polinom
	 * @return Polinom
	 * @see Polinom
	 */
	private Polinom copyPolinom(Polinom p) {
		Polinom newPolinom = new Polinom();
		for (Monom i: p.getMonoms()) {
			newPolinom.addMonom(i);
		}
		return newPolinom;
	}

	/**
	 *
	 * Prints the polynomial
	 *
	 * @param p of type Polinom
	 * @see Polinom
	 */
	protected String printPolinom(Polinom p) {
		String result = new String();
		for (Monom i: p.getMonoms()) {
			if (i.getClass().equals(MonomInt.class)){
				if ((Integer) i.getCoeff() > 0) {
					result += "+";
				} else {
					if ((Integer) i.getCoeff() == 0) {
						continue;
					}
				}
			} else {
				if ((Double) i.getCoeff() > 0) {
					result += "+";
				} else {
					if ((Double) i.getCoeff() == 0) {
						continue;
					}
				}
			}
			result += i.getCoeff() + "X^" + i.getGrad() + " ";
		}
		return result;
	}

	/**
	 *
	 * Adds two polynomials
	 * First, it finds the polynomial with the highest grad (ex: p1) and it uses that for the loop
	 * Then, if the next element of p1 and p2 does not respect this order, it adds p2 to the 
	 * result's list of monoms
	 * If the monoms have equal grads, it adds them and then adds the result to res's list
	 * Else, it adds p1's monom to res's list of monoms
	 *
	 * @param p Polinom
	 * @return Polinom
	 * @see Polinom
	 */
	protected Polinom addPolinom(Polinom p) {
		Polinom res = new Polinom();
		List<Monom> monomList;
		Iterator<Monom> j;
		Monom mon;
		if (this.monoms.isEmpty()) {
			return p;
		}
		if (((Integer) this.monoms.get(0).getGrad()).compareTo((Integer) p.getMonoms().get(0).getGrad()) > 0) {
			monomList = this.monoms;
			j = p.getMonoms().iterator();
			if (j.hasNext()) {
				mon = j.next();
			} else return this;
		} else {
			monomList = p.getMonoms();
			j = this.monoms.iterator();
			if (j.hasNext()) {
				mon = j.next();
			} else return p;
		}
		boolean add = true;
		for (Monom i: monomList) {
			while (((Integer) mon.getGrad()).compareTo((Integer) i.getGrad()) > 0 && j.hasNext()) {
				res.addMonom(mon);
				mon = j.next();	
			}
			if (i.getGrad().equals(mon.getGrad())) {
				res.addMonom(i.add(mon));
				if (j.hasNext()) {
					mon = j.next();
				} else {
					add = false;
				}
			} else {
				res.addMonom(i);
			}
		}
		if (add) res.addMonom(mon);
		while (j.hasNext()) {
			res.addMonom(j.next());
		}
		return res;
	}

	/**
	 *
	 * Subtracts two polynomials by inverting the polinom to be subtracted
	 * It inverts the polynomial to be subtracted, and then adds it to this 
	 *
	 * @param p Polinom
	 * @return Polinom
	 * @see Polinom
	 */
	protected Polinom subtractPolinom(Polinom p) {
		p.invertMonoms();
		return this.addPolinom(p);
	}

	/**
	 *
	 * Multiplies two polynomials 
	 * In a double loop, we multiply each element from one polynomial with each element from the other, and add them
	 * The returned polynomial is the result of type Polinom
	 *
	 * @param p Polinom
	 * @return Polinom
	 * @see Polinom
	 */
	protected Polinom multiplyPolinom(Polinom p) {
		Polinom rez = new Polinom();
		for (Monom i: this.monoms) {
			Polinom temp = new Polinom();
			for (Monom j: p.getMonoms()) {				
				Monom m = i.multiply(j);
				temp.addMonom(m);	
			}
			rez = rez.addPolinom(temp);
		}
		return rez;
	}

	/**
	 *
	 * Divides two polynomials 
	 * We use the algorithm of polynomial division to get the quotient and the rest
	 * The return value is a linked list of polynomials with the quotient and the rest
	 *
	 * @param p Polinom
	 * @return List<Polinom> a linked list with the quotient and the rest
	 * @see Polinom
	 */
	protected List<Polinom> dividePolinom(Polinom p) {
		if (p.getMonoms().isEmpty()) {
			System.out.println("Division by zero!");
			return null;
		}
		Polinom quotient = new Polinom();
		Polinom rest = copyPolinom(this);
		while (!rest.getMonoms().isEmpty() && ((Integer) rest.getMonoms().get(0).getGrad()).compareTo((Integer) p.getMonoms().get(0).getGrad()) >= 0) {
			Monom temp = rest.getMonoms().get(0).divide(p.getMonoms().get(0));			
			quotient.addMonom(temp);
			Polinom tempPol = new Polinom();
			tempPol.addMonom(temp);						
			Polinom test = tempPol.multiplyPolinom(p);
			rest = rest.subtractPolinom(test);
		}
		List<Polinom> polinomList = new LinkedList<>();
		polinomList.add(quotient);
		polinomList.add(rest);
		return polinomList;
	}

	/**
	 *
	 * Differentiates this polynomial
	 *
	 * @return p Polinom
	 * @see Polinom
	 */
	protected Polinom differentiatePolinom() {
		for (Monom i: this.monoms) {
			i.differentiate();
		}
		return this;
	}

	/**
	 *
	 * Integrates this polynomial
	 *
	 * @return p Polinom
	 * @see Polinom
	 */
	protected Polinom integratePolinom() {
		Polinom res = new Polinom();
		for (Monom i: this.monoms) {
			res.addMonom(i.integrate());
		}
		return res;
	}

}
