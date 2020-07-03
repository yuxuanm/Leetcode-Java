package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Q145 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		List<Integer> 	res = postorderTraversal(root);
		
	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		Map<TreeNode,Integer> map = new HashMap<TreeNode, Integer>();
		TreeNode cur = root;
		TreeNode last = null;
		while (cur != null || !stack.isEmpty()) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			else {
				TreeNode tmp = stack.peek();
				if (tmp.right != null && tmp.right != last) {
					cur = tmp.right;
				}
				else {
					last=tmp;
					TreeNode node = stack.pop();
					res.add(node.val);
				}

			}
		}
		return res;
	}
}
