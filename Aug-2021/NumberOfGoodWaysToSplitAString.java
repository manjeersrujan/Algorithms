import java.util.HashSet;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         16 Aug 2021 1:51:59 AM
 * 
 *         https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * 
 */
public class NumberOfGoodWaysToSplitAString {
	public int numSplits(String s) {
		int[][] dp = new int[s.length()][2];
		Set<Character> cs1 = new HashSet<>();
		Set<Character> cs2 = new HashSet<>();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			cs1.add(s.charAt(i));
			dp[i][0] = cs1.size();

			cs2.add(s.charAt(s.length() - (i + 1)));
			dp[s.length() - (i + 1)][1] = cs2.size();
		}
		for (int i = 0; i < s.length()-1; i++) {
			if (dp[i][0] == dp[i + 1][1]) {
				res++;
			}
		}
		return res;
	}
}
