package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Q94 {
	public static void main(String[] args) {
		Integer[] nums = new Integer[] { 1, null, 2, 3 };
		TreeNode node = TreeNode.constructTree(nums);
		List<Integer> res = inorderTraversal(node);
	}
	
	/**Method 2: iterate
	 * 
	 * */
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node=root;
		while(node!=null||!stack.isEmpty()) {
			while(node!=null) {
				stack.push(node);
				node=node.left;
			}
			node=stack.pop();
			res.add(node.val);
			node=node.right;
		}
		
		return res;
	}
	/**Method 1: recursive
	 * 
	 * 0 ms beats 100%
	 * 37.8 MB beats 5.08%
	 * */
//	public static List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		if (root == null)
//			return res;
//		helper(root, res);
//
//		return res;
//	}
//
//	private static void helper(TreeNode node, List<Integer> res) {
//		if (node != null) {
//			if (node.left != null)
//				helper(node.left, res);
//			
//			res.add(node.val);
//			
//			if (node.right != null)
//				helper(node.right, res);
//		}
//	}

	// wrong, this method is for preorder traversal
//	public static List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> res = new ArrayList<Integer>();
//		if (root == null)
//			return res;
//		Queue<TreeNode> queue =new LinkedList<TreeNode>();
//		queue.add(root);
//		while (!queue.isEmpty()) {
//			TreeNode node;
//			for (int i = 0; i < queue.size(); i++) {
//				node = queue.peek();
//				queue.poll();
//				if (node.left != null)
//					queue.add(node.left);
//				if (node.right != null)
//					queue.add(node.right);
//				res.add(node.val);
//			}
//		}
//		return res;
//	}
}
