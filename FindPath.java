import java.util.ArrayList;
import java.util.List;

public class FindPath {

	public static void main(String[] args) {
		List<List<Integer>> area = new ArrayList<>();
		List<Integer> r1 = new ArrayList<>();
		r1.add(1);
		r1.add(1);
		r1.add(1);
		area.add(r1);
		r1 = new ArrayList<>();
		r1.add(0);
		r1.add(0);
		r1.add(1);
		area.add(r1);
		r1 = new ArrayList<>();
		r1.add(1);
		r1.add(9);
		r1.add(1);
		area.add(r1);

		System.out.println(new FindPath().minimumDistance(3, 3, area));
	}

	int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		int[][] dp = new int[numRows][numColumns];

		int[] dest = new int[2];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = 10000000;
				if (area.get(i).get(j) == 9) {
					dest[0] = i;
					dest[1] = j;
				}
			}
		}
		dp[0][0] = 0;
		dfs(area, 0, 0, dp);
		return dp[dest[0]][dest[1]] == 10000000 ? -1 : dp[dest[0]][dest[1]];
		// WRITE YOUR CODE HERE
	}

	private void dfs(List<List<Integer>> area, int sr, int sc, int[][] dp) {
		int[][] moves = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		for (int[] move : moves) {
			int x = sr + move[0];
			int y = sc + move[1];
			int count = 0;
			while (x >= 0 && y >= 0 && x < area.size() && y < area.get(0).size() && area.get(x).get(y) >= 1) {
				count++;
				if ( dp[x - move[0]][y - move[1]] + count < dp[x][y]) {
					dp[x][y] = dp[x - move[0]][y - move[1]] + count;
				}
				x += move[0];
				y += move[1];
			}
			System.out.println(dp[sr][sc]  + " " + count + " " + dp[x - move[0]][y - move[1]]);
			if ( dp[sr][sc] + count < dp[x - move[0]][y - move[1]]) {
				dp[x - move[0]][y - move[1]] = dp[sr][sc] + count;
				dfs(area, x - move[0], y - move[1], dp);
			}
		}

	}
}
