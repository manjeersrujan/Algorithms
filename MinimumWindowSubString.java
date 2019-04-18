import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubString {

	public static void main(String[] args) {
		//System.out.println(new MinimumWindowSubString().minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(new MinimumWindowSubString().minWindow("a", "aa"));

	}

	public String minWindow(String s, String t) {
		char[] tArray = t.toCharArray();
		Map<Character, Integer> tMap = new HashMap<>();
		Map<Character, Integer> sMap = new HashMap<>();

		for (char c : tArray) {
			if(sMap.get(c) == null) {
				sMap.put(c, 1);
			}else {
				sMap.put(c, sMap.get(c)+1);
			}
		}
		int size = sMap.size();
		char[] sArray = s.toCharArray();

		int start = 0;
		int end = 0;
		String min = "";
		boolean found = false;

		for (int i = 0; i < sArray.length; i++) {
			if (sMap.containsKey(sArray[i])) {
				if (!tMap.containsKey(sArray[i])) {
					tMap.put(sArray[i], 0);
				}
				tMap.put(sArray[i], tMap.get(sArray[i]) + 1);
				end = i;
			} else {
				end = i;
			}

			while (start < end) {
				if (!tMap.containsKey(sArray[start])) {
					start++;
				} else if ((tMap.containsKey(sArray[start]) && tMap.get(sArray[start]) > sMap.get(sArray[start]))) {
					tMap.put(sArray[start], tMap.get(sArray[start]) - 1);
					start++;
				} else {
					break;
				}
			}
			found = true;

			for(char c: sMap.keySet()) {
				if(tMap.get(c) == null || tMap.get(c) < sMap.get(c)) {
					found = false;
				}
			}
			if (found && (min.equals("") || min.length() > end - start + 1)) {
				min = s.substring(start, end + 1);
			}
		}

		return min;

	}
}
