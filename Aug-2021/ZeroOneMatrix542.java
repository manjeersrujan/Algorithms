import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         31 Aug 2021 8:31:22 AM
 * 
 *         https://leetcode.com/problems/01-matrix/
 * 
 */
public class ZeroOneMatrix542 {
	int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public int[][] updateMatrix(int[][] mat) {
		int[][] dp = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;

			}
		}

		Queue<Index> q = new LinkedList<>();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					dp[i][j] = 0;
					q.add(new Index(i, j));
				}
			}
		}

		return bfsDP(q, dp);

	}

	private int[][] bfsDP(Queue<Index> q, int[][] dp) {

		while (!q.isEmpty()) {
			Index in = q.poll();
			for (int i = 0; i < dir.length; i++) {
				int r = in.i + dir[i][0];
				int c = in.j + dir[i][1];

				if (r >= 0 && r < dp.length && c >= 0 && c < dp[0].length) {
					if (dp[r][c] > dp[in.i][in.j] + 1) {
						dp[r][c] = dp[in.i][in.j] + 1;
						q.add(new Index(r, c));
					}
				}
			}
		}

		return dp;
	}

	class Index {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + i;
			result = prime * result + j;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Index other = (Index) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (i != other.i)
				return false;
			if (j != other.j)
				return false;
			return true;
		}

		public Index(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		int i;
		int j;

		private ZeroOneMatrix542 getEnclosingInstance() {
			return ZeroOneMatrix542.this;
		}
	}
}
