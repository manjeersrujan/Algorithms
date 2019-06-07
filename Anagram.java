import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 1. Write a function  boolean isAnagram(String lhs, String rhs).  
 * An anagram is direct word switch or word play, the result of rearranging the letters of a word 
 * or phrase to produce a new word or phrase, using all the original letters exactly once; 
 * for example, the word ‘anagram' can be rearranged into ‘nagaram’.
 */
/**
 * @author Manjeer
 *
 */
public class Anagram {

	public static void main(String[] args) {
		System.out.println(new Anagram().isAnagramBySort("abcdefg", "fgcdeab"));
		System.out.println(new Anagram().isAnagramByHash("abcdefgz", "abcdefgz"));
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 * 
	 * Using Sort O(NlogN)
	 */
	public boolean isAnagramBySort(String s1, String s2) {

		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		}

		char[] s1a = s1.toCharArray();
		char[] s2a = s2.toCharArray();

		Arrays.sort(s1a);
		Arrays.sort(s2a);

		return Arrays.equals(s1a, s2a);
	}

	/**
	 * @param s1
	 * @param s2
	 * @return
	 * 
	 * Using HashMap O(n)
	 */
	public boolean isAnagramByHash(String s1, String s2) {

		if (s1 == null && s2 == null) {
			return true;
		} else if (s1 == null || s2 == null) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		}

		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char charAt = s1.charAt(i);
			Integer count = m1.get(charAt);
			if (count == null) {
				m1.put(charAt, 1);
			} else {
				m1.put(charAt, count + 1);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			char charAt = s2.charAt(i);
			Integer count = m2.get(charAt);
			if (count == null) {
				m2.put(charAt, 1);
			} else {
				m2.put(charAt, count + 1);
			}
		}

		for (char c : m1.keySet()) {
			if (m1.get(c) != m2.get(c)) {
				return false;
			}
			m2.remove(c);
		}

		if (m2.isEmpty()) {
			return true;
		}

		return false;

	}
}
