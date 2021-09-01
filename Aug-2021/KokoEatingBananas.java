import java.util.Arrays;

/**
 * @author smanjeer
 *
 *         28 Jul 2021 10:52:34 PM
 * 
 *         https://leetcode.com/problems/koko-eating-bananas/
 * 
 */
public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] test = { 3, 3, 3, 4, 3, 5, 3, 3 };
		int[] test1 = { 3, 6, 7, 11 };

		System.out.println(new KokoEatingBananas().minEatingSpeed(test, 8));
	}

	public int minEatingSpeed(int[] piles, int H) {
		int lo = 1;
		int hi = Arrays.stream(piles).max().getAsInt();
		while (lo < hi) {
			int mi = (lo + hi) / 2;
			if (!possible(piles, H, mi))
				lo = mi + 1;
			else
				hi = mi;
		}

		return lo;
	}

	// Can Koko eat all bananas in H hours with eating speed K?
	public boolean possible(int[] piles, int H, int K) {
		int time = 0;
		for (int p : piles)
			time += (p - 1) / K + 1;
		return time <= H;
	}
}
