package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q116 {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right = new Node(3);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node a = connect(root);
	}
	
	/**Method 1: use one pointer to indicate current node, use another pointer to point next node.
	 * 			 if the current node is at end of each level, continue the next round.
	 * */
	public static Node connect(Node root) {
		if (root == null)
			return null;
		int index = 2;
		Queue<Node> queue = new LinkedList<Node>();
		if (root.left != null) {
			queue.add(root.left);
			queue.add(root.right);
		}
		Node node = root;
		while (queue.peek() != null) {
			Node next_node = queue.poll();
			if ((index & (index - 1)) == 0) { // to check wether the current cell is at end of each level
				if (index == 2) {
					index++;
					node = next_node;
					continue;
				}
				queue.add(node.left);
				queue.add(node.right);
				index++;
				node = next_node;
				continue;
			}
			node.next = next_node;
			queue.add(node.left);
			queue.add(node.right);
			node = next_node;
			index++;

		}
		return root;
	}
	
	/**Method 2: from leetcode
	 * */
	 public Node connect(Node root) {
	        Node node = root;
	        while(node.left!=null){
	            Node tmp = node;
	            while(tmp!=null){
	                tmp.left.right = tmp.right;
	                if(tmp.next!=null){
	                    tmp.right.next = tmp.next.left;
	                }
	                tmp = tmp.next;
	            }
	                
	            node = node.left;
	        }
	        return root;
	    }
}
