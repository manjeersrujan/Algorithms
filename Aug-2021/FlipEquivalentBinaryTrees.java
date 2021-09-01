
/**
 * @author smanjeer
 *
 *         20 Aug 2021 2:46:01 AM
 * 
 *         https://leetcode.com/problems/flip-equivalent-binary-trees/
 * 
 */
public class FlipEquivalentBinaryTrees {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (!isSame(root1, root2)) {
			return false;
		}

		if (isSame(root1.left, root2.left) && isSame(root1.right, root2.right)) {
			return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
		}
		if ((isSame(root1.left, root2.right) && isSame(root1.right, root2.left))) {
			return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
		}

		return false;
	}

	private boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else {
			return root1.val == root2.val;
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
