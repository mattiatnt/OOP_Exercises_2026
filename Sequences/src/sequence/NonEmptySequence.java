package sequence;

public class NonEmptySequence extends Sequence{
	private int head;
	private Sequence tail;
	
	/**
	 * @throws IllegalArgumentException | tail == null
	 * @post | getHead() == head
	 * @post | getTail().equals(tail)
	 */
	public NonEmptySequence(int head, Sequence tail) {
		if (tail == null) {throw new IllegalArgumentException();}
		this.head = head;
		this.tail = tail;
	}
	
	/**
	 * @post | result == getTail().getLength() + 1
	 */
	public int getLength() {
		return tail.getLength() + 1;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NonEmptySequence s &&
				s.head == this.head &&
				s.tail.equals(tail);
	}


	@Override
	public String toString() {
		return head + tail.toString();
	}

	public int getHead() {
		return head;
	}

	public Sequence getTail() {
		return tail;
	}


}
