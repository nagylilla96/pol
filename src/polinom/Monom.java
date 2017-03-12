/**
 * Monom class
 * This is an abstract class with abstract methods for monoms
 *
 * @author Nagy Lilla
 * @version 11 Mar 2017
 */

package polinom;

abstract class Monom {
	
	protected abstract Monom add(Monom m);
	protected abstract Monom subtract(Monom m);
	protected abstract Monom multiply(Monom m);
	protected abstract Monom divide(Monom m);
	protected abstract Monom differentiate();
	protected abstract Monom integrate();
	public abstract Object getGrad();
	public abstract void setGrad(Object grad);
	public abstract Object getCoeff();
	public abstract void setCoeff(Object coeff);
	protected abstract void invertCoeff();
	public abstract int compareTo(Object o);
	public abstract boolean equals(Object obj);
	public abstract int hashCode();
}
