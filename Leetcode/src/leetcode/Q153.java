package leetcode;

public class Q153 {
	public static void main(String[] args) {
		int [] arr = new int[] {3,1,2};
		int res = findMin(arr);
		System.out.println(res);
	}
	/*Binary search
	 * */
	public static int findMin(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		while (true) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] >= nums[lo] && nums[hi] >= nums[mid])
				return nums[lo];
			if (nums[mid] > nums[lo]) {
				lo = mid ;
				continue;
			}
			if (mid == lo || mid == hi) // when there are only two values, return the smaller one
				return Math.min(nums[lo], nums[hi]);
			else 
				hi = mid ;
		}
	}
}
