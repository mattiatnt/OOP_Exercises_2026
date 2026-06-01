package sequence;

public class EmptySequence extends Sequence{
	
	public EmptySequence() {}
	
	/**
	 * @post | result == 0
	 */
	public int getLength() {
		return 0;
	}
	/**
	 * @post | result == obj instanceof EmptySequence
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof EmptySequence;
	}
	
	/**
	 * @post | result == ""
	 */
	@Override
	public String toString() {
		return "";
	}

}
