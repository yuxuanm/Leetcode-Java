package leetcode;

public class Q19 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next=new ListNode(2);
		removeNthFromEnd(head, 1);
	}
//	Method 1:one pointer
//	public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode node = head;
//        int total=0;
//        int index = 1;
//        while(node !=null){
//            total++;
//            node = node.next;
//        }
//        node = head;
//        int deleteIndex =total - n+1;
//        if(n == total)
//        	return head.next;
//        while(index!=deleteIndex-1){
//            node = node.next;
//            index++;
//        }
//        node.next = node.next.next;
//        return head;
//    }
	//Method 2: two pointers
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int index=0;
		ListNode node = head;
		while(index!=n) {
			node = node.next;
			index ++;
		}
		ListNode node2=head;
		while(node.next != null) {
			node = node.next;
			node2=node2.next;
		}
			
		node2.next=node2.next.next;
		return head;
	}
}
