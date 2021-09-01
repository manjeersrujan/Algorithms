import java.util.LinkedList;
import java.util.Queue;

/**
 * @author smanjeer
 *
 *         30 Aug 2021 2:55:51 AM
 * 
 *         https://leetcode.com/problems/complete-binary-tree-inserter/
 * 
 */
public class CompleteBinaryTreeInserter {

	TreeNode root;

	public CompleteBinaryTreeInserter(TreeNode root) {
		this.root = root;
	}

	public int insert(int val) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();

			TreeNode left = cur.left;
			TreeNode right = cur.right;
			if (left == null) {
				cur.left = new TreeNode(val);
				return cur.val;
			}
			if (right == null) {
				cur.right = new TreeNode(val);
				return cur.val;
			}
			queue.offer(left);
			queue.offer(right);
		}
		return -1;
	}

	public TreeNode get_root() {
		return root;
	}

	private class TreeNode {
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
}
