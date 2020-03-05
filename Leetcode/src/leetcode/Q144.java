package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q144 {
	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, null, 2, 3 };
		TreeNode node = TreeNode.constructTree(nums);
		List<Integer> res =preorderTraversal(node);
		}

	/**
	 * Method 2: iterate
	 */
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			res.add(cur.val);

			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		return res;
	}
	/**
	 * Method 1: recursion
	 */
//	public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		if (root == null)
//			return res;
//		helper(root, res);
//		return res;
//	}
//
//	private void helper(TreeNode node, List<Integer> res) {
//		res.add(node.val);
//		if (node.left != null)
//			helper(node.left, res);
//		if (node.right != null)
//			helper(node.right, res);
//	}
}
