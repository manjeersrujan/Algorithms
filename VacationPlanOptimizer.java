/**
 * @author Manjeer on Jul 12, 2016
 *
 */
public class VacationPlanOptimizer {

	public int solution(int[] A) {

		/*
		 * if 1 day
		 */
		boolean[] monthCost = new boolean[30];
		for (int i = 0; i < monthCost.length; i++) {
			monthCost[i] = false;
		}
		return findCost(A, monthCost, 0);

	}

	int findCost(int[] A, boolean[] month, int index) {

		if (A.length <= index) {
			return 0;
		}
		if (month[A[index] - 1]) {

			int findCost = findCost(A, month, index + 1);
			return findCost;
		} else {
			/*
			 * dayFare cost
			 */
			boolean[] monthCost = new boolean[month.length];

			for (int i = 0; i < month.length; i++) {
				monthCost[i] = month[i];
			}

			monthCost[A[index] - 1] = true;
			int dayFare = 2 + findCost(A, monthCost, index + 1);

			/*
			 * weekFare cost
			 */

			monthCost = new boolean[month.length];

			for (int i = 0; i < month.length; i++) {
				monthCost[i] = month[i];
			}

			for (int i = A[index] - 1, count = 0; i < A.length && count < 7; i++, count++) {
				monthCost[i] = true;
			}
			int weekFare = 7 + findCost(A, monthCost, index + 1);

			/*
			 * if 30 day
			 */

			int monthFare = 25;

			return Math.min(monthFare, Math.min(dayFare, weekFare));

		}
	}

	public static void main(String[] args) {
		int[] A = new int[8];

		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		A[4] = 8;
		A[5] = 14; 
		A[6] = 21;
		A[7] = 29;

		System.out.println(new VacationPlanOptimizer().solution(A));
	}

}
