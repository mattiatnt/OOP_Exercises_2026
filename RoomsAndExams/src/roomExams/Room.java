package roomExams;
import java.util.*;
/**
 * @invar | getExams().isEmpty()|| getExams().stream().allMatch(e -> e.getRooms().contains(this))
 */
public class Room {
	/**
	 * @invar | room != null
	 */
	Room room;
	/**
	 * @invar | exams != null
	 */
	Set<Exam> exams = new HashSet<Exam>();
	
	/**
	 * @post | getExams() == new HashSet<Exam>()
	 */
	public Room() {}
	
	/**
	 * @post | result != null
	 */
	public Set<Exam> getExams() {
		return Set.copyOf(exams);
	}
	
}
