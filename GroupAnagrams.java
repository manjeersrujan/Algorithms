import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> groupsMap = new HashMap<>();
		for(String str: strs) {
			char[] cArr = str.toCharArray();
			Arrays.sort(cArr);
			String aKey = String.valueOf(cArr);
			List<String> value = groupsMap.get(aKey);
			if(value == null) {
				value = new ArrayList<String>();
				value.add(str);
				groupsMap.put(aKey, value);
			}else {
				value.add(str);
			}
		}
		
		return new ArrayList<List<String>>(groupsMap.values());

	}
}
