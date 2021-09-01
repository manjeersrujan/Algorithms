
/**
 * @author smanjeer
 *
 *         14 Aug 2021 11:45:08 PM
 * 
 *         https://leetcode.com/problems/sentence-screen-fitting/
 * 
 */
public class SentenceScreenFitting {

	public static void main(String[] args) {
		String[] sentence = { "hello", "world" };
		System.out.println(new SentenceScreenFitting().wordsTyping(sentence, 2, 8));

	}

	public int wordsTyping(String[] sentence, int rows, int cols) {

		int res = 0;
		int spaces = cols;
		int cr = 0;
		int curWord = 0;
		while (cr < rows) {
			if (spaces >= sentence[curWord].length()) {
				spaces = spaces - (sentence[curWord].length()+1);
				curWord++;
				if (curWord == sentence.length) {
					res++;
					curWord = 0;
				}
			} else {
				spaces = cols;
				cr++;
			}
		}

		return res;

	}

}
