import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         21 Aug 2021 5:06:42 PM
 * 
 *         https://leetcode.com/problems/shortest-path-in-a-hidden-grid/
 * 
 */
public class ShortestPathInAHiddenGrid {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, -1, 1, 1 },
				{ 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 } };
		GridMaster master = new GridMaster(3, 16, grid);
		System.out.println(new ShortestPathInAHiddenGrid().findShortestPath(master));
	}

	public int findShortestPath(GridMaster master) {

		Set<Point> visited = new HashSet<>();
		int[][] grid = new int[1001][1001];
		grid[500][500] = -1;
		buildGraph(master, 500, 500, visited, grid);
		visited.clear();
		return bfs(grid);

	}

	private int bfs(int[][] grid) {

		int dist = 0;
		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(500, 500));
		grid[500][500] = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Point cur = queue.poll();
				for (int[] dir : dirs) {
					int newX = cur.x + dir[0];
					int newY = cur.y + dir[1];
					Point newPoint = new Point(newX, newY);
					if (grid[newX][newY] == 2) {
						return dist + 1;
					}
					if (grid[newX][newY] != 0) {
						queue.offer(newPoint);
						grid[newX][newY] = 0;
					}
				}
			}
			dist++;
		}

		return -1;
	}

	private void buildGraph(GridMaster master, int x, int y, Set<Point> visited, int[][] grid) {

		if (master.isTarget()) {
			grid[x][y] = 2;
		} else if (grid[x][y] != -1) {
			grid[x][y] = 1;
		}

		visited.add(new Point(x, y));

		if (master.canMove('D')) {
			if (!visited.contains(new Point(x + 1, y))) {
				master.move('D');
				buildGraph(master, x + 1, y, visited, grid);
				master.move('U');
			}
		} else {
			grid[x + 1][y] = 0;
			visited.contains(new Point(x + 1, y));

		}

		if (master.canMove('U')) {
			if (!visited.contains(new Point(x - 1, y))) {
				master.move('U');
				buildGraph(master, x - 1, y, visited, grid);
				master.move('D');
			}
		} else {
			grid[x - 1][y] = 0;
			visited.contains(new Point(x - 1, y));
		}

		if (master.canMove('R')) {
			if (!visited.contains(new Point(x, y + 1))) {
				master.move('R');
				buildGraph(master, x, y + 1, visited, grid);
				master.move('L');
			}
		} else {
			grid[x][y + 1] = 0;
			visited.contains(new Point(x, y + 1));
		}

		if (master.canMove('L')) {
			if (!visited.contains(new Point(x, y - 1))) {
				master.move('L');
				buildGraph(master, x, y - 1, visited, grid);
				master.move('R');
			}
		} else {
			grid[x][y - 1] = 0;
			visited.contains(new Point(x, y - 1));
		}

	}

}

class Point {

	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

class GridMaster {
	int x = 0;
	int y = 0;
	int tx, ty;
	int[][] grid;

	public GridMaster(int sx, int sy, int[][] grid) {
		this.x = sx;
		this.y = sy;
		this.grid = grid;
	}

	boolean canMove(char direction) {
		if (direction == 'R') {
			return y < grid[0].length - 1 && grid[x][y + 1] != 0;
		}
		if (direction == 'L') {
			return y > 0 && grid[x][y - 1] != 0;
		}
		if (direction == 'U') {
			return x > 0 && grid[x - 1][y] != 0;
		}
		if (direction == 'D') {
			return x < grid.length - 1 && grid[x + 1][y] != 0;
		}
		return false;

	}

	void move(char direction) {
		if (canMove(direction)) {
			if (direction == 'R') {
				y++;
			}
			if (direction == 'L') {
				y--;
			}
			if (direction == 'U') {
				x--;
			}
			if (direction == 'D') {
				x++;
			}
		}

	}

	boolean isTarget() {
		return grid[x][y] == 2;
	}
}