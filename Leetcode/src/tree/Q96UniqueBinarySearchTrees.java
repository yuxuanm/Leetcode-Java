package tree;

import java.util.ArrayList;
import java.util.List;

import structures.TreeNode;

public class Q96UniqueBinarySearchTrees {
	public static void main(String[] args) {
		int n = 3;
		int res = numTrees2(3);
		System.out.println(res);
	}

	/*
	 * Method 3:
	 * 
	 * Dynamic programming, for each n, the total number of different trees is equal to the sum f(0), f(1)..., f(n), 
	 * where f(i) is the number of trees with root i.
	 * 
	 * Results: runtime 0 ms beats 100% memory 35.3 mb beats 61.41%.
	 * 
	 */
	public int numTrees3(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				res[i] += res[j - 1] * res[i - j];
			}
		}
		return res[n];
	}

	/*
	 * Method 2:
	 * 
	 * Recursion, similar to method 1, instead of construct all trees, just count
	 * the number of different ways to construct trees.
	 * 
	 * Results: pass 19/19 cases but still run out of time
	 * 
	 */
	public static int numTrees2(int n) {
		if (n == 0)
			return 0;
		return numSubTrees2(1, n);
	}

	private static int numSubTrees2(int start, int end) {
		int res = 0;
		if (start > end || start == end)
			return 1;
		for (int i = start; i <= end; i++) {
			int res_left = numSubTrees2(start, i - 1);
			int res_right = numSubTrees2(i + 1, end);
			res += res_left * res_right;
		}
		return res;
	}

	/*
	 * Method 1:
	 * 
	 * Recursion, similar to Q95, this will lead to extreme large memory usage if n
	 * is large
	 * 
	 * Results: run out of time when n=12
	 * 
	 */
	public int numTrees(int n) {
		if (n == 0)
			return 0;
		List<TreeNode> res = numSubTrees(1, n);
		return res.size();
	}

	private List<TreeNode> numSubTrees(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) { // end condition
			res.add(null);
			return res;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left_trees = numSubTrees(start, i - 1);
			List<TreeNode> right_trees = numSubTrees(i + 1, end);
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
