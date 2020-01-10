package leetcode;

public class Java002 {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);

//		ListNode l2 = new ListNode(1);
//		ListNode cur = l2;
//		for (int i=1;i<=9;i++) {
//			cur.next = new ListNode(9);
//			cur = cur.next;
//		}
		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);

		System.out.println(addTwoNumbers(l1, l2));
		char c2 = '5';
		char c = '2';
		System.out.println(Integer.parseInt(String.valueOf(c))+Integer.parseInt(String.valueOf(c2)));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String s1 = "";
		String s2 = "";
		if (l1 == null && l2 == null)
			return null;
		ListNode h1 = l1;
		ListNode h2 = l2;
		while (h1 != null) {
			s1 = h1.val+s1;
			h1 = h1.next;
		}
		while (h2 != null) {
			s2 = h2.val+s2;
			h2 = h2.next;
		}

//		int res = Integer.parseInt(s1) + Integer.parseInt(s2);
		return makeListNode(s1,s2);
	}
	public static ListNode makeListNode(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1>len2) {
			for(int i =0;i<len1-len2;i++) {
				s2=0+s2;
			}
		}else {
			for(int i = 0;i<len2-len1;i++) {
				s1=0+s1;
			}
		}
		char [] arr1 = s1.toCharArray();
		char [] arr2 = s2.toCharArray();
		boolean flag = false;
		
		ListNode head = null;
		ListNode pre = null;
		ListNode node = null;
		for(int i=0;i<s1.length();i++) {
			int n = Integer.parseInt(String.valueOf(arr1[s1.length()-1-i]))+Integer.parseInt(String.valueOf(arr2[s1.length()-1-i]));
			if(flag == true) {
				n+=1;
				flag = false;
			}
			if(n>9) {
				n%=10;
				flag = true;
			}
				node = new ListNode(n);
			if(i==0) {
				head = node;
				pre = node;
			}else {
			pre.next = node;
			pre = node;
			}
			if(i==s1.length()&&flag == true)
                pre.next = new ListNode(1);
		}
		
		return head;
	}
	public static ListNode makeListNode(int n) {
		char[] arr = String.valueOf(n).toCharArray();
		int size = arr.length;
		ListNode pre = null;
		ListNode head = null;
		for (int i = 0; i < size; i++) {
			ListNode cur = new ListNode(Integer.parseInt(String.valueOf(arr[size - i - 1])));
			if (i == 0) {
				head = cur;
				pre = cur;
				continue;
			}
			pre.next = cur;
			pre = cur;
		}
		return head;
	}
}
