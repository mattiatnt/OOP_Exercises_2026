package person;

import java.util.Arrays;
import java.util.stream.IntStream;

import logicalcollections.LogicalSet;
import java.util.*;

/**
 * @invar | getFather() == null || Arrays.stream(getFather().getChildren()).allMatch(child -> child.getFather() == getFather())
 * @invar | getChildren().length == 0 || Arrays.stream(getChildren()).allMatch(child -> Arrays.asList(child.getFather().getChildren()).contains(child))
 */
public class Person {
	/**
	 * @peerObject
	 * @invar | father == null || Arrays.stream(father.children).allMatch(child -> child.father == father)
	 */
	private Person father;
	/**
	 * @peerObject
	 * @invar | children.length == 0 || Arrays.stream(children).allMatch(child -> Arrays.asList(child.father.children).contains(child))
	 */
	private Person[] children;
	
	/**
	 * @post | getFather() == null
	 * @post | getChildren().length == 0
	 */
	public Person() {
		children = new Person[] {};
	}

	public Person getFather() {
		return father;
	}
	
	/**
	 * @creates | result
	 * 
	 */
	public Person[] getChildren() {
		return children.clone();
	}
	
	/**
	 * @mutates_properties | getFather(), getChildren(), father.getChildren()
	 * @inspects | father
	 * @pre | father != null
	 * @pre | getFather() == null
	 * @post | getFather() == father
	 * @post | father.getChildren().length == old(father.getChildren().length)+1
	 * @post | IntStream.range(0, old(father.getChildren().length)).allMatch(i -> father.getChildren()[i] == old(father.getChildren())[i])
	 */
	public void setFather(Person father) {
		//set father
		this.father = father;
		//add this to children of father
		Person[] newChildren = new Person[father.children.length+1];
		for (int i=0; i < father.children.length; i++) {
			newChildren[i] = father.children[i];
		}
		newChildren[father.children.length] = this;
		father.children = newChildren;
	}
	/**
	 * @mutates_properties | getFather(), getChildren(), getFather().getChildren()
	 * @pre | getFather() != null
	 * @post | getFather() == null
	 * @post | old(getFather()).getChildren().length == old(getFather().getChildren().length)-1
	 * @post | Arrays.stream(old(getFather().getChildren())).allMatch(c -> c == this || Arrays.asList(old(getFather()).getChildren()).contains(c))
	 */
	public void removeFather() {
		//remove child from father's children
		Person[] newChildren = new Person[this.father.children.length-1];
		int j = 0;
		for (int i=0; i < father.children.length; i++) {
			if (father.children[i] != this) {
				newChildren[j] = father.children[i];
				j++;
			}
		}
		this.father.children = newChildren;
		
		//remove father
		this.father = null;
	}
	
	
	
	
	
}
