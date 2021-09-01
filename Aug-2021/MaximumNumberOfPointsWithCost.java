
/**
 * @author smanjeer
 *
 *         29 Aug 2021 3:21:02 AM
 * 
 *         https://leetcode.com/problems/maximum-number-of-points-with-cost/
 * 
 */
public class MaximumNumberOfPointsWithCost {
	public long maxPoints(int[][] points) {
		long[] dp = new long[points[0].length];
		long res = Long.MIN_VALUE;
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[0].length; j++) {
				dp[j] = dp[j] + points[i][j];
				res = Math.max(res, dp[j]);
			}

			for (int j = 1; j < points[0].length; j++) {
				dp[j] = Math.max(dp[j - 1] - 1, dp[j]);
			}
			for (int j = points[0].length - 2; j >= 0; j--) {
				dp[j] = Math.max(dp[j + 1] - 1, dp[j]);
			}

		}

		return res;

	}
}
