import java.util.Arrays;

/**
 * @author smanjeer
 *
 *         19 Jul 2021 3:08:58 AM
 * 
 *         https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 * 
 */
public class MinDiffBetweenLargestAndSmallestInThreeMoves {
	public int minDifference(int[] nums) {

		if (nums.length <= 3) {
			return 0;
		}
		Arrays.sort(nums);
		int lastIndex = nums.length - 1;
		return Math.min(Math.min(nums[lastIndex] - nums[3], nums[lastIndex - 3] - nums[0]),
				Math.min(nums[lastIndex - 2] - nums[1], nums[lastIndex - 1] - nums[2]));
	}
}
