package array;

public class Q31NextPermutation {

	/*
	 * 
	 * Results: runtime 1ms beats 96.96% memory 38.6MB beats 63.03%.
	 * */
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1)
			return;
		int slow = nums.length - 2;
		int fast = nums.length - 1;
		while (slow >= 0 && nums[slow] >= nums[fast]) {
			slow--;
			fast--;
		}
		if (fast == 0) // nums is already in DESC order, then reverse it
			reverse(nums);
		else
			helper(nums, slow);
	}

	private void reverse(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int tmp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = tmp;
		}
	}

	private void helper(int[] nums, int index) {
		int min_diff = Integer.MAX_VALUE;
		int swap_index = index + 1;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] > nums[index] && nums[i] - nums[index] < min_diff) {
				min_diff = nums[i] - nums[index];
				swap_index = i;
			}
		}
		int tmp = nums[index];
		nums[index] = nums[swap_index];
		nums[swap_index] = tmp;

		quickSort(nums, index);
	}

	private void quickSort(int[] nums, int index) {
		for (int i = index + 1; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int tmp = nums[i];
			nums[i] = nums[min];
			nums[min] = tmp;
		}
	}
}
