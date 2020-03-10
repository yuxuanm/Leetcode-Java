package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {3,9,20,null,null,15,7});
		List<List<Integer>> res = zigzagLevelOrder(root);
	}
	
	/**use a flag to indicate direction, flag = true: left to right
	 * 									 flag = false: right to left
	 * use two stack to store elements
	 * */
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		Boolean leftToRight = true;
		while (!stack.isEmpty()) {
			TreeNode node = null;
			int size = stack.size();
			Stack<TreeNode> newStack = new Stack<TreeNode>(); //use a new stack to store the lower
														      //level elements
			for (int i = 0; i < size; i++) {
				if (leftToRight) {// indicate left to right
					node = stack.pop();
					list.add(node.val);
					if (node.left != null)
						newStack.push(node.left);
					if (node.right != null)
						newStack.push(node.right);
				} else { // from right to left
					node = stack.pop();
					list.add(node.val);
					if (node.right != null)
						newStack.push(node.right);
					if (node.left != null)
						newStack.push(node.left);
				}
			}
			leftToRight = leftToRight ? false : true; // change direction
			res.add(new ArrayList<Integer>(list));
			list.clear();
			stack = newStack;
		}
		return res;
	}
}
