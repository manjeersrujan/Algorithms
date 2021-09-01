
/**
 * @author smanjeer
 *
 *         22 Aug 2021 9:37:59 PM
 * 
 *         https://leetcode.com/problems/integer-break/
 * 
 */
public class IntegerBreak {

	public static void main(String[] args) {
		System.out.println(new IntegerBreak().integerBreak(4));
	}

	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				max = Math.max(max,
						Math.max(j * (i - j), Math.max(j * dp[i - j], Math.max(dp[j] * (i - j), dp[j] * dp[i - j]))));
			}
			dp[i] = max;
		}

		return dp[n];
	}
}
