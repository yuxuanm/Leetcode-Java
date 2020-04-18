package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q113 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {-2,null,-3});
		Q113 q113 = new Q113();
		List<List<Integer>> res = q113.pathSum(root, -5);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		if (root == null) // if root is null
			return new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>(); // use to store results
		List<Integer> list = new ArrayList<Integer>();
		helper(root, res, list, 0, sum);
		return res;
	}

	private void helper(TreeNode node, List<List<Integer>> res, List<Integer> list, int curSum, int sum) {
		//there are negative values in the testing samples, so we are not writing if(curSum+node.val>sum) return here
		// if the current branch reaches the end and curSum != sum, return
		if (curSum + node.val !=sum && node.left==null && node.right == null)
			return;
		list.add(node.val);
		if (curSum + node.val == sum && node.left == null && node.right == null) {
			res.add(new ArrayList<Integer>(list));
			list.remove(list.size() - 1);
			return;
		}
		if (node.left != null)
			helper(node.left, res, list, curSum + node.val, sum);
		if (node.right != null)
			helper(node.right, res, list, curSum + node.val, sum);
		list.remove(list.size()-1);
	}
}
