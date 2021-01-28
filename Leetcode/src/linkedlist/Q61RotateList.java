package linkedlist;

import structures.ListNode;

public class Q61RotateList {
	
	/**
	 * Method 1: Iteration
	 * Step 1: find out the length of ListNode
	 * Step 2: k= len - k% len, the new k is the actual movement
	 * Step 3: rotate
	 * 
	 * Results: runtime 0ms beats 100% memory 37.8mb beats 60.36%.
	 * */
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		int cnt = 0; // record length
		ListNode node = head;
		ListNode last = head;
		while (node != null) {
			cnt++;
			last = node;
			node = node.next;
		}
		
		if (k % cnt == 0) // special case
			return head;

		k = cnt - k % cnt;

		node = head;
		ListNode pre = null;
		for (int i = 0; i < k; i++) {
			pre = node;
			node = node.next;
		}
		last.next = head;
		pre.next = null;
		return node;
	}
}
