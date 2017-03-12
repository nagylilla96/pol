/**
 * MonomReal class
 * The class is for monoms with real coefficients
 *
 * @author Nagy Lilla
 * @version 12 Mar 2017
 */

package polinom;

import java.util.Objects;

public class MonomReal extends Monom implements Comparable{
	private Double coeff;
	private Integer grad;	
	
	/**
    *
    * MonomReal constructor
    *
    * @param coeff Double variable for the coefficient of the monom 
    * @param grad Integer variable for the grad of the monom
    * @see MonomReal
    */
	protected MonomReal(Double coeff, Integer grad) {
		this.coeff = coeff;
		this.grad = grad;
	}
	
	/**
    *
    * coefficient getter
    *
    * @return coefficient
    * @see MonomReal
    */
	public Object getCoeff() {
		return (Double) coeff;
	}

	/**
    *
    * coefficient setter
    *
    * @param coeff Double variable for the monom's coefficient
    * @see MonomReal
    */
	public void setCoeff(Object coeff) {
		this.coeff = (Double) coeff;
	}

	/**
    *
    * grad getter
    *
    * @return grad
    * @see MonomReal
    */
	public Object getGrad() {
		return (Integer) grad;
	}

	/**
    *
    * grad setter
    *
    * @param grad Integer variable for the monom's grad
    * @see MonomReal
    */
	public void setGrad(Object grad) {
		this.grad = (Integer) grad;
	}
	
	/**
    *
    * The method adds two monom's coefficients, and returns the resulting monom
    *
    * @param m Monom
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom add(Monom m) {
		MonomReal mr = new MonomReal(this.coeff + ((Number) (m.getCoeff())).doubleValue(), this.grad);
		return mr;
	}

	/**
    *
    * The method subtracts two monom's coefficients, and returns the resulting monom
    *
    * @param m Monom
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom subtract(Monom m) {
		MonomReal mr = new MonomReal(this.coeff - ((Number) (m.getCoeff())).doubleValue(), this.grad);
		return mr;
	}
	
	/**
    *
    * The method multiplies two monom's coefficients, and returns the resulting monom
    *
    * @param m Monom
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom multiply(Monom m) {
		MonomReal mr = new MonomReal(this.coeff * ((Number) (m.getCoeff())).doubleValue(), this.grad + ((Number) (m.getGrad())).intValue());
		return mr;
	}
	
	/**
    *
    * The method divides two monom's coefficients, and returns the resulting monom
    *
    * @param m Monom
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom divide(Monom m) {
		MonomReal mr = new MonomReal(this.coeff / ((Number) (m.getCoeff())).doubleValue(), this.grad - ((Number) (m.getGrad())).intValue());
		return mr;
	}
	
	/**
    *
    * The method differentiates the current monom and returns it
    *
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom differentiate() {
		this.coeff *= this.grad;
		if (this.grad != 0) this.grad --;
		return this;
	}
	
	/**
    *
    * The method integrates the current monom and returns it
    *
    * @return the result MonomReal
    * @see MonomReal
    */
	@Override
	protected Monom integrate() {
		++this.grad;
		MonomReal mr = new MonomReal(this.coeff / (Double) (this.grad).doubleValue(), this.grad);
		return mr;
	}
	
	/**
    *
    * The method overrides the equals method
    *
    * @param obj Object
    * @return boolean
    * @see MonomReal
    */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof MonomReal)) {
			return false;
		}
		MonomReal monomReal = (MonomReal) obj;
		return monomReal.getGrad().equals(grad);
	}
	
	/**
    *
    * The method overrides the hashCode method
    *
    * @return int
    * @see MonomReal
    */
	@Override
	public int hashCode() {
		return Objects.hash(coeff, grad);
	}

	/**
    *
    * The method compares the monoms based on their grads
    *
    * @return the result in int
    * @see MonomReal
    */
	@Override
	public int compareTo(Object o) {
		if (this.grad.compareTo((Integer) ((MonomReal) o).getGrad()) > 0) return -1;
		if (this.grad.equals(((MonomReal) o).getGrad())) return 0;
		return 1;
	}

	/**
    *
    * The method inverts the coefficient of the monom
    *
    * @see MonomReal
    */
	@Override
	protected void invertCoeff() {
		this.coeff = -this.coeff;
		
	}
}
