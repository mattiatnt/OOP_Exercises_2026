package person;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
	
	private Person bob;
	private Person alice;
	private Person mery;
	
	@BeforeEach
	void setUp() {
		bob = new Person();
		alice = new Person();
		mery = new Person();
		
		alice.setFather(bob);
		mery.setFather(bob);
	}

	@Test
	void gettersAliceTest() {
		assertEquals(bob, alice.getFather());
	}
	
	@Test
	void gettersMeryTest() {
		assertEquals(bob, mery.getFather());
	}
	
	@Test
	void gettersBobTest() {
		assertArrayEquals(new Person[] {alice, mery}, bob.getChildren());
	}
	
	@Test
	void gettersBobRepExpTest() {
		Person[] children = bob.getChildren();
		children[1] = new Person();
		assertArrayEquals(new Person[] {alice, mery}, bob.getChildren());
	}
	
	@Test
	void gettersAliceRepExposureTest() {
		Person[] children = alice.getFather().getChildren();
		children[1] = new Person();
		assertArrayEquals(new Person[] {alice, mery}, alice.getFather().getChildren());
	}
	
	@Test
	void removeTest() {
		alice.removeFather();
		assertEquals(null, alice.getFather());
		assertArrayEquals(new Person[] {mery}, bob.getChildren());
		
	}

}
