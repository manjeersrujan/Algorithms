
/**
 * @author smanjeer
 *
 * 18 Jul 2021 4:00:14 AM
 * 
 * https://leetcode.com/problems/max-area-of-island/
 * 
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {

		int[][] seen = new int[grid.length][grid[0].length];
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int area = findIslandArea(i, j, grid, seen);
					if (maxArea < area) {
						maxArea = area;
					}
				}
			}
		}

		return maxArea;
	}

	private int findIslandArea(int i, int j, int[][] grid, int[][] seen) {
		int area = 0;
		if (seen[i][j] != 0) {
			return 0;
		} else if (grid[i][j] == 1) {
			seen[i][j] = 1;
			area++;
		} else {
			return 0;
		}

		if (j > 0) {
			area = area + findIslandArea(i, j - 1, grid, seen);
		}

		if (i > 0) {
			area = area + findIslandArea(i - 1, j, grid, seen);
		}

		if (j < grid[0].length - 1) {
			area = area + findIslandArea(i, j + 1, grid, seen);
		}

		if (i < grid.length - 1) {
			area = area + findIslandArea(i + 1, j, grid, seen);
		}

		return area;

	}
}
