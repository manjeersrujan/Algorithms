import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RearrangeWord {
	/*
	 * Complete the 'rearrangeWord' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING word
	 * as parameter.
	 */

	public static void main(String[] args) {

		System.out.println(new RearrangeWord().getPerms("abcd", new HashSet<String>(), ""));
	}

	public static String rearrangeWord(String word) {

		// Write your code here
		if (word == null || word.length() <= 1) {
			return "no answer";
		}

		Set<String> perms = new LinkedHashSet<String>();
		perms = getPerms(word, perms, "");

		List<String> pList = new ArrayList<>(perms);
		Collections.sort(pList);
		int indexOf = pList.indexOf(word);

		if (indexOf <= pList.size() - 2) {
			return pList.get(indexOf + 1);
		} else {
			return "no answer";
		}

	}

	public static Set<String> getPerms(String str, Set<String> perms, String preF) {

		if (str.length() == 1) {
			if (preF != null) {
				perms.add(preF + str);
			} else {
				perms.add(str);
			}
			return perms;
		}

		if (str.length() == 2) {
			if (preF != null) {
				perms.add(preF + str.charAt(1) + str.charAt(0));
				perms.add(preF + str);
			} else {
				perms.add("" + str.charAt(1) + str.charAt(0));
				perms.add(str);
			}

			return perms;
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Set<String> perms2 = null;
			if (i == 0) {
				perms2 = getPerms(str.substring(i + 1, str.length()), perms, "" + (preF+c));
			} else if (i == str.length() - 1) {
				perms2 = getPerms(str.substring(0, i), perms, "" + (preF+c));
			} else {
				perms2 = getPerms(str.substring(0, i) + str.substring(i + 1, str.length()), perms, "" + (preF+c));
			}
			for (String nStr : perms2) {
				if(preF != null) {
					perms.add(preF +c + nStr);
				}
			}
		}
		return perms;
	}

	class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {

			if (o1 == o2 || o1.equals(o2)) {
				return 0;
			}

			int o1C = Integer.bitCount(o1);
			int o2C = Integer.bitCount(o2);

			if (o1C != o2C) {
				return o1C - o2C;
			} else {
				return o1 - o2;
			}
		}
	}

	public static List<Integer> rearrange(List<Integer> elements) {
		Collections.sort(elements, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				if (o1 == o2 || o1.equals(o2)) {
					return 0;
				}

				int o1C = Integer.bitCount(o1);
				int o2C = Integer.bitCount(o2);

				if (o1C != o2C) {
					return o1C - o2C;
				} else {
					return o1 - o2;
				}
			}
		});
		return elements;
	}

}
