package leetcode;

public class Q114 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {1,2,5,3,4,null,6});
		flatten(root);
	}
	
	/**Method 1:
	 * Results: 0 ms beats 100%
	 * 			39.4 MB beats 6.67%
	 * */
	public static void flatten(TreeNode root) {
        TreeNode node = root;
        while(node!=null){
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(left==null){
                node=right;
                continue;
            }
            TreeNode tmp = right;
            if(tmp == null){
                node.right = left;
                node.left = null;
                node = node.right;
                continue;
            }
            //node.right != null and node.left != null
            node.right = left;
            while(left.right!=null){
                left = left.right;
            }
            left.right = right;
            node.left = null;
            node = node.right;
        }
    }
}
