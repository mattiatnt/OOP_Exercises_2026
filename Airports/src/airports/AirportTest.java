package airports;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirportTest {
	
	private Airport madrid;
	private Airport vienna;
	private Airport rome;

	@BeforeEach
	void setUp() {
		madrid = new Airport();
		vienna = new Airport();
		rome = new Airport();
		
		madrid.link(vienna);
		madrid.link(rome);
	}

	@Test
	void testGetter() {
		assertEquals(Set.of(vienna, rome), madrid.getConnectedAirs());
	}
	
	@Test
	void testGetterRepExp() {
		Set<Airport> airports = madrid.getConnectedAirs();
		assertThrows(UnsupportedOperationException.class, () -> airports.add(new Airport()));
	}
	
	@Test
	void removeLinkTest() {
		madrid.unlink(rome);
		assertEquals(Set.of(vienna), madrid.getConnectedAirs());
	}
	
	@Test
	void bidirectionality() {
		assertTrue(rome.getConnectedAirs().contains(madrid));
		assertTrue(vienna.getConnectedAirs().contains(madrid));
	}

}
