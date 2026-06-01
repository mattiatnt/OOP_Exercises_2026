package airports;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getConnectedAirs().isEmpty() || getConnectedAirs().stream().allMatch(air -> air != null && air.getConnectedAirs().contains(this))
 */
public class Airport {
	
	/**
	 * @invar | connectedAirs.isEmpty() || connectedAirs.stream().allMatch(air -> air != null && air.getConnectedAirs().contains(this))
	 * @peerObject
	 * @representationObject
	 */
	private Set<Airport> connectedAirs = new HashSet<>();
	
	/**
	 * @creates | result
	 * @post | result != null 
	 */
	public Set<Airport> getConnectedAirs() {
		return Set.copyOf(connectedAirs);
	}
	
	/**
	 * @post | getConnectedAirs().equals(new HashSet<>())
	 */
	public Airport() {}
	
	/**
	 * @mutates | this, other 
	 * @mutates_properties | this.getConnectedAirs(), other.getConnectedAirs()
	 * @pre | other != null
	 * @pre | !getConnectedAirs().contains(other)
	 * @post | getConnectedAirs().contains(other)
	 * @post | other.getConnectedAirs().contains(this)
	 * @post | getConnectedAirs().equals(LogicalSet.plus(old(getConnectedAirs()), other))
	 */
	public void link(Airport other) {
		this.connectedAirs.add(other);
		other.connectedAirs.add(this);
	}
	
	/**
	 * @mutates | this, other 
	 * @mutates_properties | this.getConnectedAirs(), other.getConnectedAirs()
	 * @pre | other != null
	 * @pre | getConnectedAirs().contains(other)
	 * @post | !getConnectedAirs().contains(other)
	 * @post | !other.getConnectedAirs().contains(this)
	 * @post | getConnectedAirs().equals(LogicalSet.minus(old(getConnectedAirs()), other))
	 */
	public void unlink(Airport other) {
		this.connectedAirs.remove(other);
		other.connectedAirs.remove(this);
	}
	
	
	
}
