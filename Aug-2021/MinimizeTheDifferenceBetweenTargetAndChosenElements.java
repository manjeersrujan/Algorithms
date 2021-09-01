
/**
 * @author smanjeer
 *
 *         30 Aug 2021 1:17:35 AM
 * 
 *         https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
 * 
 */
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int target = 13;
		System.out
				.println(new MinimizeTheDifferenceBetweenTargetAndChosenElements().minimizeTheDifference(mat, target));
	}

	public int minimizeTheDifference(int[][] mat, int target) {

		Integer[][] dp = new Integer[mat.length][70 * 70 + 1];
		return minAbs(mat, target, dp, 0, 0);

	}

	private int minAbs(int[][] mat, int target, Integer[][] dp, int row, int sum) {

		if (row == mat.length) {
			return Math.abs(sum - target);
		}

		if (dp[row][sum] != null) {
			return dp[row][sum];
		}

		int minAbs = Integer.MAX_VALUE;
		for (int i = 0; i < mat[0].length; i++) {
			minAbs = Math.min(minAbs, minAbs(mat, target, dp, row + 1, sum + mat[row][i]));
		}

		dp[row][sum] = minAbs;

		return minAbs;
	}
}
