import java.util.HashSet;
import java.util.Set;

/**
 * @author smanjeer
 *
 *         29 Aug 2021 11:47:02 PM
 * 
 *         https://leetcode.com/problems/minimum-area-rectangle/
 * 
 */
public class MinimumAreaRectangle {
	public int minAreaRect(int[][] points) {
		Set<String> set = new HashSet<>();
		int n = points.length;
		for (int i = 0; i < n; i++) {
			set.add(points[i][0] + " " + points[i][1]);
		}
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
					continue;
				}

				String point1 = points[i][0] + " " + points[j][1];
				String point2 = points[j][0] + " " + points[i][1];
				if (set.contains(point1) && set.contains(point2)) {
					int temp = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
					res = Math.min(res, temp);
				}
			}
		}

		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
