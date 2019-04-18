
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Result {
	int length;
	int max;
}

public class DiameterOfBTree {
	public int diameterOfBinaryTree(TreeNode root) {
		Result rootResult = getResult(root);
		return rootResult.max;
	}

	private Result getResult(TreeNode root) {
		Result r = new Result();
		if (root == null) {
			r.length = 0;
			r.max = 0;
			return r;
		}

		if (root.left == null && root.right == null) {
			r.length = 1;
			r.max = 1;
			return r;
		}
		
		Result left = getResult(root.left);
		Result right = getResult(root.right);

		int max = Math.max(left.max, right.max);
		if (left.length + right.length + 2 > max) {
			r.length = Math.max(left.length, right.length)+1;
			r.max = left.length + right.length + 2;
			return r;
		} else {
			r.length = Math.max(left.length, right.length)+1;
			r.max = max;
			return r;
		}
	}
}
