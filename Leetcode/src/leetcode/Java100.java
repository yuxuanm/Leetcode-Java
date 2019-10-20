package leetcode;

public class Java100 {
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);

		p.left = new TreeNode(2);
		p.left.left=new TreeNode(3);
		p.right = new TreeNode(100);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.left.left=new TreeNode(3);
		q.right = new TreeNode(99);
		
		boolean b = isSameTree(p, q);
		System.out.println(b);
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null & q == null)
			return true;
		if (p == null & q != null)
			return false;
		if (p != null & q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
