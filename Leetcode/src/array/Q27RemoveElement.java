package array;

public class Q27RemoveElement {
	/*
	 * Method 1
	 * 
	 * Two pointers
	 * 
	 * Results: runtime 0ms beats 100% memory 37mb beats 62.20%.
	 */
	public int removeElement(int[] nums, int val) {
		int slow = 0;
		int fast = 0;
		while (fast < nums.length) {
			if (nums[fast] == val)
				fast++;
			else {
				nums[slow++] = nums[fast++];
			}
		}
		return slow;
	}
}
