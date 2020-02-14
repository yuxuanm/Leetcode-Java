package leetcode;

public class Q55 {
	public static void main(String[] args) {
//		int [] nums = new int[] {4,2,1,0,4};
		int[] nums = new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
		Q55 q55 = new Q55();
		System.out.println(q55.canJump(nums));
	}
	
	// Method 1:
	public boolean canJump(int[] nums) {
		int max=0; //store the max position that current index can reach
				   //if max>=nums.length-1, the array can reach the end
				   //if current index>max, cannot reach the end
		for(int i=0;i<nums.length;i++) {
			if(i>max)
				return false;
			max=Math.max(max, i+nums[i]);
			if(max>=nums.length-1)
				return true;
		}
		return false;
	}
	
	
	// Method 2:
	// passed 73/75 test samples.
//	public boolean canJump(int[] nums) {
//		int curIndex = 0;
//		int remain = nums.length - 1;
//		boolean flag = false;
//		for (int i = 1; i <= nums[curIndex]; i++) {
//			flag = flag || subJump(nums, curIndex + i, remain - i, flag);
//		}
//		return flag;
//	}
//
//	private boolean subJump(int[] nums, int curIndex, int remain, boolean flag) {
//		if (nums[curIndex] >= remain)
//			return true;
//		if (nums[curIndex] == 0)
//			return false;
//		for (int i = 1; i <= nums[curIndex]; i++) {
//			curIndex = curIndex + i;
//			flag = flag || subJump(nums, curIndex , remain - i, flag);
//			curIndex-=i;
//		}
//		return flag;
//	}
}
