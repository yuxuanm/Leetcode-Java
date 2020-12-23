package linkedlist;

import structures.ListNode;

public class Q24SwapNodesInPairs {
	/*
	 * Method 1
	 * 
	 * Iteration, use one dummy node to indicate the root
	 * 
	 * Results: runtime 0ms beats 100% memory 36.1mb beats 63.51%.
	 * */
	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next==null)
            return head;
        ListNode dummy = new ListNode(-1); // dummy node
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){ // stop condition
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            ListNode third = cur.next.next.next;
            cur.next=second;
            cur.next.next=first;
            first.next=third;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
