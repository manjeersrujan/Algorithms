
/**
 * @author smanjeer
 *
 *         22 Aug 2021 11:22:51 PM
 * 
 *         https://leetcode.com/problems/maximum-product-subarray/
 * 
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= nums.length; i++) {
			int cur = nums[i - 1];
			if (cur != 0) {
				dp[i][1] = Math.max(dp[i - 1][0] * cur, Math.max(dp[i - 1][1] * cur, cur));
				dp[i][0] = Math.min(dp[i - 1][1] * cur, Math.min(dp[i - 1][0] * cur, cur));
				max = Math.max(max, dp[i][1]);
			} else {
				dp[i][1] = 1;
				dp[i][0] = 1;
				max = Math.max(max, 0);
			}
		}
		return max;
	}

}
