
/**
 * @author smanjeer
 *
 *         22 Aug 2021 8:26:41 PM
 * 
 *         https://leetcode.com/problems/coin-change/
 * 
 */
public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		 
		int[] dp = new int[amount + 1];
		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] == i) {
					min = 1;
				} else if (coins[j] < i && dp[i - coins[j]] != -1) {
					min = Math.min(min, dp[i - coins[j]] + 1);
				}
			}
			dp[i] = min == Integer.MAX_VALUE ? -1 : min;
		}

		return dp[amount];
	}
}
