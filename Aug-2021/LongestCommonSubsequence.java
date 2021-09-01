import java.util.HashMap;
import java.util.Map;

/**
 * @author smanjeer
 *
 *         31 Aug 2021 4:40:31 AM
 * 
 *         https://leetcode.com/problems/longest-common-subsequence/
 *         
 *         Arrays can be used instead of map. But, need to  initialize with -1 
 * 
 */
public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String text1, String text2) {

		Map<String, Integer> map = new HashMap<>();

		return lcs(text1, text2, map);

	}

	private int lcs(String text1, String text2, Map<String, Integer> map) {

		if (text1.length() == 0 || text2.length() == 0) {
			return 0;
		}

		if (map.containsKey(text1.length() + "-" + text2.length())) {
			return map.get(text1.length() + "-" + text2.length());
		}

		int res = 0;
		if (text1.charAt(0) == text2.charAt(0)) {
			res = lcs(text1.substring(1), text2.substring(1), map) + 1;
		} else {
			res = Math.max(lcs(text1.substring(1), text2, map), lcs(text1, text2.substring(1), map));
		}

		map.put(text1.length() + "-" + text2.length(), res);

		return res;
	}
}
