import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfRanges {

	public static void main(String[] args) {
		int[][] a = { { 3, 5 }, { 9, 20 } };
		int[][] b = { { 4, 5 }, { 7, 10 }, { 11, 12 }, { 14, 15 }, { 16, 20 } };

		int[][] c = new IntersectionOfRanges().intervalIntersection(a, b);

		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i][0] +"," + c[i][1]);

		}
	}

	public int[][] intervalIntersection(int[][] A, int[][] B) {

		int ca = 0;
		int cb = 0;

		List<int[]> list = new ArrayList<>();

		while (ca < A.length && cb < B.length) {

			if ((A[ca][1] < B[cb][0])) {
				ca++;
			} else if (A[ca][1] == B[cb][0]) {
				int[] ar = { A[ca][1], A[ca][1] };
				list.add(ar);
				ca++;
			} else if (A[ca][0] > B[cb][1]) {
				cb++;
			} else if (A[ca][0] == B[cb][1]) {
				int[] ar = { A[ca][0], A[ca][0] };
				list.add(ar);
				cb++;
			} else if (A[ca][0] <= B[cb][0] && A[ca][1] <= B[cb][1]) {
				int[] ar = { B[cb][0], A[ca][1] };
				list.add(ar);
				ca++;
			} else if (A[ca][0] >= B[cb][0] && A[ca][1] <= B[cb][1]) {
				int[] ar = { A[ca][0], A[ca][1] };
				list.add(ar);
				ca++;
			} else if (A[ca][0] >= B[cb][0] && A[ca][1] >= B[cb][1]) {
				int[] ar = { A[ca][0], B[cb][1] };
				list.add(ar);
				cb++;
			} else if (A[ca][0] <= B[cb][0] && A[ca][1] >= B[cb][1]) {
				int[] ar = { B[cb][0], B[cb][1] };
				list.add(ar);
				cb++;
			} else if (A[ca][0] >= B[cb][0] && A[ca][1] <= B[cb][1]) {
				int[] ar = { A[ca][0], A[ca][1] };
				list.add(ar);
				ca++;
			}

		}

		return list.toArray(new int[list.size()][]);

	}
}
