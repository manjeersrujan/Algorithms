import java.sql.Ref;
import java.sql.SQLException;
import java.util.Map;

public class ReformatString {
	
	public static void main(String[] args) {
		System.out.println(new ReformatString().solution("123456789"));
	}
	public String solution(String S) {

		if (S == null || S.length() <= 0) {
			return S;
		}

		StringBuffer result = new StringBuffer();
		int i = 0;
		int count = 0;
		while (i < S.length()) {
			char c = S.charAt(i);
			if ('0' <= c && c <= '9') {
				result.append(c);
				count++;
				if (count == 3) {
					result.append("-");
					count = 0;
				}
			}
			i++;
		}
		if (count == 0) {
			result.delete(result.length() - 1, result.length());
		} else if (count == 1) {
			result.delete(result.length() - 2, result.length() - 1);
			result.insert(result.length() - 2, "-");
		}
		System.out.println();
		return result.toString();
	}

}
