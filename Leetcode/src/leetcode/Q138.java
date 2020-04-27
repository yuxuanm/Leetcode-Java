package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q138 {
	public static void main(String[] args) {
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;

		Node new_node = copyRandomList(node1);
	}

	// use two list, one to store original nodes, one to store new created nodes
	public static Node copyRandomList(Node head) {
		if (head == null)
			return null;
		List<Node> ori_list = new ArrayList<Node>();
		List<Node> new_list = new ArrayList<Node>();

		Node node = head;
		int index = 0;
		while (node != null) {
			new_list.add(new Node(node.val));
			ori_list.add(node);
			node = node.next;
			index++;
		}

		for (int i = 0; i < index; i++) {
			if(i==index-1)
				new_list.get(i).next = null;
			else
				new_list.get(i).next = new_list.get(i + 1);
			int random_index = ori_list.indexOf(ori_list.get(i).random);
			if (random_index == -1)
				new_list.get(i).random = null;
			else
				new_list.get(i).random = new_list.get(random_index);
		}
		return new_list.get(0);
	}
}
