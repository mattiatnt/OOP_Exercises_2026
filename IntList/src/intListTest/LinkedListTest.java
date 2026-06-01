package intListTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import intList.LinkedList;

class LinkedListTest {
	
	private LinkedList list;
	private int[] values;
	
	@BeforeEach
	void test() {
		values = new int[] {1,2,3};
		list = new LinkedList(values);
	}
	
	@Test
	void constructorThrowsNull() {
		assertThrows(IllegalArgumentException.class, () ->
		new LinkedList(null));
	}
	
	@Test
	void constructorRepexposure() {
		values[2] = 4;
		assertArrayEquals(new int[] {1,2,3}, list.getLinkedList());
	}
	
	@Test
	void getterRepexposure() {
		int[] oldGetter = list.getLinkedList();
		oldGetter[2] = 4;
		assertArrayEquals(new int[] {1,2,3}, list.getLinkedList());
	}
	
	@Test
	void addValueTest() {
		list.addNode(4);		
		assertArrayEquals(new int[] {1,2,3,4}, list.getLinkedList());
	}
	
	@Test
	void removeValueTest() {
		list.removeLast();		
		assertArrayEquals(new int[] {1,2}, list.getLinkedList());
	}
	
	@Test
	void removeValueNoListTest() {
		LinkedList list = new LinkedList(new int[] {});		
		assertArrayEquals(new int[] {}, list.getLinkedList());
	}
	
	@Test
	void removeOnlyValueTest() {
		LinkedList list = new LinkedList(new int[] {1});
		list.removeLast();
		assertArrayEquals(new int[] {}, list.getLinkedList());
	}

}
