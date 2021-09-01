import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         29 Jul 2021 11:29:45 AM
 * 
 *         https://leetcode.com/problems/delete-nodes-and-return-forest/
 * 
 */
public class DeleteNodesAndReturnForest2 {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		if (root == null) {
			return new ArrayList<TreeNode>();
		}

		Set<Integer> delMap = new HashSet<>();
		for (int i : to_delete) {
			delMap.add(i);
		}
		List<TreeNode> forests = new ArrayList<>();

		if (!delMap.contains(root.val)) {
			forests.add(root);
		}
		traverseAndFillMap(root, null, forests, delMap, true);
		return forests;
	}

	private void traverseAndFillMap(TreeNode root, TreeNode parent, List<TreeNode> forests, Set<Integer> delMap,
			boolean isLeft) {

		if (root == null) {
			return;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;

		if (delMap.contains(root.val)) {

			if (root.left != null && !delMap.contains(root.left.val)) {
				forests.add(root.left);
			}
			if (root.right != null && !delMap.contains(root.right.val)) {
				forests.add(root.right);
			}

			if (parent != null) {
				if (isLeft) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
		}
		traverseAndFillMap(left, root, forests, delMap, true);
		traverseAndFillMap(right, root, forests, delMap, false);

	}

}
