import java.util.HashSet;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         18 Jul 2021 9:42:00 PM
 * 
 *         https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		int longestSeq = 0;
		for (int num : nums) {
			int curSeq = 1;
			int curNum = num;
			while (set.contains(--num)) {
				curSeq++;
				set.remove(num);
			}

			num = curNum;
			while (set.contains(++num)) {
				curSeq++;
				set.remove(num);
			}

			longestSeq = Math.max(longestSeq, curSeq);

		}

		return longestSeq;
	}

}
