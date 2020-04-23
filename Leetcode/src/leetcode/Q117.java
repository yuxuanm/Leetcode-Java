package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q117 {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.right = new Node(7);
		Node a = connect(root);
	}
	
	public static Node connect(Node root) {
        if(root == null)
            return root;
        Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size(); // use to indicate the number of nodes in the current level
			for (int i = 0; i < size; i++) {
				Node tmp = queue.poll();
				if (i == size - 1)
					tmp.next = null;
				else
					tmp.next = queue.peek();
				if (tmp.left != null)
					queue.add(tmp.left);
				if (tmp.right != null)
					queue.add(tmp.right);
			}
		}
		return root;
    }
}
