package shapes;

import java.util.Objects;

/**
 * @invar | getRadius() > 0
 * @invar | getCircumference() == Math.PI * getRadius()
 * @invar | getArea() == Math.PI * Math.pow(getRadius(), 2)
 */
public class Circle extends Shape {
	/**
	 * @invar | radius > 0
	 */
	private double radius;
	
	/**
	 * @throws IllegalArgumentException | radius <= 0
	 * @post | getRadius() == radius
	 */
	public Circle(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("radius must be non negative");
		}
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public double getCircumference() {
		return Math.PI * radius;
	}

	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(radius);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
	}

	

}
