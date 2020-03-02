package leetcode;

public class Q86 {
	public static void main(String[] args) {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(2);

		Q86 q86 = new Q86();
		ListNode res = q86.partition(null, 2);
	}
	
	/**Method 1 optimized: two pointers
	 * */
	public ListNode partition(ListNode head, int x) {
		ListNode largeDummy = new ListNode(0);
		ListNode largePre = largeDummy;
		ListNode smallDummy = new ListNode(0);
		ListNode smallPre = smallDummy;
		ListNode cur = head;

		while (cur != null) {
			if (cur.val >= x) {
				largePre.next = cur;
				largePre = cur;
				cur = cur.next;
			} else {
				smallPre.next=cur;
				smallPre=cur;
				cur=cur.next;
			}
		}

		largePre.next=null; // in case of there might be some nodes smaller than x after the last large node
		
		smallPre.next=largeDummy.next;

		return smallDummy.next;
	}
	
	
//	/**Method 1: three pointers
//	 * 			flag = false, there is no node matching the criteria
//	 * 			flag = true, there are some nodes matching the criteria 
//	 * */
//	public ListNode partition(ListNode head, int x) {
//		ListNode largeDummy = new ListNode(0);
//		ListNode smallDummy = new ListNode(0);
//		largeDummy.next = head;
//		smallDummy.next = head;
//		ListNode cur = head;
//		ListNode smallPre = smallDummy;
//		ListNode largePre = largeDummy;
//		boolean smallFlag = false;
//		boolean largeFlag = false;
//		while (cur != null) {
//			if (cur.val >= x) {
//				largeFlag=true;
//				largePre.next = cur;
//				largePre = cur;
//				cur = cur.next;
//				largePre.next=null;
//			} else {
//				smallFlag=true;
//				smallPre.next=cur;
//				smallPre=cur;
//				cur=cur.next;
//				smallPre.next=null;
//			}
//		}
//		if(!smallFlag)
//			return largeDummy.next;
//		if(!largeFlag)
//			return smallDummy.next;
//		
//		smallPre.next=largeDummy.next;
//
//		return smallDummy.next;
//	}
}
