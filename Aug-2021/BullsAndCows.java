/**
 * @author smanjeer
 *
 *         18 Aug 2021 4:44:14 AM
 * 
 *         https://leetcode.com/problems/bulls-and-cows/
 * 
 */
public class BullsAndCows {
	public String getHint(String secret, String guess) {

		int[] sm = new int[10];
		int[] gm = new int[10];
		int bulls = 0;
		int cows = 0;
		char[] sca = secret.toCharArray();
		for (char c : sca) {
			sm[c - '0']++;
		}

		char[] gca = guess.toCharArray();
		for (char c : gca) {
			gm[c - '0']++;
		}

		for (int i = 0; i < sca.length; i++) {
			if (i < gca.length) {
				if (sca[i] == gca[i]) {
					sm[sca[i] - '0']--;
					gm[sca[i] - '0']--;
					bulls++;
				}
			} else {
				break;
			}
		}

		for (int i = 0; i < sm.length; i++) {
			if (gm[i] > 0 && sm[i] > 0) {
				cows = cows + Math.min(sm[i], gm[i]);
			}
		}

		return bulls + "A" + cows + "B";
	}

}
