package roomExams;
import java.util.*;

import logicalcollections.LogicalSet;
/**
 * @invar | getRooms().isEmpty() || getRooms().stream().allMatch(r -> r.getExams().contains(this))
 */
public class Exam {
	/**
	 * @invar | rooms != null
	 */
	Set<Room> rooms = new HashSet<Room>();
	/**
	 * @invar | exam != null
	 */
	Exam exam;
	
	/**
	 * @post | getRooms() == new HashSet<Room>()
	 */
	public Exam() {}
	
	/**
	 * @post | result != null
	 */
	public Set<Room> getRooms() {
		return Set.copyOf(rooms);
	}
	
	/**
	 * @pre | room != null
	 * @mutates_properties | getRooms(), room.getExams()
	 * @post | getRooms() == LogicalSet.plus(getRooms(), room)
	 * @post | room.getExams() == LogicalSet.plus(room.getExams(), this)
	 */
	public void linkRoom(Room room) {
		rooms.add(room);
		room.exams.add(this);
	}
	
	/**
	 * @pre | room != null
	 * @mutates_properties | getRooms(), room.getExams()
	 * @post | getRooms() == LogicalSet.minus(getRooms(), room)
	 * @post | room.getExams() == LogicalSet.minus(room.getExams(), this)
	 */
	public void unlinkRoom(Room room) {
		rooms.remove(room);
		room.exams.remove(this);
	}
}
