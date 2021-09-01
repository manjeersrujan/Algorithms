
public class MaximalSquare {

	public static void main(String[] args) {
		char[][] test = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } };
		System.out.println(new MaximalSquare().maximalSquare(test));
	}

	public int maximalSquare(char[][] matrix) {
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
		int max = 0;
		for (int i1 = 1, j1 = 0; j1 < matrix.length; j1++, i1++) {
			for (int i2 = 1, j2 = 0; j2 < matrix[0].length; j2++, i2++) {
				if (matrix[j1][j2] == 1) {
					dp[i1][i2] = Math.min(dp[i1][i2 - 1], Math.min(dp[i1 - 1][i2], dp[i1 - 1][i2 - 1])) + 1;
					max = Math.max(max, dp[i1][i2]);
				} else {
					dp[i1][i2] = 0;
				}
			}
		}
		return max * max;
	}
}
