public class DistanceFromCapitalFinder {

	int count = 0;

	public int[] solution(int[] T) {
		int[] output = new int[T.length - 1];
		boolean[] visited = new boolean[T.length];

		int capital = -1;
		for (int i = 0; i < T.length; i++) {
			if (i == T[i]) {
				capital = i;
				visited[i] = true;
				break;
			}
		}

		findCities(T, capital, output, visited, 0);

		return output;

	}

	private void findCities(int[] T, int capital, int[] output, boolean[] visited, int depth) {

		for (int i = 0; i < T.length; i++) {
			count++;
			if (!visited[i]) {
				if (T[i] == capital) {
					visited[i] = true;
					output[depth]++;
					findCities(T, i, output, visited, depth + 1);
				}
			}

		}
	}

	public static void main(String[] args) {
		int[] A = new int[] { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };

		DistanceFromCapitalFinder distanceFromCapitalFinder = new DistanceFromCapitalFinder();
		
		int[] solution = distanceFromCapitalFinder.solution(A);
		for (int i : solution) {
			System.out.println(i);
		}
	}

}
