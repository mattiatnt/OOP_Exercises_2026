package shapes;

import java.util.Objects;

public class Triangle extends Shape{
	/**
	 * @invar | alpha > 0 && alpha < Math.PI
	 */
	private double alpha;
	/**
	 * @invar | l1 > 0
	 */
	private double l1;
	/**
	 * @invar | l2 > 0
	 */
	private double l2;
	
	/**
	 * @throws IllegalArgumentException | l1 <= 0
	 * @throws IllegalArgumentException | l2 <= 0
	 * @throws IllegalArgumentException | alpha <= 0 || alpha >= Math.PI
	 * @post | getL1() == l1
	 * @post | getL2() == l2
	 * @post | getAlpha() == alpha
	 */
	public Triangle(double alpha, double l1, double l2) {
		if (l1 <= 0) {
			throw new IllegalArgumentException("side cannot be zero or negative");
		}
		if (l2 <= 0) {
			throw new IllegalArgumentException("side cannot be zero or negative");
		}
		if (alpha <= 0 || alpha >= Math.PI) {
			throw new IllegalArgumentException("angle cannot be negative or larger than PI");
		}
		this.alpha = alpha;
		this.l1 = l1;
		this.l2 = l2;
	}

	public double getAlpha() {
		return alpha;
	}

	public double getL1() {
		return l1;
	}

	public double getL2() {
		return l2;
	}

	/**
	 * @post | result == getL1() + getL2() + Math.sqrt(Math.pow(getL1(), 2) + Math.pow(getL2(), 2) - (2*l1*l2*Math.cos(getAlpha())))
	 */
	public double getCircumference() {
		double l3 = Math.sqrt(Math.pow(l1, 2) + Math.pow(l2, 2) - (2*l1*l2*Math.cos(alpha)));
		return l1+l2+l3;
	}

	/**
	 * @post | result == 0.5*getL1()*getL2()*Math.sin(getAlpha())
	 */
	public double getArea() {
		
		return 0.5*l1*l2*Math.sin(alpha);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alpha, l1, l2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Double.doubleToLongBits(alpha) == Double.doubleToLongBits(other.alpha)
				&& Double.doubleToLongBits(l1) == Double.doubleToLongBits(other.l1)
				&& Double.doubleToLongBits(l2) == Double.doubleToLongBits(other.l2);
	}

	@Override
	public String toString() {
		return "Triangle [alpha=" + alpha + ", l1=" + l1 + ", l2=" + l2 + "]";
	}

}
