package leetcode;

public class Java160 {
//	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		if (headA == null || headB == null)
//			return null;
//		ListNode B = headB;
//		while (headA != null) {
//			while (B != null) {
//				if (B == headA)
//					return B;
//				B = B.next;
//			}
//			B = headB;
//			headA = headA.next;
//		}
//		return null;
//	}

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		a.next=new ListNode(3);
		
		ListNode b= new ListNode(3);
		System.out.println(getIntersectionNode(a, b));
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode a = headA;
		ListNode b = headB;

		while (a != b) {
			if (a == null)
				a = headB;
			if (b == null)
				b = headA;
			a = a.next;
			b = b.next;
		}

		return a;
	}
}