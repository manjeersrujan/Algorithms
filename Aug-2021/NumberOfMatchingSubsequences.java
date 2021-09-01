import java.util.ArrayList;

/**
 * @author smanjeer
 *
 *         28 Jul 2021 8:30:01 AM
 * 
 *         https://leetcode.com/problems/number-of-matching-subsequences/
 * 
 */
public class NumberOfMatchingSubsequences {
	public int numMatchingSubseq(String s, String[] words) {

		ArrayList<Node>[] wait = new ArrayList[26];

		for (int i = 0; i < 26; i++) {
			wait[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < words.length; i++) {
			wait[words[i].charAt(0) - 'a'].add(new Node(words[i], 0));
		}

		int subSeq = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			ArrayList<Node> curList = wait[ch - 'a'];
			wait[ch - 'a'] = new ArrayList<Node>();

			for (Node node : curList) {
				if (node.index == node.str.length()-1) {
					subSeq++;
				} else {
					node.index++;
					wait[node.str.charAt(node.index) - 'a'].add(node);
				}
			}

		}

		return subSeq;
	}
	
	private class Node{
		String str;
		int index;

		public Node(String str, int index) {
			super();
			this.str = str;
			this.index = index;
		}
	}

}
