import java.util.HashMap;
import java.util.Map;

/*
 * Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcbda" and k = 2, the longest substring with k distinct characters is "bcb".

 */
public class LongestStringWithKDistinctChar {

	public static void main(String[] args) {
		System.out.println(new LongestStringWithKDistinctChar().getLongestStringWithKDistinctChar("abcdef", 3));
	}

	public String getLongestStringWithKDistinctChar(String str, int k) {

		if (str == null || str.length() == 0) {
			return str;
		}

		if (k <= 0) {
			return "";
		}

		int st = 0, end = 0;
		String result = "";
		Map<Character, Integer> dp = new HashMap<>();
		while (end - st >= result.length() && end < str.length()) {
			if (dp.get(str.charAt(end)) == null) {
				dp.put(str.charAt(end), 1);
			} else {
				dp.put(str.charAt(end), dp.get(str.charAt(end)) + 1);
			}

			while (dp.size() > k && st < end) {
				Integer count = dp.get(str.charAt(st));
				if (count <= 1) {
					dp.remove(str.charAt(st));
				} else {
					dp.put(str.charAt(end), count - 1);
				}
				st++;
			}

			if ((end - st) + 1 > result.length()) {
				result = str.substring(st, end + 1);
			}
			end++;
		}

		return result;

	}

}
