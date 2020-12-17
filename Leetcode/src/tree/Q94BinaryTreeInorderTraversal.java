package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import structures.TreeNode;

public class Q94BinaryTreeInorderTraversal {
	/*
	 * Method 1:
	 * 
	 * DFS, use a stack
	 * 
	 * Results: runtime: 1 ms beats 42.83% memory: 36.8 mb beats 71.52%
	 * 
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			TreeNode cur = stack.pop();
			res.add(cur.val);
			node = cur.right;
		}
		return res;
	}
}
