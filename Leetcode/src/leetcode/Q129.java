package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q129 {
	public static void main(String[] args) {
		TreeNode root = TreeNode.constructTree(new Integer[] {4,9,0,5,1});
		Q129 q129 = new Q129();
		System.out.println(q129.sumNumbers(root));
	}

//	/**Method 1: DFS
//	 * */
//	public int sumNumbers(TreeNode root) {
//		int sum = 0;
//		int listIndex = 0;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		stack.add(root);
//		List<String> list = new ArrayList<String>();
//		list.add("0");
//		while (!stack.isEmpty()) {
//			TreeNode node = stack.pop();
//			list.add(list.get(listIndex++) + Integer.toString(node.val));
//			if (node.left == null && node.right == null) {
//				sum += Integer.parseInt(list.get(listIndex));
//				list.remove(listIndex--);
//				continue;
//			}
//			if (node.right != null)
//				stack.add(node.right);
//			if (node.left != null)
//				stack.add(node.left);
//
//		}
//		return sum;
//	}
	
	/**optimize method 1
	 * */
	public int sumNumbers(TreeNode root) {
        int sum =helper(root,0);
        return sum;
    }
    
    private int helper(TreeNode node, int res){
        if(node == null)
            return 0;
        res = res*10+node.val;
        if(node.left==null&&node.right==null) 
            return res;
        return helper(node.left,res)+helper(node.right,res);
    }
}
