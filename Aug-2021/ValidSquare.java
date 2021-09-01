
/**
 * @author smanjeer
 *
 *         29 Jul 2021 3:56:20 AM
 * 
 *         https://leetcode.com/problems/valid-square/
 * 
 */
public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		return check(p1, p2, p3, p4) || check(p1, p4, p2, p3) || check(p1, p2, p4, p3);
	}

	private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
		int s1 = getDistance(p1, p2);
		int s2 = getDistance(p2, p3);
		int s3 = getDistance(p3, p4);
		int s4 = getDistance(p4, p1);

		int d1 = getDistance(p1, p3);
		int d2 = getDistance(p2, p4);

		return ((s1 > 0) && (s1 == s2) && (s2 == s3) && (s3 == s4) && (d1 > 0) && (d1 == d2));
	}

	private int getDistance(int[] p1, int[] p2) {
		return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
	}
}
