package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q109 {
	public static void main(String[] args) {
		ListNode d = new ListNode(-10);
		d.next=new ListNode(-3);
		d.next.next=new ListNode(0);
		d.next.next.next=new ListNode(5);
		d.next.next.next.next=new ListNode(9);
		
		TreeNode root = sortedListToBST(d);
	}

	/** Method 1:
	 *  Steps: 1. change the ListNodes to a int array
	 *         2. find the mid value as root, and then left array smaller than root, right array larger than root
	 *         3. recursive
	 *  improvement: change the listNode to a list, and then call sublist method.
	 * */
	 public static TreeNode sortedListToBST(ListNode head) {
	        int cnt = 0;
	        ListNode node = head;
	        while(node!=null){
	        	cnt++;
	        	node=node.next;
	        }
	        int arr[] = new int [cnt];
	        cnt = 0;
	        while(head!=null) {
	        	arr[cnt] = head.val;
	        	head = head.next;
	        	cnt++;
	        }
	        
	        TreeNode root = helper(arr);
	        return root;
	    }
	    
	    public static TreeNode helper(int [] arr){
	        if(arr.length ==0)
	            return null;
	        TreeNode node = new TreeNode(arr[arr.length/2]);
	        int[] left = Arrays.copyOfRange(arr,0,arr.length/2);
	        int[] right = Arrays.copyOfRange(arr,arr.length/2+1,arr.length);
	        
	        node.left=helper(left);
	        node.right = helper(right);
	        
	        return node;
	    }
}
