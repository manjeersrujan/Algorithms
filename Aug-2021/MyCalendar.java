import java.util.TreeSet;

/**
 * @author smanjeer
 *
 *         28 Jul 2021 12:54:42 PM
 * 
 *         https://leetcode.com/problems/my-calendar-i/
 * 
 */
public class MyCalendar {

	public static void main(String[] args) {

		MyCalendar myCalendar = new MyCalendar();

		myCalendar.book(37, 50);
		myCalendar.book(33, 50);
		myCalendar.book(37, 50);
		myCalendar.book(35, 48);
		myCalendar.book(8, 25);
	}

	public MyCalendar() {
		this.sortedEvents = new TreeSet<Event>((a, b) -> (a.start - b.start));
	}

	TreeSet<Event> sortedEvents = null;

	public boolean book(int start, int end) {
		Event event = new Event(start, end);
		if (sortedEvents.isEmpty()) {
			sortedEvents.add(event);
			return true;
		}

		Event floor = sortedEvents.floor(event);
		Event ceiling = sortedEvents.ceiling(event);

		if (floor == null) {
			if (event.end <= ceiling.start) {
				sortedEvents.add(event);
				return true;
			} else {
				return false;
			}
		}

		if (ceiling == null) {
			if (floor.end <= event.start) {
				sortedEvents.add(event);
				return true;
			} else {
				return false;
			}

		}

		if (floor.end <= event.start && event.end <= ceiling.start) {
			sortedEvents.add(event);
			return true;
		}

		return false;

	}

	private class Event {		

		int start;
		int end;

		public Event(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		private MyCalendar getEnclosingInstance() {
			return MyCalendar.this;
		}

	}

}
