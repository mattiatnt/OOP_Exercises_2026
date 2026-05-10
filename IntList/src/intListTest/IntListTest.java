package intListTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import intList.IntList;

class IntListTest {
	private IntList intlist;
	private IntList newArray;
	
	@Test
	void constructorTests() {
		assertThrows(IllegalArgumentException.class, () -> new IntList(null));
		int[] list = new int[] {1,2,3};
		intlist = new IntList(new int[] {1,2,3});
		assertArrayEquals(list, intlist.getElements());
	}
	
	@Test
	void addTest() {
		intlist = new IntList(new int[] {1,2,3});
		intlist.addElement(4);
		newArray = new IntList(new int[] {1,2,3,4});
		assertArrayEquals(intlist.getElements(), newArray.getElements());
	}
	
	@Test
	void removeTest() {
		intlist = new IntList(new int[] {1,2,3});
		intlist.removeLastElement();
		newArray = new IntList(new int[] {1,2});
		assertArrayEquals(intlist.getElements(), newArray.getElements());
	}
	
	

}
