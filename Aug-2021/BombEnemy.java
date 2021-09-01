
/**
 * @author smanjeer
 *
 *         31 Aug 2021 7:34:04 AM
 * 
 *         https://leetcode.com/problems/bomb-enemy/
 * 
 */
public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		int[][][] dp = new int[4][grid.length][grid[0].length];

		/*
		 * Left DP
		 */
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 'W' || j == 0) {
					dp[0][i][j] = 0;
				} else if (grid[i][j - 1] == 'E') {
					dp[0][i][j] = dp[0][i][j - 1] + 1;
				} else {
					dp[0][i][j] = dp[0][i][j - 1];
				}
			}
		}

		/*
		 * Right DP
		 */
		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[0].length - 1; j >= 0; j--) {
				if (grid[i][j] == 'W' || j == grid[0].length - 1) {
					dp[1][i][j] = 0;
				} else if (grid[i][j + 1] == 'E') {
					dp[1][i][j] = dp[1][i][j + 1] + 1;
				} else {
					dp[1][i][j] = dp[1][i][j + 1];
				}
			}
		}

		/*
		 * Up
		 */
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = 0; i < grid.length; i++) {
				if (grid[i][j] == 'W' || i == 0) {
					dp[2][i][j] = 0;
				} else if (grid[i - 1][j] == 'E') {
					dp[2][i][j] = dp[2][i - 1][j] + 1;
				} else {
					dp[2][i][j] = dp[2][i - 1][j];
				}
			}
		}

		/*
		 * Down
		 */
		for (int j = 0; j < grid[0].length; j++) {
			for (int i = grid.length - 1; i >= 0; i--) {
				if (grid[i][j] == 'W' || i == grid.length - 1) {
					dp[3][i][j] = 0;
				} else if (grid[i + 1][j] == 'E') {
					dp[3][i][j] = dp[3][i + 1][j] + 1;
				} else {
					dp[3][i][j] = dp[3][i + 1][j];
				}
			}
		}

		int res = Integer.MIN_VALUE;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					res = Math.max(res, dp[0][i][j] + dp[1][i][j] + dp[2][i][j] + dp[3][i][j]);
				}
			}
		}

		return res == Integer.MIN_VALUE ? 0 : res;
	}
}
