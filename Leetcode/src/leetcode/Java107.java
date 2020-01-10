package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Java107 {

	class Solution {
		public List<List<Integer>> levelOrderBottom(TreeNode107 root) {
			if(root==null)
				return null;
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			
			LinkedList<TreeNode107> queue = new LinkedList<TreeNode107>();
			
			queue.add(root);
			List<Integer> l1 = new ArrayList<Integer>();
			l1.add(root.val);
			list.add(l1);
			
			while(!queue.isEmpty()) {
				List<Integer> l = new ArrayList<Integer>();
				int size = queue.size();
				for(int i=0;i<size;i++) {
					TreeNode107 node = queue.pollFirst();
					if(node.left!=null) {
						queue.add(node.left);
						l.add(node.left.val);
					}
					if(node.right!=null) {
						queue.add(node.right);
						l.add(node.right.val);
					}
				}
			list.add(l);
			}
			
			
			return reverseList(list);

		}
		
		public List<List<Integer>> reverseList(List<List<Integer>> list){
			List<List<Integer>> newList = new ArrayList<List<Integer>>(list.size());
			int size = list.size();
			for(int i=0;i<size;i++) {
				newList.add(list.get(size-i-1));
			}
			
			return newList;
		}
	}
}

class TreeNode107 {
	int val;
	TreeNode107 left;
	TreeNode107 right;

	TreeNode107(int x) {
		val = x;
	}
}
