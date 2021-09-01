import java.util.ArrayList;
import java.util.List;

/**
 * @author smanjeer
 *
 *         22 Aug 2021 5:10:29 AM
 * 
 *         https://leetcode.com/problems/insert-interval/
 * 
 */
public class InsertInterval {

	public static void main(String[] args) {
		int[] newInterval = { 2, 5 };
		int[][] intervals = { { 1, 3 }, { 6, 9 } };
		int[][] insert = new InsertInterval().insert(intervals, newInterval);
		for (int[] ar : insert) {
			for (int i : ar) {
				System.out.print(i + ", ");
			}
			System.out.println();

		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> newIntList = new ArrayList<>();
		boolean inserted = false;
		for (int[] arr : intervals) {
			if (arr[1] < newInterval[0]) {
				newIntList.add(arr);
			} else if (newInterval[1] < arr[0]) {
				if (!inserted) {
					newIntList.add(newInterval);
					inserted = true;
				}
				newIntList.add(arr);
			} else {
				newInterval[0] = Math.min(arr[0], newInterval[0]);
				newInterval[1] = Math.max(arr[1], newInterval[1]);

			}
		}

		if (!inserted) {
			newIntList.add(newInterval);
		}

		return newIntList.toArray(new int[newIntList.size()][]);
	}

}
