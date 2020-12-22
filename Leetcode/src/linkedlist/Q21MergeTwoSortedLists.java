package linkedlist;

import structures.ListNode;

public class Q21MergeTwoSortedLists {
	/*
	 * Method 1:
	 * 
	 * Iteration, compare the value of two nodes, attach the smaller one to result.
	 * 
	 * Results: runtime 0ms beats 100.00% memory 37.7mb beats 92.45%
	 * */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while(l1!=null && l2!=null){
            if(l1.val>=l2.val){
                node.next = l2;
                l2=l2.next;
            }
            else{
                node.next=l1;
                l1=l1.next;
            }
            node=node.next;
        }
        if(l1==null)
            node.next=l2;
        else if(l2==null)
            node.next=l1;
        return head.next;
    }
}
