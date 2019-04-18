
/*
 * 
 * 
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class FindStartEnd {
	
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(new FindStartEnd().searchRange(nums, 8)[0]);

	}
	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			int[] defRes = {-1,-1};
			return defRes;
		}
		int start = 0;
		int end = nums.length-1;
		int mid = 0;
		while(start < end ) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target || mid == start) {
				break;
			} else if(nums[mid] < target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		
		if(nums[mid] == target) {
			int temp = mid;
			int st = -1;
			while(temp >=0 && nums[temp] == target) {
				st = temp--;
			}
			
			temp = mid;
			int ed = -1;
			while(temp <nums.length && nums[temp] == target) {
				ed = temp++;
			}
			
			int[] result = {st,ed};
 			return result;
			
		}else {
			int[] defRes = {-1,-1};
			return defRes;
		}
	}
}
