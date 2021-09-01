
/**
 * @author smanjeer
 *
 *         28 Jul 2021 9:44:57 AM
 * 
 *         https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * 
 */
public class MaximumPointsYouCanObtainfromCards {

	public static void main(String[] args) {
		int[] test = { 57, 62, 46, 22, 9, 23, 14, 24, 33, 10, 80, 95, 6, 54, 52, 12, 70, 7, 33, 98, 74, 17, 61, 20,
				81 };
		int k = 11;

		System.out.println(new MaximumPointsYouCanObtainfromCards().maxScore(test, k));

	}

	public int maxScore(int[] cardPoints, int k) {

		int window = cardPoints.length - k;
		int windowSum = 0;
		int curWindow = 0;
		int totalSum = 0;
		int minWindowSum = Integer.MAX_VALUE;

		for (int i = 0; i < cardPoints.length; i++) {
			totalSum = totalSum + cardPoints[i];
			if (curWindow < window) {
				curWindow++;
				windowSum = windowSum + cardPoints[i];
			} else {
				if (windowSum < minWindowSum) {
					minWindowSum = windowSum;
				}
				windowSum = windowSum + cardPoints[i] - cardPoints[i - window];
			}
		}
		if (windowSum < minWindowSum) {
			minWindowSum = windowSum;
		}

		return totalSum - minWindowSum;

	}

}
