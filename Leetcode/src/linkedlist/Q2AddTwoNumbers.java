package linkedlist;

import structures.ListNode;

public class Q2AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		// ListNode l1 = new ListNode(2);
		// l1.next = new ListNode(4);
		// l1.next.next = new ListNode(3);
		//
		// ListNode l2 = new ListNode(5);
		// l2.next = new ListNode(6);
		// l2.next.next = new ListNode(4);

		ListNode res = addTwoNumbers2(l1, l2);
		System.out.println(11 % 10);
	}

	/*
	 * Method 1:
	 * 
	 * Covert each ListNode to a long number, then add them up. And
	 * convert the sum back to a LinkNode.
	 * 
	 * Results: can only pass 1565/1568 test samples. For extreme cases, ie,
	 * when the ListNode has very large input length, the sum will out of the
	 * range of long.
	 * 
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		long in1 = ListNodetoInt(l1);
		long in2 = ListNodetoInt(l2);
		long res = in1 + in2;
		int len = String.valueOf(res).length();
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		for (int i = len - 1; i >= 0; i--) {
			node.next = new ListNode(Character.getNumericValue(String.valueOf(res).charAt(i)));
			node = node.next;
		}
		return dummy.next;
	}

	public long ListNodetoInt(ListNode l) {
		String res = "";
		ListNode node = l;
		while (node != null) {
			res = node.val + res;
			node = node.next;
		}
		return Long.parseLong(res);
	}

	/*
	 * Method 2:
	 * 
	 * Covert each ListNode to a string, then from the end of two strings, add
	 * each character one by one.
	 * 
	 * Results: runtime 17 ms beats 22.81%
	 * 			memory 39.1 mb beats 25.37%
	 * 
	 */
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode node = dummy;

		String s1 = ListNodetoString(l1);
		String s2 = ListNodetoString(l2);

		String longStr = s1.length() >= s2.length() ? s1 : s2;
		String shortStr = s1.length() >= s2.length() ? s2 : s1;

		int lenDiff = Math.abs(s1.length() - s2.length());
		int flag = 0;
		int index = Math.max(s1.length(), s2.length()) - 1;

		while (index - lenDiff >= 0) {
			int tmp = Character.getNumericValue(longStr.charAt(index))
					+ Character.getNumericValue(shortStr.charAt(index - lenDiff)) + flag;
			node.next = new ListNode(tmp % 10);
			if (tmp >= 10)
				flag = 1;
			else
				flag = 0;
			node = node.next;
			index--;
		}
		while (index >= 0) {
			int tmp = Character.getNumericValue(longStr.charAt(index)) + flag;
			node.next = new ListNode(tmp % 10);
			if (tmp >= 10)
				flag = 1;
			else
				flag = 0;
			node = node.next;
			index--;
		}
		if (flag == 1)
			node.next = new ListNode(1);
		return dummy.next;
	}

	public static String ListNodetoString(ListNode l) {
		String res = "";
		while (l != null) {
			res = l.val + res;
			l = l.next;
		}
		return res;
	}

}
