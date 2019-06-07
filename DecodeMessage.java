
public class DecodeMessage {

	public int getWaysToDecode(String msg) {
		if (msg == null || msg.length() <= 0 || msg.charAt(0) == '0') {
			return 0;
		}
		if (msg.length() == 1) {
			return msg.charAt(0) == '0' ? 0 : 1;
		}
		int[] dp = new int[msg.length() + 1];
		char[] m = msg.toCharArray();
		dp[0] = dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = 0;

			if (m[i - 1] > '0') {
				dp[i] = dp[i - 1];
			}

			if (m[i - 2] == '1' || (m[i - 2] == '2' && m[i - 1] <= '6')) {
				dp[i] = dp[i] + dp[i - 2];
			}
		}

		return dp[dp.length - 1];
	}

	public static void main(String[] args) {
		System.out.println(new DecodeMessage().getWaysToDecode("101"));
	}
}
