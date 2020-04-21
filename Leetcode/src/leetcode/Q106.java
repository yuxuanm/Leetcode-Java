package leetcode;

import java.util.Arrays;

public class Q106 {
	
	/**Similar to Q105, only need to change the sub arrays.
	 * */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		TreeNode root = helper(inorder, postorder);
		return root;
	}

	private static TreeNode helper(int[] inorder, int[] postorder) {
		if (inorder.length == 0)
			return null;
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		int[] leftInorder;
		int[] rightInorder;
		int[] leftPostorder;
		int[] rightPostorder;
		for (int i = 0; i < postorder.length; i++) {
			if (inorder[i] == postorder[postorder.length-1]) {
				leftInorder = Arrays.copyOfRange(inorder, 0, i);
				rightInorder = Arrays.copyOfRange(inorder, i + 1, postorder.length);
				leftPostorder = Arrays.copyOfRange(postorder, 0, i);
				rightPostorder = Arrays.copyOfRange(postorder, i , inorder.length-1);
				root.left = helper(leftInorder, leftPostorder);
				root.right = helper(rightInorder, rightPostorder);
				break;
			}
		}
		return root;
	}
}
