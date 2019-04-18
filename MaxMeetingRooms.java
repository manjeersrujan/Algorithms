import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	
}

class IntComp implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		if(o1 == null && o2 == null){
			return 0;
		}
		
		if(o1 == null ){
			return 1;
		}
		
		if(o2 == null){
			return -1;
		}
		
		return o1.start - o2.start;
		
	}
	
}

class IntComp1 implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		if(o1 == null && o2 == null){
			return 0;
		}
		
		if(o1 == null ){
			return 1;
		}
		
		if(o2 == null){
			return -1;
		}
		
		return o1.end - o2.end;
		
	}
	
}

public class MaxMeetingRooms {
	
	public static void main(String[] args) {
		Interval[] intervals = {new Interval(5,10), new Interval(2,30), new Interval(1,45), new Interval(0,23)};
		new MaxMeetingRooms().minMeetingRooms(intervals);
	}

	public int minMeetingRooms(Interval[] intervals) {
		
		Arrays.sort(intervals, new IntComp());
		Queue<Interval> q = new PriorityQueue<>(new IntComp1());
		int max = Integer.MIN_VALUE;
		for(int i=0;i<intervals.length; i++) {
			Interval peek = q.peek();
			if(peek != null) {
				if(peek.end <= intervals[i].start) {
					q.poll();
				}
			}
			q.add(intervals[i]);
			if(max < q.size()) {
				max = q.size();
			}
		}
		return max;
	}
}
