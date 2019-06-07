
public class MaxSumNonConsecutive {

	public static void main(String[] args) {
		int[] a = { 10,-1,-1,-1,-1, 10, -5, 10, 100 };
		System.out.println(new MaxSumNonConsecutive().getMaxSumOfNonConsecutive(a));
	}

	public int getMaxSumOfNonConsecutive(int[] a) {

		if (a == null || a.length == 0) {
			return 0;
		}

		if (a.length <= 2) {
			return a.length == 1 ? a[0] : Math.max(a[0], a[1]);
		}

		int max1 = a[0];
		int max2 = a[1];

		for (int i = 2; i < a.length; i++) {
			int k = a[i];
			if(i%2 == 0) {
				max2 = Math.max(max1, max2);
				if(max1 < max1 + a[i]) {
					max1 = max1 + a[i];
				}
			}else {
				max1 = Math.max(max1, max2);
				if(max2 < max2 + a[i]) {
					max2 = max2 + a[i];
				}
			}
			
		}
		return Math.max(max1, max2);
	}

}
