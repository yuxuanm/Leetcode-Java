package array;

public class Q55JumpGame {
	
	/*
	 * Method 1: Dynamic programming
	 * use an boolean array to indicate the accessibility of each cell.
	 * If any one is unachievable, then we cannot achieve the last cell.
	 * 
	 * Results: runtime 304ms beats 12.71% memory 40.4mb beats 43.95%.
	 * 
	 * */
	public boolean canJump(int[] nums) {
		boolean res[] = new boolean[nums.length];
		res[0] = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j <= nums[i] + i && j < nums.length; j++) {
				res[j] = true;
			}
		}

		for (boolean r : res) {
			if (r == false)
				return false;
		}
		return true;
	}
}
