package tree;

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class Q95UniqueBinarySearchTreesII {
	/*
	 * Method 1:
	 * 
	 * Recursion
	 * 
	 * Results: runtime: 1 ms beats 99.94% memory: 38.9 mb beats 87.80%
	 * 
	 */
	public static List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return generateSubTree(1, n);
	}

	private static List<TreeNode> generateSubTree(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left_trees = generateSubTree(start, i - 1);
			List<TreeNode> right_trees = generateSubTree(i + 1, end);
			for (TreeNode l : left_trees) {
				for (TreeNode r : right_trees) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
