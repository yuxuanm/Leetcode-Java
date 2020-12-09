package array;

import java.util.HashMap;

public class Q1TwoSum {

	/*
	 * Method 1:
	 * 
	 * Brute force: Use two for loops to iterate all the possible combinations.
	 * 
	 * Results: runtime: 12 ms beats 47.95% 
	 * 			memory: 38.7 mb beats 70.06%
	 * 
	 */
	public int[] twoSum1(int[] nums, int target) {
		int res[] = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
				}
			}
		}
		return res;
	}

	/*
	 * Method 2:
	 * 
	 * HashMap: Use a hashmap to store (value, index)
	 * 
	 * Results: runtime: 0 ms beats 100% 
	 * 			memory: 38.5 mb beats 86.16%
	 */
	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
				return new int[] { i, map.get(target - nums[i]) };
			map.put(nums[i], i);
		}
		return null;
	}
}
