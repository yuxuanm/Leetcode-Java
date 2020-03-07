package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q95 {
	
	
	/**From Leetcode
	 * */
	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return recursiveTrees(1, n);
	}

	private List<TreeNode> recursiveTrees(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left_trees = recursiveTrees(start, i - 1); // left tree values smaller than root
			List<TreeNode> right_trees = recursiveTrees(i + 1, end); // right tree values greater than root

			for (TreeNode l : left_trees) {
				for (TreeNode r : right_trees) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root); // add root to the return list
				}
			}
		}
		return res;
	}
}
