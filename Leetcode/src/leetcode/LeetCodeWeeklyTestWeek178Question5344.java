package leetcode;


public class LeetCodeWeeklyTestWeek178Question5344 {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] res = new int[nums.length];
		int cnt;
		for (int i = 0; i < nums.length; i++) {
			int cur = nums[i];
			cnt = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] < cur)
					cnt++;
			}
			res[i] = cnt;
		}
		return res;
	}
}
