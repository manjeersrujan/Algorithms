import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author smanjeer
 *
 * 18 Jul 2021 3:59:55 AM
 * 
 * https://leetcode.com/problems/decode-string/
 * 
 */
public class DecodeString {

	public String decodeString(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == ']') {
				List<Character> decodedString = new ArrayList<>();
				// get the encoded string
				while (stack.peek() != '[') {
					decodedString.add(stack.pop());
				}
				// pop [ from the stack
				stack.pop();
				int base = 1;
				int k = 0;
				// get the number k
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					k = k + (stack.pop() - '0') * base;
					base *= 10;
				}

				while (k != 0) {
					for (int j = decodedString.size() - 1; j >= 0; j--) {
						stack.push(decodedString.get(j));
					}
					k--;
				}
			} else {
				stack.push(c);
			}
		}

		// get the result from stack
		char[] result = new char[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return new String(result);
	}
}
