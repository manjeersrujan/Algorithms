import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         18 Aug 2021 6:38:23 AM
 * 
 *         https://leetcode.com/problems/generate-parentheses/
 * 
 */
public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		genParMap(n, 0, 0, "", list);
		return list;
	}

	public void genParMap(int n, int l, int r, String p, List<String> list) {
		if (l > n || r > n || r > l) {
			return;
		}

		if (l == r && r == n) {
			list.add(p);
		}
		genParMap(n, l + 1, r, p + "(", list);
		genParMap(n, l, r + 1, p + ")", list);
	}

}
