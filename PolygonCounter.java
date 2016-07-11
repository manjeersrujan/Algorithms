

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PolygonCounter {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = null;
			int sq = 0;
			int rect = 0;
			int poly = 0;
			while (true) {
				s = br.readLine();

				if (s == null || s.equals("")) {
					break;
				}
				String[] sideStrings = s.split(" ");
				int[] sides = new int[sideStrings.length];
				for (int i = 0; i < sideStrings.length; i++) {
					sides[i] = Integer.parseInt(sideStrings[i]);
				}
				if (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0 || sides[3] <= 0) {
					poly++;
				} else if (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]) {
					sq++;
				} else if (sides[0] == sides[2] && sides[1] == sides[3]) {
					rect++;
				} else {
					poly++;
				}

			}

			System.out.println(sq + " " + rect + " " + poly);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
