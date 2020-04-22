package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q110 {
	
	
	/**Method 1: find the maximum height of each nodes, return false if any node's subnodes have height difference
	 * greater than two.
	 * */
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (Math.abs(helper(node.left) - helper(node.right)) > 1)
				return false;
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
		return true;
	}
	
	//find the maximum height of current node
	public int helper(TreeNode node) {
		if (node == null)
			return 0;
		int height = Math.max(1 + Math.max(helper(node.left), helper(node.right)), 1);
		return height;
	}
	
	/**Method 1 optimized.
	 * */
//	public boolean isBalanced(TreeNode root) {
//        if(root == null)
//            return true;
//        return Math.abs(helper(root.left)-helper(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
//    }
}
