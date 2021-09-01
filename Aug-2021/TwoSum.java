import java.util.HashMap;
import java.util.Map;

/**
 * @author smanjeer
 *
 *         31 Aug 2021 4:26:36 AM
 * 
 *         https://leetcode.com/problems/two-sum/
 * 
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];

			if (map.containsKey(diff)) {
				int[] res = { i, map.get(diff) };
				return res;
			}

			map.put(nums[i], i);
		}

		return null;

	}
}
