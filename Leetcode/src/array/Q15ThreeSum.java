package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15ThreeSum {
	public static void main(String[] args) {
		int nums[] = new int[] { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> res = threeSum2(nums);

	}
	/*
	 * Method 2:
	 * 
	 * Similar to method 1, but control duplicate by checking array condition.
	 * 
	 * Results: runtime 2191 ms beats 5.01% memory 42.6 mb beats 52.70%
	 */
	public static List<List<Integer>> threeSum2(int[] nums) {
 		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > 0 || i>0 && nums[i]==nums[i-1]) // this condition means duplicate
				break;
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])// this condition means duplicate
					continue;
				int left = j;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[right] > -nums[i]-nums[j])
						right--;
					else if (nums[right] < -nums[i]-nums[j])
						break;
					else {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);
						res.add(tmp);
						break;
					}
				}
			}
		}
		return res;
	}

	/*
	 * Method 1:
	 * 
	 * First sort, then use two for loop to iterate. Once the first two components
	 * are fixed, use binary search to find the 3rd one.
	 * 
	 * Results: pass 318/318 cases but run out of time limit.
	 * 
	 * Improvement: avoid using contains to check duplicate results
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (binarySearch(nums, 0 - nums[i] - nums[j], j + 1) != -1) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(nums[binarySearch(nums, 0 - nums[i] - nums[j], j + 1)]);
					if (!res.contains(tmp))
						res.add(tmp);
					continue;
				}
			}
		}
		return res;
	}

	private static int binarySearch(int[] nums, int target, int left) {
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return -1;
	}
}
