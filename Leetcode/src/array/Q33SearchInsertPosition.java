package array;

public class Q33SearchInsertPosition {
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
		return insert(nums, target);
	}

	private int insert(int[] nums, int target) {
		int fast = 1;
		int slow = 0;
		while (nums[slow] < target && nums[fast] < target || fast == nums.length) {
			slow++;
			fast++;
		}
		return fast;
	}
}
