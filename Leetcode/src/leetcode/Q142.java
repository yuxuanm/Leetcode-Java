package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q142 {

	/**Method 2: two pointers
	 * */
	public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            if(fast.next==null||fast.next.next == null)
                return null;
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast)
                break;
        }
        fast = head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
	/**
	 * Method 1: use a list to store all the visited nodes, and check if we will
	 * visit it again
	 */
//	public ListNode detectCycle(ListNode head) {
//		ListNode node = head;
//		List<ListNode> list = new ArrayList<ListNode>();
//		while (node != null) {
//			if (list.contains(node))
//				return node;
//			list.add(node);
//			node = node.next;
//		}
//		return null;
//	}
}
