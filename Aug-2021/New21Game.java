
/**
 * @author smanjeer
 *
 *         18 Aug 2021 5:22:49 AM
 * 
 *         https://leetcode.com/problems/new-21-game/
 * 
 */
public class New21Game {

	public double new21Game(int n, int k, int maxPts) {
		if (n <= k || n == maxPts) {
			return 1;
		}

		if (n > (k + maxPts - 1)) {
			return 0;
		}

		return ((double) (n - k - 1) / (double) (maxPts - 1));

	}

}
