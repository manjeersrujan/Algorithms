
/**
 * @author smanjeer
 *
 *         31 Aug 2021 2:50:07 AM
 * 
 *         https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 * 
 */
public class NumberOfSubArraysWithOddSum {
	public int numOfSubarrays(int[] arr) {

		 int[] dp = new int[arr.length];
			dp[0] = arr[0] % 2;
			int res = dp[0] %1000000007;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] % 2 == 1) {
					dp[i] = i - dp[i - 1] + 1;
				} else {
					dp[i] = dp[i - 1];
				}
				res = (res + dp[i]) % 1000000007;
			}

			return res;
	}

}
