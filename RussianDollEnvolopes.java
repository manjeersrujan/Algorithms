import java.util.Arrays;
import java.util.Comparator;

/*
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */

public class RussianDollEnvolopes {

	public int maxEnvelopes(int[][] envelopes) {

		if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1 == o2) {
					return 0;
				}
				if (o1[0] != o2[0]) {
					return o1[0] - o2[0];
				} else if (o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return 0;
				}
			}
		});

		int[] dp = new int[envelopes.length];
		dp[0] = 1;
		int finMax = 1;
		for (int i = 1; i < envelopes.length; i++) {
			int max = 1;
			for (int j = i; j >= 0; j--) {
				if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
					if (max < dp[j] + 1) {
						max = dp[j] + 1;
					}
				}
			}
			dp[i] = max;
			if (finMax < max) {
				finMax = max;
			}
		}
		return finMax;
	}
}
