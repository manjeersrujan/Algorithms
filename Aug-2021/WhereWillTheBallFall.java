
/**
 * @author smanjeer
 *
 *         18 Aug 2021 6:56:29 PM
 * 
 *         https://leetcode.com/problems/where-will-the-ball-fall/
 * 
 */

public class WhereWillTheBallFall {

	public int[] findBall(int[][] grid) {
		int[] res = new int[grid[0].length];

		for (int j = 0; j < grid[0].length; j++) {
			res[j] = dfs(grid, 0, j);
		}

		return res;
	}

	private int dfs(int[][] grid, int i, int j) {

		if (j >= grid[0].length || j < 0) {
			return -1;
		}

		if (i == grid.length) {
			return j;
		}

		if ((j < grid[0].length - 1 && grid[i][j] == 1 && grid[i][j + 1] == -1)
				|| (j>0 && grid[i][j] == -1 && grid[i][j - 1] == 1)) {
			return -1;
		}
		return dfs(grid, i + 1, j + grid[i][j]);

	}

}
