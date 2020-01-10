package leetcode;

public class Java110 {
	public static int depth(TreeNode node) {
		if(node==null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		return 1 + Math.max(depth(node.left), depth(node.right));
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(depth(root.left) - depth(root.right)) <= 1)
			return true;
		if (Math.abs(depth(root.left) - depth(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		System.out.println(isBalanced(node));
	}
}
