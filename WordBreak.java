import java.util.List;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

 */
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		int[] cache = new int[s.length()];
		return wordBreak(s,wordDict, cache);

	}
	
	private boolean wordBreak(String s, List<String> wordDict, int[] cache) {
		if(s==null || s.length() ==0) {
			return true;
		}
		if(cache[s.length()] == 1) {
			return true;
		} else if(cache[s.length()] == -1) {
			return false;
		}
		for(int i=0;i<s.length();i++) {
			if(wordDict.contains(s.substring(0, i+1))) {
				if(i+1 == s.length()) {
					cache[cache.length - s.length()]= 1;
					return true;
				}
				String substring = s.substring(i+1, s.length());
				boolean result  = wordBreak(substring, wordDict, cache);
				cache[cache.length - i] = result ? 1 : -1;
				if(result) {
					return true;
				}
			}
		}
		return false;
	}
}
