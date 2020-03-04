package leetcode;

import java.util.Stack;

public class Q92 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next= new ListNode(5);
		
		ListNode res = reverseBetween(head, 2, 4);
	}
	
	/**Use stack to store the nodes that need to be reversed
	 * */
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		Stack<ListNode> stack = new Stack<ListNode>();
		int index = 1;
		ListNode dummy = new ListNode(0);
		dummy.next=head;
		ListNode cur = head;
		ListNode pre = dummy;
		while (index != m) {
			index++;
			cur = cur.next;
			pre=pre.next;
		}
		ListNode start = pre;
		while (index <= n) {
			stack.push(cur);
			index++;
			cur = cur.next;
		}
		ListNode end = cur;
		while (!stack.isEmpty()) {
			start.next = stack.pop();
			start = start.next;
		}
		start.next = end;
		return dummy.next;
	}
}
