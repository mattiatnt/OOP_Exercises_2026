package intList;

import java.util.stream.IntStream;

public class LinkedList {
	
	private static class IntNode {
		private int value;
		private IntNode next;
	}
	
	/**
	 * @invar | head != null || getLength() == 0 
	 */
	private IntNode head;
	
	/**
	 * @throws IllegalArgumentException | values == null
	 * @post | IntStream.range(0, values.length).allMatch(i -> values[i] == getLinkedList()[i])
	 */
	public LinkedList(int[] values){
		if (values == null) {
			throw new IllegalArgumentException("list is null");
		}
		
		head = null;
		for (int v : values) {
			addNode(v);
		}
		
	}
	
	private int getLength() {
		int length = 0;
		IntNode currentNode = head;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.next;
		}
		return length;
	}
	
	/**
	 * @post | result != null
	 */
	public int[] getLinkedList() {
		int[] linkedList = new int[getLength()];
		IntNode currentNode = head;
		for (int i = 0; i < linkedList.length; i++) {
			linkedList[i] = currentNode.value;
			currentNode = currentNode.next;
		}
		return linkedList;
	}
	
	/**
	 * @mutates_properties | getLinkedList()
	 * @post | getLinkedList().length == old(getLinkedList().length) +1
	 * @post | IntStream.range(0, old(getLinkedList()).length -1).allMatch(i -> getLinkedList()[i] == old(getLinkedList())[i])
	 * @post | getLinkedList()[old(getLinkedList()).length] == val
	 */
	public void addNode(int val) {
		IntNode other = new IntNode();
		other.value = val;
		other.next = null;
		
		if (head == null) {
			head = other;
			return;
		}
		
		IntNode currentNode = head;
		 while (currentNode.next != null) {
		        currentNode = currentNode.next;
		    }
		    currentNode.next = other;
	}
	/**
	 * @mutates_properties | getLinkedList()
	 * @post | getLinkedList().length == old(getLinkedList().length) -1
	 * @post | IntStream.range(0, old(getLinkedList()).length -2).allMatch(i -> getLinkedList()[i] == old(getLinkedList())[i])
	 */
	public void removeLast() {
	    if (head == null) return; // empty
	    if (head.next == null) {
	        head = null; // one element
	        return;
	    }
		
		IntNode currentNode = head;
		while (currentNode.next.next!=null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}
}
