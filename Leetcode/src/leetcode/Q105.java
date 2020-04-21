package leetcode;

import java.util.Arrays;

public class Q105 {
	public static void main(String[] args) {
		int [] preorder = new int [] {1,2,3};
		int [] inorder = new int [] {3,2,1};
		TreeNode root = buildTree(preorder, inorder);
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = helper(preorder, inorder);
		return root;
	}

	private static TreeNode helper(int[] preorder, int[] inorder) {
		if (preorder.length == 0)
			return null;
		TreeNode root = new TreeNode(preorder[0]);
		int[] leftPreorder;
		int[] rightPreorder;
		int[] leftInorder;
		int[] rightInorder;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				leftPreorder = Arrays.copyOfRange(preorder, 1, i + 1);
				rightPreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
				leftInorder = Arrays.copyOfRange(inorder, 0, i );
				rightInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
				root.left = helper(leftPreorder, leftInorder);
				root.right = helper(rightPreorder, rightInorder);
				break;
			}
		}
		return root;
	}
}
