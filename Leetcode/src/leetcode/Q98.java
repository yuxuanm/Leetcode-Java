package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q98 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {5,1,4,null,null,3,6});
		System.out.println(isValidBST(root));
	}
	/**Inorder traversal approach: the inorder traversal of a valid BST is in ASC order.
	 * */
	public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list = inOrderTraversal(root, list);
        if(list.size()<=1)
            return true;
        int cur = list.get(0).intValue();
        for(int i=1;i<list.size();i++){
            if(list.get(i)<cur)
                return false;
            cur=list.get(i);
        }
        return true;
        
    }
    
    private static List<Integer> inOrderTraversal(TreeNode node,List<Integer> list){
        if(node.left!=null)
            inOrderTraversal(node.left,list);
        list.add(node.val);
        if(node.right!=null)
            inOrderTraversal(node.right,list);
        return list;
    }
}
