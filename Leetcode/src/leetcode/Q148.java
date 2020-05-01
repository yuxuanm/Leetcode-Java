package leetcode;

public class Q148 {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next=new ListNode(1);
		head.next.next.next=new ListNode(3);
		ListNode res = sortList(head);
	}

	/**Method 1: use merge sort as the complexity requirement is O(nlogn)
	 * */
	public static ListNode sortList(ListNode head) {
		return head == null ? null : mergeSort(head);
	}

	private static ListNode mergeSort(ListNode node) {
		if (node.next == null)
			return node;

		ListNode fast = node;
		ListNode slow = node;
		ListNode pre = null;
		while (fast != null && fast.next != null) { //find the middle node
			pre = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		pre.next = null;
		ListNode left = mergeSort(node);;
		ListNode right = mergeSort(slow);
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				node.next = left;
				left = left.next;
			} else {
				node.next = right;
				right = right.next;
			}
			node = node.next;
		}

		if (left != null) {
			node.next = left;
		}
		if (right != null) {
			node.next = right;
		}
		return dummy.next;
	}
}
