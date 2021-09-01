import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author smanjeer
 *
 *         31 Aug 2021 4:05:21 AM
 * 
 *         https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<ArrayList<Integer>> dp = new ArrayList<>();
		List<Integer> res = new ArrayList<Integer>();
		Arrays.parallelSort(nums);
		for (int i = 0; i < nums.length; i++) {
			List<Integer> maxList = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (maxList.size() < dp.get(j).size()) {
						maxList = dp.get(j);
					}
				}
			}
			dp.add(new ArrayList<Integer>());
			dp.get(i).addAll(maxList);
			dp.get(i).add(nums[i]);

			res = res.size() < dp.get(i).size() ? dp.get(i) : res;
		}

		return res;
	}
}
