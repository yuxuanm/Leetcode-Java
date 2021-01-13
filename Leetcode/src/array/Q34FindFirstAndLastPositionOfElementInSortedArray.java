package array;

public class Q34FindFirstAndLastPositionOfElementInSortedArray {

	/*
	 * Method 1: Binary search 
	 * step 1. binary search to find any one of the target.
	 * step 2. search the range
	 * 
	 * Results: runtime 0ms beats 100% memory 41.8mb beats 21.18%.
	 */
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return expand(nums, mid);
			} else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return new int[] { -1, -1 };
	}

	private int[] expand(int[] nums, int index) {
		int left = index;
		int right = index;
		while (left >= 0 && nums[left] == nums[index]) {
			left--;
		}
		while (right <= nums.length - 1 && nums[right] == nums[index]) {
			right++;
		}
		return new int[] { left + 1, right - 1 };
	}
}
