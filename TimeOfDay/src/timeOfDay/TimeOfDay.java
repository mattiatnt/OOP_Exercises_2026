package timeOfDay;

/**
 * @invar | getHours() >= 0 && getHours() <= 23
 * @invar | getMinutes() >= 0 && getMinutes() <= 59
 * @invar | getMinutesSinceMidnight() >= 0 && getMinutesSinceMidnight() <= 23*60+59
 */
public class TimeOfDay {
	/**
	 * @invar | hours >= 0 && hours <= 23
	 */
	private int hours;
	/**
	 * @invar | minutes >= 0 && minutes <= 59
	 */
	private int minutes;
	
	/**
	 * @invar minutesSinceMid >= 0 && minutesSinceMid <= 23*60+59
	 */
	private int minutesSinceMid;
	
	/**
	 * COnstructor
	 * 
	 * @throws IllegalArgumentException | hours < 0 || hours > 23
	 * @throws IllegalArgumentException | minutes < 0 || minutes > 60
	 * 
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		if (minutes < 0 || minutes > 60) {throw new IllegalArgumentException();}
		if (hours < 0 || hours > 23) {throw new IllegalArgumentException();}
		this.hours = hours;
		this.minutes = minutes;
		this.minutesSinceMid = hours *60 + minutes;
	}
	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}
	
	public int getMinutesSinceMidnight() {
		return minutesSinceMid;
	}
	
	/**
	 * @pre | hours >= 0
	 * @post | getHours() == hours
	 */
	public void setHours(int hours) {
		this.hours = hours;
		this.minutesSinceMid = hours * 60 + this.minutes;
	}
	/**
	 * @pre | minutes >= 0
	 * @pre | minutes < 60
	 * @post | getMinutes() == minutes
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
		this.minutesSinceMid = this.hours*60 + minutes;
	}
	/**
	 * @pre | minutes >= 0
	 * @post | getHours() == minutes / 60
	 * @post | getMinutes() == minutes % 60
	 * @post | getMinutesSinceMidnight() == minutes
	 */
	public void setMinutesSinceMidnight(int minutes) {
		this.hours = minutes / 60;
		this.minutes =  minutes % 60;
		this.minutesSinceMid = minutes;
	}
}
