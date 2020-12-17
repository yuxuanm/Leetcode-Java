package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import structures.TreeNode;

public class Q98ValidateBinarySearchTree {
	/*
	 * Method 1:
	 * 
	 * Inorder traversal of a BST is strictly a strictly increasing sequence.
	 * 
	 * Results: runtime 5ms beats 5.17% memory 38 mb beats 82.49%.
	 * 
	 */
	public boolean isValidBST(TreeNode root) {
		List<Integer> values = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			TreeNode cur = stack.pop();
			values.add(cur.val);
			node = cur.right;
		}
		for (int i = 0; i < values.size() - 1; i++) {
			if (values.get(i) >= values.get(i + 1))
				return false;
		}
		return true;
	}
}
