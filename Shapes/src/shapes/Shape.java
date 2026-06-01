package shapes;

import java.util.Arrays;
import java.util.stream.IntStream;

public abstract class Shape {
	
	public abstract double getCircumference();
	public abstract double getArea();
	
	/**
	 * @pre | shapes != null
	 * @pre | IntStream.range(0, shapes.length).allMatch(i -> shapes[i] != null)
	 * @post | result == Arrays.stream(shapes).mapToDouble(s -> s.getCircumference()).sum()
	 */
	public double getCircumferences(Shape[] shapes) {
		double sum = 0;
		for (Shape shape :shapes) {
			sum += shape.getCircumference();
		}
		return sum;
	}
	/**
	 * @pre | shapes != null
	 * @pre | IntStream.range(0, shapes.length).allMatch(i -> shapes[i] != null)
	 * @post | result == Arrays.stream(shapes).mapToDouble(s -> s.getArea()).sum()
	 */
	public double getAreas(Shape[] shapes) {
		double sum = 0;
		for (Shape shape :shapes) {
			sum += shape.getArea();
		}
		return sum;
	}
}
