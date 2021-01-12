package array;

public class Q33SearchInRotatedSortedArray {
	/*
	 * Method 1: binary search 
	 * At least one half of array is in strictly ASC order.
	 * 
	 * Results: runtime 0ms beats 100% memory 37.8mb beats 65.24%.
	 */
	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] >= nums[left]) { // left part is ASC
				if (nums[left] <= target && nums[mid] >= target) { // target in left part
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else { // right array is ASC
				if (nums[mid] <= target && target <= nums[right]) { // target in right part
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
