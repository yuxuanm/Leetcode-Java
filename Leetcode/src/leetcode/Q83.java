package leetcode;

public class Q83 {

	/**
	 * Method 2: one pointer(method 2 optimized)
	 * Results: 0ms beats 100%
	 *         39.3MB beats 5.03% 
	 */
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head;
	}

	/**
	 * Method 1: two pointers 
	 * Results: 1ms beats 95.98% 
	 * 			39.6 MB beats 5.03%
	 */
//	public ListNode deleteDuplicates(ListNode head) {
//		if (head == null)
//			return null;
//		if (head.next == null)
//			return head;
//		ListNode slow = head;
//		ListNode fast = head.next;
//		while (fast != null) {
//			if (slow.val != fast.val) {
//				slow.next = fast;
//				slow = slow.next;
//				fast = fast.next;
//				continue;
//			}
//			if (slow.val == fast.val)
//				fast = fast.next;
//
//		}
//		slow.next = null;
//		return head;
//	}
}
