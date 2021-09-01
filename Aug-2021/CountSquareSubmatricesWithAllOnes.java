
/**
 * @author smanjeer
 *
 *         29 Aug 2021 2:43:15 AM
 * 
 *         https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 */
public class CountSquareSubmatricesWithAllOnes {

	public int countSquares(int[][] matrix) {
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int res = 0;
		for (int i = 1; i < matrix.length + 1; i++) {
			for (int j = 1; j < matrix[0].length + 1; j++) {
				if (matrix[i - 1][j - 1] == 1) {
					dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
					res += dp[i][j];
				}
			}
		}
		return res;
	}
}
