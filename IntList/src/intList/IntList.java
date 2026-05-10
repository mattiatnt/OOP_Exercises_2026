package intList;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @invar | getElements() != null
 */
public class IntList {
	/**
	 * @RepresentationObject
	 * @invar | intList != null
	 */
	private int[] intList;
	
	/**
	 * Constructor
	 * @throws IllegalArgumentException | intlist == null
	 * @post | Arrays.equals(intlist, getElements())
	 */
	public IntList(int[] intlist) {
		if (intlist == null) {throw new IllegalArgumentException();}
		this.intList = intlist.clone();
	}
	
	public int[] getElements() {
		return intList.clone(); 
	}
	/**
	 * Adds a new element at the end of the IntList
	 * 
	 * @post | getElements().length == old(getElements()).length + 1
	 * @post | IntStream.range(0, old(getElements()).length).allMatch(i -> getElements()[i] == old(getElements())[i]) 
	 * 			&& getElements()[old(getElements()).length +1] == e
	 */
	public void addElement(int e) {
		int[] newElements = new int[this.intList.length + 1];
		System.arraycopy(intList,  0, newElements, 0,  intList.length);
		newElements[intList.length] = e;
		intList = newElements;
	}
	/**
	 * Removes an element from the end of the IntList
	 * 
	 * @post | getElements().length == old(getElements()).length -1
	 * @post | IntStream.range(0, getElements().length).allMatch(i -> getElements()[i] == old(getElements())[i])
	 */
	public void removeLastElement() {
		if (intList.length == 0) {throw new IllegalArgumentException();}
		int[] newElements = new int[this.intList.length - 1];
		System.arraycopy(intList,  0, newElements, 0,  newElements.length);
		intList = newElements;
	}
	
	
	
}
