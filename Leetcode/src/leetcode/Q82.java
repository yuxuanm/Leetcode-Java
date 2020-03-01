package leetcode;

public class Q82 {
	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next=new ListNode(2);
//		head.next.next=new ListNode(3);
//		head.next.next.next=new ListNode(3);
//		head.next.next.next.next=new ListNode(4);
//		head.next.next.next.next.next=new ListNode(4);
//		head.next.next.next.next.next.next=new ListNode(5);
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		ListNode res = deleteDuplicates(head);
	}

	/** Method 1: two pointers, pre to indicate last effective node, cur to indicate 
	 * 			  current node.
	 * Results: 1 ms beats 97.65%
	 *          38.8 MB beats 5.11%
	 * */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = null;
		ListNode cur = head;
		ListNode res = null;
		boolean flag = false; // false: the val never appears before
							  // true : duplicated node
		
		while (cur != null && cur.next != null) {
			if (cur.val != cur.next.val) {
				if (flag == true) { // ignore, move to next
					cur = cur.next;
					flag = false;
				} else {
					if (pre == null) { // initialize 
						res = pre = cur;
						cur = cur.next;
						continue;
					}
					pre.next = cur;
					pre = pre.next;
					cur = cur.next;
					flag = false;
				}
			} else if (cur.val == cur.next.val) { // duplicated values, change flag to true
				cur = cur.next;
				flag = true;
			}

		}
		if (pre != null) {
			// to check whether should add the last node to res
			if (flag == true) // flag = true, ignore the last node
				pre.next = null;
			if (flag == false) {// flag = false, add the last node to res
				pre.next = cur;
			}
		}

		if (pre == null && flag == false) { // if res has not been initialized and the last
			                                // node is eligible, add it to res;
			res = cur;
		}
		return res;
	}
}
