package roomExams;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

class RoomTests {
	
	private Room room;
	private Exam exam1;
	private Exam exam2;

	@BeforeEach
	void initEach() {
		room = new Room();
		exam1 = new Exam();
		exam2 = new Exam();
	}
	
	@Test
	void ExamsEmptyTest() {
		assertEquals(new HashSet<Exam>(), room.getExams());
	}

}
