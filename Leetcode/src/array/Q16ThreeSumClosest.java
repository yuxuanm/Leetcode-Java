package array;

import java.util.Arrays;

public class Q16ThreeSumClosest {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 2, -3 };
		int target = 1;
		int res = threeSumClosest2(arr, target);
		System.out.println(res);

	}

	/*
	 * Method 2:
	 * 
	 * Two pointers: once fixed the first number, use another two pointers to
	 * indicate. First pointer indicate the left position, and the other represents
	 * the right side. In each iteration, if current sum of the three numbers is
	 * greater than target, move the right pointer to the left and vice versa.
	 * 
	 * Time complexity has been reduced from O(n^3) to O(n^2)
	 * 
	 * Results: runtime 6 ms beats 83.02% memory 38.2 mb beats 64.2%.
	 */
	public static int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int min_diff = Integer.MAX_VALUE;
		int res_sum = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int tmp_sum = nums[i] + nums[left] + nums[right];
				if (tmp_sum > target) // move the right pointer
					right--;
				else if (tmp_sum < target) // move the left pointer
					left++;
				else // this mean the current sum is exactly same as the target
					return tmp_sum; 
				res_sum = Math.abs(tmp_sum - target) < min_diff ? tmp_sum : res_sum;
				min_diff = Math.abs(tmp_sum - target) < min_diff ? Math.abs(tmp_sum - target) : min_diff;
			}
		}

		return res_sum;
	}

	/*
	 * Method 1:
	 * 
	 * Brute force, use three for loop, time complexity O(n^3)
	 * 
	 * Results: runtime 159 ms beats 6.25% memory 37.9 mb beats 91.66%.
	 */
	public int threeSumClosest(int[] nums, int target) {
		int min_diff = Integer.MAX_VALUE;
		int res_sum = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int tmp_sum = Integer.MAX_VALUE;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				for (int k = j + 1; k < nums.length; k++) {
					tmp_sum = nums[i] + nums[j] + nums[k];
					if (Math.abs(tmp_sum - target) < min_diff) {
						min_diff = Math.abs(tmp_sum - target);
						res_sum = tmp_sum;
					}
				}
			}
		}
		return res_sum;
	}
}
