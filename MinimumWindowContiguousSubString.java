/*
 * 
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:

Input: 
S = "abcdebdde", T = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of T in the window must occur in order.
 

Note:

All the strings in the input will only contain lowercase letters.
The length of S will be in the range [1, 20000].
The length of T will be in the range [1, 100].
 
 */
public class MinimumWindowContiguousSubString {

	public static void main(String[] args) {
		System.out.println(new MinimumWindowContiguousSubString().minWindow("cnhczmccqouqadqtmjjzl", "mm"));
	}

	public String minWindow(String S, String T) {
		if (S == null || S.length() <= 0 || T == null || T.length() <= 0) {
			return "";
		}

		char[] s = S.toCharArray(), t = T.toCharArray();
		int sindex = 0, tindex = 0, slen = s.length, tlen = t.length, start = -1, len = slen;

		while (sindex < slen) {
			if (s[sindex] == t[tindex]) {
				tindex++;
				if (tindex == tlen) {
					int end = sindex + 1;
					while (--tindex >= 0) {
						while (s[sindex--] != t[tindex]);
					}
					if (len > end - sindex) {
						len = end - sindex;
						start = sindex;
					}
					tindex++;
                    sindex++;
				}

			}
			sindex++;
		}
		return start == -1 ? "" : S.substring(start, start + len);

	}
}
