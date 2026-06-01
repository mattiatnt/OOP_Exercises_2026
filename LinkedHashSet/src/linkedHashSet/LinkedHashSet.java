package linkedHashSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class LinkedHashSet implements Set{
	
	public class Node {
		/**
		 * @invar | (element == null) == (this == sentinel)
		 *  @invar | previous != null
		 * @invar | next != null
		 * @invar | next.previous == this
		 * @invar | previous.next == this
		 */
		private Node previous;
		private Object element;
		private Node next;
		
		private int getLength() { return this == sentinel ? 0 : 1 + next.getLength(); }
	}
	
	/**
	 * @invar | size >= 0
	 * @invar | sentinel != null
	 * @invar | map != null
	 */
	private int size;
	private Node sentinel;
	private HashMap<Object, Node> map;
	
	/**
	 * @post | size() == 0
	 */
	public LinkedHashSet() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
		map = new HashMap<Object, Node>();
	}
	/**
	 * Returns the size of this linked hash set
	 */
	public int size() {
		return sentinel.next.getLength();
	}
	
	/**
	 * @mutates | this
	 * @mutates_properties | size()
	 * @post | size() == old(size()) +1
	 * @post | IntStream.range(0, old(size())).allMatch(i -> old(toArray())[i] == toArray()[i])
	 * 		 | && toArray()[size()-1] == value 
	 * @post | !(contains(value)) || Arrays.equals(old(toArray()), toArray())
	 */
	public void add(Object value) {
		if (contains(value)) {return;}
		Node node = new Node();
		node.element = value;
		node.previous = sentinel.previous;
		node.next = sentinel;
		sentinel.previous.next = node;
		sentinel.previous = node;
		map.put(value, node);
		size++;
	}
	/**
	 * @mutates | this
	 * @mutates_properties | size()
	 * @post | size() == old(size()) -1 
	 * @post | IntStream.range(0, size()).allMatch(i -> old(toArray())[i] == toArray()[i])
	 * @post | contains(value) || Arrays.equals(old(toArray()), toArray())
	 */
	public void remove(Object value) { 
		if (!contains(value)) {return;}
		Node node = map.get(value);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		map.remove(value);
		size--;
	}
	
	/**
	 * Returns whether an element is in hashset. 
	 * 
	 */
	public boolean contains(Object value) {
		return map.containsKey(value);
	}
	
	/**
	 * Returns the order in which elements were added to the set.
	 * @creates | result
	 * @post | result != null
	 * @post | result.length == size()
	 * @post | Arrays.stream(result).allMatch(e -> contains(e))
	 * @post | java.util.Set.of(result).equals(java.util.Set.of(old(toArray())))
	 */
	public Object[] toArray() {
		Object[] result = new Object[size];
		Node current = sentinel.next;
		for (int i=0; i < size; i++) {
			result[i] = current.next.element;
			current = current.next;
		}
		return result;
	}

}
