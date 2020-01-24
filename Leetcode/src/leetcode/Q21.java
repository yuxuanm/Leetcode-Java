package leetcode;

public class Q21 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		
		ListNode l2 = new ListNode(1);
		l2.next=new ListNode(3);
		l2.next=new ListNode(4);
		mergeTwoLists(l1, l2);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode head = new ListNode(0);
        ListNode res = head;
		while(l1!=null&&l2!=null) {
			if(l1.val>l2.val) {
				res.next=l2;
				l2=l2.next;
			}
			else if(l1.val<=l2.val) {
				res.next=l1;
				l1=l1.next;
			}
				
		}
		if(l1==null)
			res.next=l2;
		if(l2==null)
			res.next=l1;
		return res.next;
	}
}
