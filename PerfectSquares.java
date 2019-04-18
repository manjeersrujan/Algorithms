import java.util.HashMap;
import java.util.Map;

/*
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {
	
	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(12));
	}
	public int numSquares(int n) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		return numSquares(n, map);
	}
	
	private int numSquares(int n, Map<Integer, Integer> map) {
		if(map.get(n) !=null) {
			return map.get(n);
		}

		double sqrt = Math.floor(Math.sqrt(n));
		int min = Integer.MAX_VALUE;
		if((int) (sqrt*sqrt) ==  n) {
			map.put(n, 1);
			return 1;
		} else {
			while(sqrt >= 1) {
				int gap= n - (int) (sqrt*sqrt);
				int count = numSquares(gap, map)+1;
				if(min > count) {
					min = count;
				}
				sqrt--;
			}
			
		}
		map.put(n, min);
		return min;
	}
}
