import java.util.Arrays;

/*
 * https://leetcode.com/problems/asteroid-collision/
 */
import java.util.Stack;

public class AstroidCollision {
	public static void main(String[] args) {
		int[] asteroids = { 10, 2, -5 };
		int[] asteroidCollision = new AstroidCollision().asteroidCollision(asteroids);
		for (int i : asteroidCollision) {
			System.out.print(i + ", ");
		}
	}

	class Node {
		int data;
		Boolean right = null;
	}

	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length <= 1) {
			return asteroids;
		}

		Stack<Integer> st = new Stack<>();
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
