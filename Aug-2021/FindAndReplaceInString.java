import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author smanjeer
 *
 *         18 Aug 2021 4:05:25 AM
 * 
 *         https://leetcode.com/problems/find-and-replace-in-string/
 * 
 */
public class FindAndReplaceInString {
	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

		List<Replace> replaces = new ArrayList<>();
		int offset = 0;
		for (int i = 0; i < indices.length; i++) {
			replaces.add(new Replace(indices[i], sources[i], targets[i]));
		}

		Collections.sort(replaces, (a, b) -> a.index - b.index);
		StringBuffer sb = new StringBuffer(s);
		for (Replace replace : replaces) {
			int curIndex = replace.index + offset;

			if (sb.substring(curIndex, curIndex + replace.source.length()).equals(replace.source)) {
				sb.replace(curIndex, curIndex + replace.source.length(), replace.target);
				offset += replace.target.length() - replace.source.length();
			}
		}

		return sb.toString();
	}

	class Replace {
		public Replace(int index, String source, String target) {
			super();
			this.index = index;
			this.source = source;
			this.target = target;
		}

		int index;
		String source;
		String target;
	}

}
