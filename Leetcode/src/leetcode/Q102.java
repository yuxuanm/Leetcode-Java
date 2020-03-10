package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {3,9,20,null,null,15,7});
		List<List<Integer>> res = levelOrder(root);
	}
	/**use a queue to iterate the tree
	 * */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); // use a queue to store the nodes on the same level
		queue.add(root);
		TreeNode node = null;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) { //iterate queue.size() times (current level)
				node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			res.add(new ArrayList<Integer>(list));
			list.clear();
		}
		return res;
	}
}
