package array;

public class Q33SearchInsertPosition {
	/*
	 * Method 2:
	 * 
	 * Binary search
	 * 
	 * Result: runtime 0ms beats 100% memroy 38mb beats 82.07%.
	 */
	public int searchInsert2(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left;
	}

	/*
	 * Method 1:
	 * 
	 * Binary search + brute force
	 * 
	 * Result: runtime 0ms beats 100% memroy 38mb beats 75.63%. Improve: there is no
	 * need to search insert position using brute force.
	 */
	public int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return insert(nums, target); // brute force to find insert position.
	}

	private int insert(int[] nums, int target) {
		int fast = 1;
		int slow = 0;
		while (fast != nums.length && nums[slow] < target && nums[fast] < target) {
			slow++;
			fast++;
		}
		return nums[slow] < target ? fast : slow;
	}
}
