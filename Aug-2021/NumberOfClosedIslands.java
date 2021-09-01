
/**
 * @author smanjeer
 *
 *         15 Aug 2021 1:56:50 AM
 * 
 *         https://leetcode.com/problems/number-of-closed-islands/
 * 
 */
public class NumberOfClosedIslands {

	public int closedIsland(int[][] grid) {

		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					if (isIsland(i, j, grid)) {
						res++;
					}
				}
			}
		}
		return res;
	}

	private boolean isIsland(int i, int j, int[][] grid) {

		if (grid[i][j] == 2 || grid[i][j] == 1) {
			return true;
		}

		if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1) {
			return false;
		}

		grid[i][j] = 2;

		if ((isIsland(i - 1, j, grid)) & (isIsland(i, j - 1, grid)) & (isIsland(i + 1, j, grid))
				& (isIsland(i, j + 1, grid))) {
			return true;
		}

		return false;
	}

}
