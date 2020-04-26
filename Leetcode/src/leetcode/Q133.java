package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q133 {

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors.add(node2);
		node1.neighbors.add(node4);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node2);
		node3.neighbors.add(node4);
		node4.neighbors.add(node1);
		node4.neighbors.add(node3);
		
		Node new_noide = cloneGraph(node1);
	}

	public static Node cloneGraph(Node node) {
		if (node == null)
			return null;
		Node new_root = new Node(node.val);
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Map<Node, Integer> processed_ori_nodes = new HashMap<Node,Integer>();
		processed_ori_nodes.put(node, 0);
		map.put(new_root.val, new_root);
		while (!queue.isEmpty()) {
			Node ori_node = queue.poll();
			if (!map.containsKey(ori_node.val)) {
				Node clone_node = new Node(ori_node.val);
				map.put(ori_node.val, clone_node);
			}
			Node new_node = map.get(ori_node.val);
			for (Node n : ori_node.neighbors) {
				if(!processed_ori_nodes.containsKey(n)) {
					queue.add(n);
					processed_ori_nodes.put(n, 0);
				}
				if (!map.containsKey(n.val)) {
					Node clone_node = new Node(n.val);
					map.put(n.val, clone_node);
				}
				new_node.neighbors.add(map.get(n.val));
			}

		}
		return new_root;
	}
}

class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}