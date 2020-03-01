package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeWeeklyTestWeek178Question5346 {
	public static void main(String[] args) {
		Integer[] array = new Integer[] { 1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3 };
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(8);
		TreeNode root = TreeNode.constructTree(array);
		boolean res = isSubPath(head, root);
		System.out.println(res);
	}

	/**Method 1 optimized
	 * */
	public static boolean isSubPath(ListNode head, TreeNode root) {
		if (head == null)
			return true;
		if (root == null)
			return false;
		if (head.val == root.val) {
			if(backtrack(head, root))
				return true;
		}
		return isSubPath(head, root.left) || isSubPath(head, root.right);
	}

	private static boolean backtrack(ListNode ln, TreeNode tn) {
		
		if (ln == null || tn == null)
			return false;
		if (ln.val != tn.val)
			return false;
		if (ln.next == null && ln.val == tn.val) // end condition
			return true;
		return backtrack(ln.next, tn.left) || backtrack(ln.next, tn.right);
	}

	/**
	 * Method 1: DFS twice first DFS: find the start point on the TreeNode when
	 * TreeNode.val = head.val store the start points in the list second DFS: match
	 * every node from the start point
	 */
//	public static boolean isSubPath(ListNode head, TreeNode root) {
//		List<TreeNode> list = new ArrayList<TreeNode>();
//		findStart(head.val, root, list);
//		if (list != null) {
//			for (TreeNode tn : list) {
//				if (backtrack(head, tn))
//					return true;
//			}
//		}
//		return false;
//	}
//
//	private static boolean backtrack(ListNode ln, TreeNode tn) {
//		if (ln == null || tn == null)
//			return false;
//		if (ln.val != tn.val)
//			return false;
//		if (ln.next == null && ln.val == tn.val)
//			return true;
//		
//
//		return backtrack(ln.next, tn.left) || backtrack(ln.next, tn.right);
//	}
//
//	//use list to store the start treenode,
//	//if treenode.val = head.val
//	// add it to list
//	private static void findStart(int start, TreeNode tn,List<TreeNode> list) {
//		if (tn == null)
//			return;
//		if (tn.val == start)
//			list.add(tn);
//		findStart(start, tn.left, list);
//		findStart(start, tn.right, list);
//	}

}
