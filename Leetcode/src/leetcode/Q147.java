package leetcode;

public class Q147 {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
//		head.next.next.next = new ListNode(3);
		ListNode res  = insertionSortList(head);
	}
	/**Method 2: method 1 optimized
	 * */
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next=head;
		while(head!=null && head.next!=null) {
			if(head.val<head.next.val) {
				head = head.next;
				continue;
			}
			ListNode pre = dummy;
			ListNode cur = head.next;
			while(pre.next.val<cur.val)
				pre=pre.next;
			head.next = cur.next;
			cur.next=pre.next;
			pre.next= cur;
		}
		return dummy.next;
    }
	/**Method 1: use dummy node and lots of pointers
	 * */
//	public static ListNode insertionSortList(ListNode head) {
//		if (head == null)
//			return null;
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		ListNode index = head.next;
//		ListNode node = head;
//		ListNode pre;
//		node.next = null;
//		outer: while (index != null) {
//			node = head;
//			pre = dummy;
//			ListNode cur = index;
//			index = index.next;
//			if (cur.val <= head.val) {
//				dummy.next = cur;
//				cur.next = head;
//				head = cur;
//				continue;
//			}
//			while (cur.val > node.val) {
//				if (node.next == null) {
//					node.next = cur;
//					cur.next = null;
//					continue outer;
//				}
//				node = node.next;
//				pre = pre.next;
//			}
//			pre.next = cur;
//			cur.next = node;
//		}
//		return dummy.next;
//	}
}
