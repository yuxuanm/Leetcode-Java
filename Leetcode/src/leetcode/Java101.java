package leetcode;

public class Java101 {
	public static void main(String[] args) {
		String a = "leftright";
		String b = a.replace("left", "");
		System.out.println(b);
	
		TreeNode101 root = new TreeNode101(1);

	}
}

class TreeNode101 {
	int val;
	TreeNode101 left;
	TreeNode101 right;

	TreeNode101(int x) {
		val = x;
	}
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
    	return isEqual(root.left, root.right);
    }
    
    
    public boolean isEqual(TreeNode p, TreeNode q) {
    	if(p==null && q==null)
    		return true;
    	if(p!=null && q==null)
    		return false;
    	if(p==null && q!=null)
    		return false;
    	if(p.val != q.val)
    		return false;
    	return isEqual(p.left, q.right) && isEqual(p.right, q.left);
    }
}