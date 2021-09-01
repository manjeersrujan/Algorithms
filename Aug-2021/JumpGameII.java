
/**
 * @author smanjeer
 *
 *         24 Aug 2021 1:59:49 AM
 * 
 *         https://leetcode.com/problems/jump-game-ii/
 * 
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int jumps = 0;
		int farJumpFromCur = 0;
		int farJumpTillNow  =  0;
		for (int i = 0; i < nums.length - 1; i++) {
			farJumpFromCur = Math.max(farJumpFromCur, i + nums[i]);
			if(farJumpTillNow == i) {
				jumps++;
				farJumpTillNow = farJumpFromCur;
			}
		}
		return jumps;
	}
}
