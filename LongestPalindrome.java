
class LongestPalindrome {
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}
	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int n = s.length();
		String res = null;
		boolean[][] dp =new boolean[n][n];
		
		for(int i=n-1; i>=0; i--) {
			for(int j = i; j<n;j++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				
				if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
			        res = s.substring(i, j + 1);
			     }
			}
		}
		return res;
		
	}

	
}