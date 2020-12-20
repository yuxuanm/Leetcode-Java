package array;

import structures.ListNode;

public class Q19RemoveNthNodeFromEndofList {
	
	/*
	 * Method 1
	 * 
	 * Two pointers, one fast pointer, one slow pointer, the number of nodes between them
	 * is n.
	 * Two cases: 	1. remove head node
	 * 				2. remove other nodes
	 * 
	 * Results: 0ms beats 100.00% memory 36.6mb beats 39.78%.
	 * 
	 * */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for(int i=1; i<= n;i++){
            fast = fast.next;
        }
        if(fast==null)  // this means remove the head node
            return head.next;
            
        while(fast.next!=null){ // remove other nodes
            slow = slow.next;
            fast = fast.next;
        }
        slow.next= slow.next.next;
        return head;
    }
}
