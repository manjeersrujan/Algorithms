import java.util.HashMap;
import java.util.Map;

/**
 * @author smanjeer
 *
 *         15 Aug 2021 3:04:26 AM
 * 
 *         https://leetcode.com/problems/longest-absolute-file-path/
 * 
 */
public class LongestAbsoluteFilePath {

	public int lengthLongestPath(String input) {

		String[] lines = input.split("\n");
		Map<Integer, String> dirs = new HashMap<>();
		int res = 0;
		for (String line : lines) {
			int tabs = 0;
			int i = 0;
			while (line.charAt(i) == '\t') {
				tabs++;
				i++;
			}
			String name = line.substring(i);
			String parent = dirs.get(tabs - 1);
			String aName = (parent == null) ? name : parent + "/" + name;

			if (!name.contains(".")) {
				dirs.put(tabs, aName);
			} else if (res < aName.length()) {
				res = aName.length();
			}
		}
		return res;

	}
}
