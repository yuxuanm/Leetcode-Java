package leetcode;

public class Q24 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		swapPairs(head);
	}
//	public static ListNode swapPairs(ListNode head) {
//        ListNode first;
//        ListNode second;
//        ListNode pre =new ListNode(0);
//        pre.next=head;
//        ListNode res=pre;
//        while(pre.next!=null&&pre.next.next!=null){
//           first = pre.next;
//           second = first.next;
//           first.next=second.next;
//           pre.next=second;
//           second.next=first;
//           pre=first;
//        }  
//        return res.next;
//   }
	
	//Method 2(From leetcode): 
	public static ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode next = head.next;
		head.next=swapPairs(next.next);
		next.next=head;
		return next;
	}
}
