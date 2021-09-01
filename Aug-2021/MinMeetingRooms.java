import java.util.Arrays;


/**
 * @author smanjeer
 *
 * 18 Jul 2021 4:00:29 AM
 * 
 * https://leetcode.com/problems/meeting-rooms-ii/solution/
 * 
 */
public class MinMeetingRooms {

	public int minMeetingRooms(int[][] intervals) {
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}

		Arrays.sort(start);
		Arrays.sort(end);
		int minRooms = 0;
		for (int startInd = 0, endInd = 0; startInd < start.length; startInd++) {
			if (start[startInd] >= end[endInd]) {
				minRooms--;
				endInd++;
			}

			minRooms++;
		}
		return minRooms;
	}

}
