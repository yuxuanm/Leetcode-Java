package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q96 {
	public static void main(String[] args) {
		System.out.println(numTrees(2));
	}
	static int total = 0;
	public static int numTrees(int n) {
	       int G [] = new int[n+1];
	        G[0]=1;
	        G[1]=1;
	        for(int i=2;i<=n;i++){
	            for(int j=1;j<=i;j++){
	                G[i]=G[i]+G[j-1]*G[i-j];
	            }
	        }
	        return G[n];
	    }
//    private static void subTrees(int start, int end){
//        if(start==end) {
//            total+=1;
//            return;
//        }
//        for(int i = start; i<=end;i++){
//            subTrees(start,i-1);
//            System.out.println(total);
//            subTrees(i+1,end);
//            System.out.println(total);
//        }
//    }
	/**Method 1: use the same method as question 95
	 * results : out of time limit when processing n=19
	 * 
	 * */
//	public static int numTrees(int n) {
//		if (n == 0)
//			return 0;
//		return subTrees(1, n).size();
//	}
//
//	private static List<TreeNode> subTrees(int start, int end) {
//		List<TreeNode> res = new ArrayList<TreeNode>();
//
//		if (start > end) {
//			res.add(null);
//			return res;
//		}
//
//		for (int i = start; i <= end; i++) {
//			List<TreeNode> left_trees = subTrees(start, i - 1);
//			List<TreeNode> right_trees = subTrees(i + 1, end);
//			for (TreeNode l : left_trees) {
//				for (TreeNode r : right_trees) {
//					TreeNode root = new TreeNode(i);
//					root.left = l;
//					root.right = r;
//					res.add(root);
//				}
//			}
//		}
//		return res;
//	}
}

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	public TreeNode(int val) {
//		this.val = val;
//	}
//}