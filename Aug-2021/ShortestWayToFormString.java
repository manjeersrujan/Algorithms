import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author smanjeer
 *
 *         20 Aug 2021 6:06:05 AM
 * 
 *         https://leetcode.com/problems/shortest-way-to-form-string/
 * 
 */
public class ShortestWayToFormString {

	public static void main(String[] args) {
		new ShortestWayToFormString().shortestWay("abc", "acdbc");
	}

	public int shortestWay(String source, String target) {
		Map<Character, TreeSet<Integer>> map = new HashMap<>();
		char[] ca = source.toCharArray();
		for (int i = 0; i < ca.length; i++) {
			TreeSet<Integer> ts = map.get(ca[i]);
			if (ts == null) {
				ts = new TreeSet<Integer>();
				map.put(ca[i], ts);
			}
			ts.add(i);
		}
		int res = 1;
		int index = -1;

		char[] cat = target.toCharArray();
		for (int i = 0; i < cat.length; i++) {
			TreeSet<Integer> treeSet = map.get(cat[i]);
			if (treeSet == null) {
				return -1;
			}
			Integer higher = treeSet.higher(index);
			if (higher == null) {
				res++;
				index = -1;
				i--;
			} else {
				index = higher;
			}
		}

		return res;

	}

}
