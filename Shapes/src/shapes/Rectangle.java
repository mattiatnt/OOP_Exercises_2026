package shapes;

/**
 * @invar | getHeight() > 0
 * @invar | getWidth() > 0
 * @invar | getCircumference() == getWidth()*2+ getHeight()*2
 * @invar | getArea() == getWidth()*getHeight()
 */
public class Rectangle extends Shape{
	
	/**
	 * @invar | height > 0
	 */
	private double height;
	/**
	 *@invar | width > 0
	 */
	private double width;
	
	/**
	 * @throws IllegalArgumentException | width <= 0
	 * @throws IllegalArgumentException | height <= 0
	 * @post | getHeight() == height
	 * @post | getWidth() == width
	 */
	public Rectangle(double width, double height) {
		if (width <= 0) {
			throw new IllegalArgumentException("width must be non-negative");
		}
		if (height <= 0) {
			throw new IllegalArgumentException("height must be non-negative");
		}
		this.height = height;
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	
	public double getCircumference() {
		return height*2+width*2;
	}
	
	public double getArea() {
		return height*width;
	}

	@Override
	public int hashCode() {
		return this.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}
}
