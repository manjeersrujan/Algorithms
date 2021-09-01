
/**
 * @author smanjeer
 *
 *         19 Aug 2021 3:44:29 AM
 * 
 *         https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * 
 */
public class LongestLineOfConsecutiveOneInMatrix {

	public int longestLine(int[][] mat) {

		int max = 0;
		for (int i = 0; i < mat[0].length; i++) {
			int vertLine = longLine(mat, 0, i, 1, 0);
			int leftDiag = longLine(mat, 0, i, 1, -1);
			int rightDiag = longLine(mat, 0, i, 1, 1);
            int botRightDia = longLine(mat, mat.length-1, i, -1, 1);


			max = Math.max(max, Math.max(Math.max(vertLine, leftDiag), Math.max(rightDiag,botRightDia)));
		}

		for (int i = 0; i < mat.length; i++) {
			int horLine = longLine(mat, i, 0, 0, 1);
			int upDiag = longLine(mat, i, 0, -1, 1);
			int downDiag = longLine(mat, i, 0, 1, 1);

			max = Math.max(max, Math.max(Math.max(horLine, upDiag), downDiag));
		}

		return max;
	}

	private int longLine(int[][] mat, int i, int j, int rOff, int cOff) {
		int maxLine = 0;
		int count = 0;
		while (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
			if (mat[i][j] == 1) {
				count++;
			} else {
				maxLine = Math.max(maxLine, count);
				count = 0;
			}
			i = i + rOff;
			j = j + cOff;
		}
		
		maxLine = Math.max(maxLine, count);
		return maxLine;
	}

}
