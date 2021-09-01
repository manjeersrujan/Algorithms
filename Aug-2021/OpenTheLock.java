import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         22 Aug 2021 3:31:13 AM
 * 
 *         https://leetcode.com/problems/open-the-lock/
 * 
 */
public class OpenTheLock {

	public int openLock(String[] deadends, String target) {

		Queue<String> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> deMap = new HashSet<>();
		for (String de : deadends) {
			deMap.add(de);
		}
		int dist = 0;
		if (deMap.contains("0000") || deMap.contains(target)) {
			return -1;
		}
		q.add("0000");
		visited.add("0000");
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String cur = q.poll();
				if (cur.equals(target)) {
					return dist;
				}
				List<String> edges = getEdges(cur, deMap);
				for (String edge : edges) {
					if (!visited.contains(edge)) {
						q.add(edge);
						visited.add(edge);
					}
				}
			}
			dist++;
		}
		return -1;
	}

	private List<String> getEdges(String cur, Set<String> deMap) {
		List<String> list = new ArrayList<String>();
		char[] charArray = cur.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			int inc = c == '9' ? '0' : c + 1;
			int dec = c == '0' ? '9' : c - 1;
			System.out.println(cur);
			String edge = cur.substring(0, i) + (char)inc + cur.substring(i + 1, 4);
			if (!deMap.contains(edge)) {
				list.add(edge);
			}

			edge = cur.substring(0, i) + (char)dec + cur.substring(i + 1, 4);
			if (!deMap.contains(edge)) {
				list.add(edge);
			}

		}
		return list;
	}

}
