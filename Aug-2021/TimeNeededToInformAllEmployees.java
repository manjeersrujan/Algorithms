import java.util.ArrayList;
import java.util.List;

/**
 * @author smanjeer
 *
 *         19 Aug 2021 2:12:37 AM
 * 
 *         https://leetcode.com/problems/time-needed-to-inform-all-employees/
 * 
 */
public class TimeNeededToInformAllEmployees {

	public static void main(String[] args) {
		int[] man = { 2, 2, -1, 2, 2, 2 };
		int[] inf = { 0, 0, 1, 0, 0, 0 };

		System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(6, 2, man, inf));
	}

	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		Node[] nMap = new Node[n];
		Node head = new Node(headID, -1, informTime[headID]);
		for (int i = 0; i < manager.length; i++) {

			if (manager[i] == -1) {
				continue;
			}
			if (nMap[i] == null) {
				nMap[i] = new Node(i, manager[i], informTime[i]);
			}

			if (manager[i] == headID) {
				head.subs.add(nMap[i]);
				continue;
			}

			if (nMap[manager[i]] == null) {
				nMap[manager[i]] = new Node(manager[i], manager[manager[i]], informTime[manager[i]]);
			}

			nMap[manager[i]].subs.add(nMap[i]);
		}

		return traverseForMaxTime(head);

	}

	private int traverseForMaxTime(Node node) {
		if (node == null || node.subs.size() == 0) {
			return 0;
		}

		int maxTime = 0;
		for (Node sub : node.subs) {
			int infTime = traverseForMaxTime(sub);
			maxTime = Math.max(maxTime, infTime);
		}

		return maxTime + node.t;
	}

	class Node {
		public Node(int id, int mId, int t) {
			super();
			this.id = id;
			this.mId = mId;
			this.t = t;
		}

		int id;
		int mId;
		int t;
		List<Node> subs = new ArrayList<>();

	}

}
