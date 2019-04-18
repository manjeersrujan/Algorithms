import java.util.HashMap;
import java.util.Map;


/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class FindNumbersWithGivenSum {
	public int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length <= 1) {
			return null;
		}
		
		Map<Integer, Integer> store = new HashMap<>();
		
		for(int i=0;i<nums.length; i++) {
			if(store.get(nums[i]) != null) {
				int[] result =  { store.get(nums[i]), i};
				return result;
			}
			store.put(target - nums[i], i);
		}
		return null;
	}
}
