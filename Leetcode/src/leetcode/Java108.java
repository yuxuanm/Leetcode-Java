package leetcode;

public class Java108 {
	public static void main(String[] args) {
		int [] nums= {-10,-3,0,5,9};
		
		sortedArrayToBST(nums);
	}
	

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0)
			return null;
		int size = nums.length;
		int mid = size / 2;
		TreeNode node = new TreeNode(nums[mid]);

		int left[] = new int[mid];
		int right[] = new int[size - 1 - mid];
		System.arraycopy(nums, 0, left, 0, mid);
		System.arraycopy(nums, mid + 1, right, 0, size - mid - 1);
		node.left = sortedArrayToBST(left);
		node.right = sortedArrayToBST(right);
		return node;
	}
}