package timeOfDayTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import timeOfDay.TimeOfDay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;

public class TimeOfDayTest {
	private TimeOfDay time;
	
	@BeforeEach
	void initEach() {
		time = new TimeOfDay(14, 30);
	}
	
	@Nested
	class constructorTests {
		@Test
		void constructorThrowsArgs() {
			assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(14,300));
			assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(-1,300));
			assertThrows(IllegalArgumentException.class, () -> new TimeOfDay(14,-1));
		}
		@Test
		void gettersTest() {
			assertEquals(14, time.getHours());
			assertEquals(30, time.getMinutes());
			assertEquals(14*60+30, time.getMinutesSinceMidnight());
		}
		@Test
		void settersTests() {
			time.setHours(23);
			time.setMinutes(56);
			assertEquals(23, time.getHours());
			assertEquals(56, time.getMinutes());
			assertEquals(23*60+56, time.getMinutesSinceMidnight());
			
			time.setMinutesSinceMidnight(240);
			assertEquals(240/60, time.getHours());
			assertEquals(240%60, time.getMinutes());
			assertEquals(240, time.getMinutesSinceMidnight());
		}
	}
	

}
