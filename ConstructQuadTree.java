/*
 * https://leetcode.com/problems/construct-quad-tree/
 */

// Definition for a QuadTree node.
class Node {
	public boolean val;
	public boolean isLeaf;
	public Node topLeft;
	public Node topRight;
	public Node bottomLeft;
	public Node bottomRight;

	public Node() {
	}

	public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
		val = _val;
		isLeaf = _isLeaf;
		topLeft = _topLeft;
		topRight = _topRight;
		bottomLeft = _bottomLeft;
		bottomRight = _bottomRight;
	}
};

class ConstructQuadTree {
	public Node construct(int[][] grid) {
		return construct(grid, 0, 0, grid.length - 1, grid.length - 1);
	}

	private Node construct(int[][] grid, int i, int j, int k, int l) {

		if (i == k && j == l) {
			return new Node(grid[i][j] == 1 ? true : false, true, null, null, null, null);
		}
		if (checkIfSame(grid, i, j, k, l) == 1) {
			return new Node(true, true, null, null, null, null);
		} else if (checkIfSame(grid, i, j, k, l) == 0) {
			return new Node(false, true, null, null, null, null);
		} else {
			Node lT = construct(grid, i, j, (i + k) / 2, (j + l) / 2);
			Node lB = construct(grid, ((i + k) / 2) + 1, j, k, (j + l) / 2);
			Node rT = construct(grid, i, ((j + l) / 2) + 1, (i + k) / 2, l);
			Node rB = construct(grid, ((i + k) / 2) + 1, ((j + l) / 2) + 1, k, l);
			return new Node(true, false, lT, rT, lB, rB);
		}
	}

	/**
	 * @param grid
	 * @param leftTop
	 * @param rightBottom
	 * @return
	 * 
	 * 		1 -> all 1 0 -> all 0 -1 -> not uniform
	 */
	private int checkIfSame(int[][] grid, int leftTopX, int leftTopY, int rightBottomX, int rightBottomY) {

		int val = grid[leftTopX][leftTopY];
		for (int i = leftTopX; i <= rightBottomX; i++) {
			for (int j = leftTopY; j <= rightBottomY; j++) {
				if (grid[i][j] != val) {
					return -1;
				}
			}
		}
		return val;
	}
}
