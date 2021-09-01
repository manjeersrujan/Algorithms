
/**
 * @author smanjeer
 *
 *         19 Aug 2021 2:55:25 AM
 * 
 *         https://leetcode.com/problems/rle-iterator/
 * 
 */
public class RLEIterator {

	private int curIndex = 0;
	private int curCount = 0;
	private int[] encoding;

	public RLEIterator(int[] encoding) {
		this.encoding = encoding;
	}

	public int next(int n) {
		int res = -1;
		while (n != 0) {
			if (curIndex > encoding.length - 2 || (curIndex == encoding.length - 2 && curCount >= encoding[curIndex])) {
				return -1;
			}
			if (n > encoding[curIndex] - curCount) {
				n = n - (encoding[curIndex] - curCount);
				curIndex = curIndex + 2;
				curCount = 0;
			} else if (n < encoding[curIndex] - curCount) {
				curCount = curCount + n;
				res = encoding[curIndex + 1];
				break;
			} else {
				res = encoding[curIndex + 1];
				curIndex = curIndex + 2;
				curCount = 0;
				break;
			}
		}

		return res;
	}
}
