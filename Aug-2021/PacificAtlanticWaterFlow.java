import java.util.ArrayList;
import java.util.List;

/**
 * @author smanjeer
 *
 *         18 Aug 2021 2:27:36 AM
 * 
 *         https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 
 */
public class PacificAtlanticWaterFlow {
	int[][] adjs = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		int[][][] dp = new int[heights.length][heights[0].length][2];

		for (int i = 0; i < heights[0].length; i++) {
			dp[0][i][0] = 1;
			dp[heights.length - 1][i][1] = 1;
            dfs(heights, dp, 0, i, 0);
            dfs(heights, dp, heights.length - 1, i, 1);
		}

		for (int i = 0; i < heights.length; i++) {
			dp[i][0][0] = 1;
			dp[i][heights[0].length - 1][1] = 1;
            dfs(heights, dp, i, 0, 0);
            dfs(heights, dp, i, heights[0].length - 1, 1);
		}

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[0].length; j++) {
				if (dp[i][j][0] == 1 && dp[i][j][1] == 1) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					list.add(j);
					res.add(list);
				}
			}
		}

		return res;
	}

	private void dfs(int[][] heights, int[][][] dp, int i, int j, int isRed) {

		for (int[] adj : adjs) {
			int r = i + adj[0];
			int c = j + adj[1];

			if (r >= 0 && r < heights.length && c >= 0 && c < heights[0].length) {
				if (dp[r][c][isRed] != 1 && heights[r][c] >= heights[i][j]) {
					dp[r][c][isRed] = 1;
					dfs(heights, dp, r, c, isRed);
				}
			}
		}

	}
}
