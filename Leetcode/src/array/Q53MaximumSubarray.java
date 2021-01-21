package array;

public class Q53MaximumSubarray {
	
	/*	
	 * Method 1: dynamic programming
	 * Use an array to indicate the maximum results at each cell.
	 * 
	 * Function: res[i] = res[i - 1] < 0 ? nums[i] : res[i - 1] + nums[i];
	 * 
	 * Results: runtime 1ms beats 93.14% memory 38.5mb beats 25.74%.
	 * */
	public int maxSubArray(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = nums[0];
		int ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] < 0 ? nums[i] : res[i - 1] + nums[i];
			ans = ans < res[i] ? res[i] : ans;
		}
		return ans;
	}
}
