package sequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SequenceTest {
	private EmptySequence empty;
	private NonEmptySequence nonEmpty;
	
	@BeforeEach
	void setUp() {
		empty = new EmptySequence();
		nonEmpty = new NonEmptySequence(1, new NonEmptySequence(2, new NonEmptySequence(3, new EmptySequence())));
	}

	@Test
	void constructorThrowsNull() {
		assertThrows(IllegalArgumentException.class, () -> new NonEmptySequence(1, null));
	}
	
	@Test
	void emptyLength() {
		assertEquals(0, empty.getLength());
	}
	
	@Test
	void nonEmptyLength() {
		assertEquals(3, nonEmpty.getLength());
	}
	
	@Test
	void emptyString() {
		assertEquals("", empty.toString());
	}
	
	@Test
	void nonEmptyString() {
		assertEquals("123", nonEmpty.toString());
	}
	@Test
	void emptyEquals() {
		assertTrue(empty.equals(new EmptySequence()));
	}
	
	@Test
	void nonEmptyEquals() {
		assertTrue(nonEmpty.equals(new NonEmptySequence(1, new NonEmptySequence(2, new NonEmptySequence(3, new EmptySequence())))));
		assertFalse(empty.equals(new NonEmptySequence(1, new NonEmptySequence(2, new NonEmptySequence(3, new EmptySequence())))));

	}

}
