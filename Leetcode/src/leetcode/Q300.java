package leetcode;

import java.util.Arrays;

class Q300 {
	public static void main(String[] args) {
		int [] nums = new int[] {10,9,2,5,3,7,101,18};
		int res = lengthOfLIS(nums);
		
	}
	public static int lengthOfLIS(int[] nums) {

		if (nums.length == 0)
			return 0;
		int ans = 0;
		int[] res = new int[nums.length];
		Arrays.fill(res, 1);
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] < nums[j])
					res[i] = Math.max(res[j]+1, res[i]) ;
			}
			ans = Math.max(ans, res[i]);
		}
		return ans;
	}
}
