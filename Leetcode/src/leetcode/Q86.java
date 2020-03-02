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
	/**Method 1: three pointers
	 * 			flag = false, there is no node matching the criteria
	 * 			flag = true, there are some nodes matching the criteria 
	 * */
	public ListNode partition(ListNode head, int x) {
		ListNode largeDunny = new ListNode(0);
		ListNode smallDunny = new ListNode(0);
		largeDunny.next = head;
		smallDunny.next = head;
		ListNode cur = head;
		ListNode smallPre = smallDunny;
		ListNode largePre = largeDunny;
		boolean smallFlag = false;
		boolean largeFlag = false;
		while (cur != null) {
			if (cur.val >= x) {
				largeFlag=true;
				largePre.next = cur;
				largePre = cur;
				cur = cur.next;
				largePre.next=null;
			} else {
				smallFlag=true;
				smallPre.next=cur;
				smallPre=cur;
				cur=cur.next;
				smallPre.next=null;
			}
		}
		if(!smallFlag)
			return largeDunny.next;
		if(!largeFlag)
			return smallDunny.next;
		
		smallPre.next=largeDunny.next;

		return smallDunny.next;
	}

//	public ListNode partition(ListNode head, int x) {
//		ListNode dunny = new ListNode(0);
//		dunny.next = smallPartition(head, x);
//		ListNode cur = dunny.next;
//		while (cur.next != null)
//			cur = cur.next;
//		cur.next = largePartition(head, x);
//
//		return dunny.next;
//	}
//
//	private ListNode largePartition(ListNode head, int x) {
//		ListNode dunny = new ListNode(0);
//		dunny.next = head;
//		ListNode pre = dunny;
//		ListNode cur = head;
//		while (cur != null) {
//			if (cur.val < x)
//				cur = cur.next;
//			else {
//				pre.next = cur;
//				pre = cur;
//				cur = cur.next;
//			}
//		}
//		pre.next = null;
//		return dunny.next;
//	}
//
//	private ListNode smallPartition(ListNode head, int x) {
//		ListNode dunny = new ListNode(0);
//		dunny.next = head;
//		ListNode pre = dunny;
//		ListNode cur = head;
//		while (cur != null) {
//			if (cur.val >= x)
//				cur = cur.next;
//			else {
//				pre.next = cur;
//				pre = cur;
//				cur = cur.next;
//			}
//		}
//		pre.next = null;
//		return dunny.next;
//	}
}
