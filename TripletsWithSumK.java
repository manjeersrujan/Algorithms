import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsWithSumK {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 7, 6, 1, 8 };
		int[][] tripletsWithSumK = new TripletsWithSumK().getTripletsWithSumK(nums, 15);
		for (int i = 0; i < tripletsWithSumK.length; i++) {
			for (int j = 0; j < tripletsWithSumK[i].length; j++) {
				System.out.print(tripletsWithSumK[i][j] + ", ");
			}
			System.out.println();
		}
	}

	public int[][] getTripletsWithSumK(int[] nums, int k) {

		if (nums == null || nums.length < 3) {
			return new int[0][0];
		}
		List<int[]> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int start = i + 1;
			int end = (i == nums.length - 1) ? nums.length - 2 : nums.length - 1;

			while (start < end) {
				if (nums[start] + nums[end] == k - nums[i]) {
					int[] curResult = { nums[i], nums[start], nums[end] };
					result.add(curResult);
					start++;
					end--;
				} else if (nums[start] + nums[end] < k - nums[i]) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result.toArray(new int[result.size()][3]);
	}

}
