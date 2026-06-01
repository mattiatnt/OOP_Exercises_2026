package ringBuffer;

import java.util.stream.IntStream;

public class RingBuffer {
	private Object[] elements;
	private int size;
	private int start;
	
	/**
	 * @throws IllegalArgumentException | elements == null
	 * 
	 */
	public RingBuffer(Object[] elements) {
		if (elements == null) {
			throw new IllegalArgumentException();
		}		
		this.elements = elements.clone();
		this.size = elements.length;
		this.start = 0;
	}
	
	public Object get(int index) {
		return elements[(start+index)%size];
	}
	
	public void remove(int index) {
		if (index < 5) {
			for (int i = index; i > 0; i--) {
				elements[(start+i)%elements.length] = elements[(start+i-1)%elements.length];
			}
			elements[(start)%elements.length] = null;
			start = (start+1)%elements.length;
			size--;
		} 
		else if (index > size - 5){
			for (int i = index; i < size-1; i++) {
				elements[(start+i)%elements.length] = elements[(start+i+1)%elements.length];
			}
		size--;
		elements[(start+size)%elements.length] = null;
		}
		else {
			if (index < size / 2) {
				for (int i = index; i > 0; i--) {
					elements[(start+i)%elements.length] = elements[(start+i-1)%elements.length];
				}
				elements[start%elements.length] = null;
				start = (start+1)%elements.length;
				size--;				
			}
			else {
				for (int i = index; i < size; i++) {
					elements[(start+i)%elements.length] = elements[(start+i+1)%elements.length];
				}
				size--;
				elements[(start+size)%elements.length] = null;
			}
		}
	}
	
	public void add(int index, Object obj) {
		// resizing if size is equal to capacity
		if (size == elements.length) {
			Object[] newElements = new Object[elements.length*2];
			for (int i= 0; i < elements.length; i++) {
				newElements[(start+i)%newElements.length] = elements[(start+i)%elements.length];
			}
			elements = newElements;
		}
		//near start
		if (index < 5) {
			for (int i = 0; i < index; i++) {
				elements[(start+i-1+elements.length)%elements.length] = elements[(start+i)%elements.length];
			}
			start = (start-1+elements.length)%elements.length;
			elements[(start+index)%elements.length] = obj;
			size++;
		}
		//near end
		else if (index > size - 5){
			for (int i = size-1; i >= index; i--) {
				elements[(start+i+1)%elements.length] = elements[(start+i)%elements.length];
			}
			size++;
			elements[(start+index)%elements.length] = obj;
		}
		//middle 
		else {
			if (index < size / 2) {
				for (int i = 0; i < index; i++) {
					elements[(start+i-1+elements.length)%elements.length] = elements[(start+i)%elements.length];
				}
				start = (start-1+elements.length)%elements.length;
				elements[(start+index)%elements.length] = obj;
				size++;				
			}
			else {
				for (int i = size-1; i >= index; i--) {
					elements[(start+i+1)%elements.length] = elements[(start+i)%elements.length];
				}
				size++;
				elements[(start+index)%elements.length] = obj;
			}
		}
		
	}
}
