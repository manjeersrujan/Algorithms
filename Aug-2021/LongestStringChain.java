import java.util.Arrays;
import java.util.Comparator;

/**
 * @author smanjeer
 *
 *         18 Jul 2021 3:50:09 PM
 * 
 *         https://leetcode.com/problems/longest-string-chain/
 * 
 */
public class LongestStringChain {

	public static void main(String[] args) {
		String[] args1 = { "a", "b", "ba", "bca", "bda", "bdca" };
		System.out.println(new LongestStringChain().longestStrChain(args1));
	}

	public int longestStrChain(String[] words) {

		Arrays.parallelSort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		int[] dp = new int[words.length];
		int maxLength = 0;
		for (int i = 0; i < words.length; i++) {
			dp[i] = 1;
			int curMaxLength = 0;
			for (int j = i - 1; j >= 0; j--) {

				if (isSequence(words[j], words[i])) {
					if (curMaxLength < dp[j]) {
						curMaxLength = dp[j];
					}
				}
			}

			dp[i] += curMaxLength;

			if (dp[i] > maxLength) {
				maxLength = dp[i];
			}
		}

		return maxLength;

	}

	private boolean isSequence(String s1, String s2) {

		if (s2.length() - s1.length() != 1) {
			return false;
		}

		if (s1.length() == 0) {
			return true;
		}

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return s1.subSequence(i, s1.length()).equals(s2.subSequence(i + 1, s2.length()));
			}
		}

		return true;
	}

}
