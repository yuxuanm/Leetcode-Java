package leetcode;

public class Q61 {

	/**1.first find the length of the ListNode;
	 * 2.for int k, we actually rotate k%length;
	 * 3.rotate the ListNode k%length times;
	 * result: runtime 1ms beats 97.78%
	 *         memory 38.5 Mb beats 5.04% 
	 * */
	public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        int len = listNodeLength(head);
        int residue = k%len; 
        for(int i=1;i<=residue;i++){
            head=changeOne(head);
        }
        return head;
    }
    
    //this method is going to rotate the list once
    private ListNode changeOne(ListNode head){
        ListNode last = head;
        ListNode secondToLast=null;
        while(last.next!=null){
            secondToLast = last;
            last=last.next;
        }
        
        secondToLast.next=null;
        last.next=head;
        return last;
    }
    
    //return the length of the ListNode
    private int listNodeLength(ListNode head){
        int len=1;
        while(head.next!=null){
            head=head.next;
            len++;
        }
        return len;
    }

}
