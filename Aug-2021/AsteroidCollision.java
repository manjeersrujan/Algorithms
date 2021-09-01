import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author smanjeer
 *
 *         18 Jul 2021 10:16:50 PM
 * 
 *         https://leetcode.com/problems/asteroid-collision/
 * 
 */
public class AsteroidCollision {

	public int[] asteroidCollision(int[] asteroids) {

		Stack<Integer> st = new Stack<>();
		List<Integer> list = new ArrayList<>();

		int i = 0;
		while (i < asteroids.length) {
			int num = asteroids[i];

			while (!st.isEmpty()) {
				if (num < 0 && st.peek() > 0) {
					int top = st.pop();
					if (Math.abs(num) < top) {
						num = top;
					} else if (Math.abs(num) == top) {
						num = 0;
					}
				} else {
					break;
				}
			}

			i++;
			if (num != 0) {
				st.push(num);
			}
		}

		int[] res = new int[st.size()];
		for (int j = res.length - 1; j >= 0; j--) {
			res[j] = st.pop();
		}
		return res;

	}

}
