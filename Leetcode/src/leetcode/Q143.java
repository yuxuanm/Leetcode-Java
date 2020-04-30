package leetcode;

import java.util.Stack;

public class Q143 {
	
	
	/**use a list instead of stack is better.
	 * */
	public void reorderList(ListNode head) {
		int count = 0;
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode node = head;
		while (node != null) {
			count++;
			stack.push(node);
			node = node.next;
		}
		if (count <= 2)
			return;
		int num_operations = count % 2 == 0 ? count / 2 - 1 : count / 2;
		ListNode front = head;
		ListNode front2 = head.next;
		ListNode back;
		for (int i = 0; i < num_operations; i++) {
			back = stack.pop();
			front.next = back;
			back.next = front2;
			front = back.next;
			front2 = front.next;
		}
		if (count % 2 == 0)
			front.next.next = null;
		else
			front.next = null;
	}
}
