/**
 * @author smanjeer
 *
 *         31 Aug 2021 4:33:38 AM
 * 
 * 
 */
public class TwoSumIIInputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		int l = 0, r = numbers.length - 1;
		while (l < r) {
			if (numbers[l] + numbers[r] > target) {
				r--;
			} else if (numbers[l] + numbers[r] < target) {
				l++;
			} else {
				int[] res = { l, r };
				return res;
			}
		}

		return null;
	}
}
