package leetcode;

public class Q81 {
	//
	// similar to Q33
	//
	public static void main(String[] args) {
		int[] nums = new int[] { 3, 1 };
		System.out.println(search(nums, 1));
	}

	
	/**Method: Binary Search
	 * three cases: 1. [start,mid] in ASC order
	 * 				2. [mid,end] in ASC order
	 * 				3. nums[start] = nums[mid], cannot judge which side is ASC
	 * */
	public static boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;

			if (nums[mid] == target)
				return true;

			if (nums[start] == nums[mid]) { // cannot judge which side ASC
				start++;
				continue;
			}
			if (nums[mid] > nums[start]) { // [start,mid] ASC
				if (nums[start] <= target && nums[mid] > target)
					end = mid - 1;
				else
					start = mid + 1;
			}

			else { //[mid, end] ASC
				if (nums[mid] < target && nums[end] >= target)
					start = mid + 1;
				else
					end = mid - 1;
			}

		}
		return false;
	}

}
