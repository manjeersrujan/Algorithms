import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class AllPossibleWords {
	static Map<String, List<String>> dMap = new HashMap<>();
	
	static {
		dMap.put("2", Arrays.asList("a", "b", "c"));
		dMap.put("3", Arrays.asList("d", "e", "f"));
		dMap.put("4", Arrays.asList("g", "h", "i"));
		dMap.put("5", Arrays.asList("j", "k", "l"));
		dMap.put("6", Arrays.asList("m", "n", "o"));
		dMap.put("7", Arrays.asList("p", "q", "r", "s"));
		dMap.put("8", Arrays.asList("t", "u", "v"));
		dMap.put("9", Arrays.asList("w", "x", "y", "z"));

		
	}
	
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() <= 0) {
			return new ArrayList<>();
		}
		
		if(digits.length() ==1) {
			return dMap.get(digits);
		}
		List<String> letterCombinations = letterCombinations(digits.substring(1, digits.length()));
		List<String> result = new ArrayList<>();
		for(String str: letterCombinations) {
			for(String str1: dMap.get(digits.substring(0,1))) {
				result.add(str1+str);
			}
		}
		return result;
	}
}
