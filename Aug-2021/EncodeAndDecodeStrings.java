import java.util.ArrayList;
import java.util.List;

/**
 * @author smanjeer
 *
 *         20 Aug 2021 5:29:50 AM
 * 
 *         https://leetcode.com/problems/encode-and-decode-strings/
 * 
 */
public class EncodeAndDecodeStrings {

	char del = ':';

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuffer sb = new StringBuffer("");
		for (String s : strs) {
			sb.append(s.length()).append(del).append(s);
		}
		return sb.toString();

	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.equals("")) {
			return res;
		}
		StringBuffer sb = new StringBuffer(s);
		int index = 0;
		while (index < sb.length() - 1) {
			String len = "";
			char c = sb.charAt(index);
			while (c != del) {
				len = len + c;
				index++;
				c = sb.charAt(index);
			}
			index++;
			int lenInt = Integer.parseInt(len);
			if (lenInt == 0) {
				res.add("");
			} else {
				res.add(sb.substring(index, index + lenInt));
			}
			index = index + lenInt;
		}

		return res;
	}

}
