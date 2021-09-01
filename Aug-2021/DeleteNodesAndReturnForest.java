import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         29 Jul 2021 11:29:45 AM
 * 
 *         https://leetcode.com/problems/delete-nodes-and-return-forest/
 * 
 */
public class DeleteNodesAndReturnForest {

	public List<TreeNode1> delNodes(TreeNode1 root, int[] to_delete) {

		Map<Integer, TreeNode1[]> nodeMap = new HashMap<>();
		traverseAndFillMap(nodeMap, root, null);
		Set<TreeNode1> forests = new HashSet<>();
		forests.add(root);
		for (int i : to_delete) {
			if (nodeMap.containsKey(i)) {
				TreeNode1[] nodes = nodeMap.get(i);
				if (forests.contains(nodes[1])) {
					forests.remove(nodes[1]);
				} else if (nodes[0] != null) {
					if (nodes[0].left == nodes[1]) {
						nodes[0].left = null;
					}
					if (nodes[0].right == nodes[1]) {
						nodes[0].right = null;
					}
				}
				if(nodes[1].left!= null) {forests.add(nodes[1].left);}
				if(nodes[1].right!= null) {forests.add(nodes[1].right);}
				nodes[1].left = null;
				nodes[1].right = null;
				nodeMap.remove(i);
			}
		}

		return new ArrayList<TreeNode1>(forests);
	}

	private void traverseAndFillMap(Map<Integer, TreeNode1[]> nodeMap, TreeNode1 root, TreeNode1 parent) {

		if (root == null) {
			return;
		}
		TreeNode1[] value = { parent, root };
		nodeMap.put(root.val, value);
		traverseAndFillMap(nodeMap, root.left, root);
		traverseAndFillMap(nodeMap, root.right, root);

	}

}

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	}

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
