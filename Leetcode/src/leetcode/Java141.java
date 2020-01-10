package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Java141 {
//	public boolean hasCycle(ListNode head) {
//		Set<ListNode> set = new HashSet<ListNode>();
//		if (head == null)
//			return false;
//		while (head != null) {
//			if (set.contains(head))
//				return true;
//			set.add(head);
//			head = head.next;
//		}
//		return false;
//	}
	
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow!=fast) {
			if(slow.next==null||fast.next.next==null) {
				return false;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return true;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}