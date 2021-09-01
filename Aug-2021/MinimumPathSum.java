
/**
 * @author smanjeer
 *
 *         29 Aug 2021 10:42:49 PM
 * 
 *         https://leetcode.com/problems/minimum-path-sum/
 * 
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(new MinimumPathSum().minPathSum(grid));
	}

	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i > 0 && j > 0) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
				} else if (i > 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
				} else if (j > 0) {
					dp[i][j] = dp[i][j - 1] + grid[i][j];
				}
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];

	}
}
