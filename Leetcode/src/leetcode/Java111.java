package leetcode;

import java.util.LinkedList;

public class Java111 {
	public int minDepth(TreeNode root) {
		int depth =1;
		if(root==null)
			return 0;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i =0;i<size;i++) {
				TreeNode node = queue.pollFirst();
				if(node.left==null&&node.right==null)
					return depth;
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
			depth++;
		}
		return depth;
	}
}
