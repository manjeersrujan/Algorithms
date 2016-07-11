

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSeqProblem {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");

			int prev = Integer.MIN_VALUE;
			for (int i = 0; i < s.length; i++) {

				int cur = Integer.parseInt(s[i]);
				if (prev == Integer.MIN_VALUE) {
					prev = cur;
					System.out.print(prev + " ");
					continue;
				}

				int diff = cur - prev;

				if (diff >= 128 || diff <= -128) {
					System.out.print("-128 " + diff + " ");
				} else {
					System.out.print(diff + " ");
				}
				prev = cur;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
