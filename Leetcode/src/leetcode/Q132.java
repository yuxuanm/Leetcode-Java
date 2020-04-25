package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q132 {

	public static void main(String[] args) {
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s = "aaaaabbaaa";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'a')
				System.out.println(i);
		}
		System.out.println(s.length());

		int res = minCut(s);
		System.out.println(res);
	}

	/** Method 2 modified: change to another dp function.
	 *
	 */
	public static int minCut(String s) {
		int[] res = new int[s.length()];
		if (s.equals(""))
			return 0;
		for (int i = 0; i < s.length(); i++) {
			res[i] = i;
			if (isPalindrome(s.substring(0, i + 1))) {
				res[i] = 0;
				continue;
			}
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s.substring(j, i + 1)))
					res[i] = Math.min(res[i], res[j - 1] + 1);
			}
		}

		return res[s.length() - 1];
	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	/**
	 * Method 2: most cases right dynamic programming. when s
	 * ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
	 * is wrong
	 */
//	public static int minCut(String s) {
//		int[] res = new int[s.length() + 1];
//		res[0] = 0;
//		for (int i = 0; i < s.length(); i++) {
//			int start = longestParlindromeFromEnd(s, i);
//			if (start == 0) {
//				res[i + 1] = 0;
//				System.out.println(res[i+1]);
//			}
//			else {
//				res[i + 1] = (1 + res[start]) < (res[i] + 1) ? (1 + res[start]) : (res[i] + 1);
//				int a = 1 + res[start];
//				int b = res[i] + 1;
//				int c = res[i + 1];
////				System.out.println(res[i-1]);
////				System.out.println(res[i]);
//				if(res[i+1]==2) {
//					System.out.println(i);
//					break;
//				}
//				System.out.println(res[i+1]);
//			}
//		}
//
//		return res[s.length()];
//	}
//
//	public static int longestParlindromeFromEnd(String s, int end) {
//		for (int i = 0; i < end; i++) {
//			if (isPalindrome(s.substring(i, end + 1)))
//				return i;
//		}
//		return end;
//	}
//
//	public static boolean isPalindrome(String s) {
//		int start = 0;
//		int end = s.length() - 1;
//		while (start < end) {
//			if (s.charAt(start++) != s.charAt(end--))
//				return false;
//		}
//		return true;
//	}

	/**
	 * Method 1: similar to Q131, slightly modify the base function. Results: out of
	 * run time limit when dealing with a very long string.
	 */
//	public int minCut(String s) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		if (s == "" || s == null)
//			return 0;
//		backtrack(s, new ArrayList<String>(), res);
//		int min = Integer.MAX_VALUE;
//		for (List<String> l : res) {
//			min = l.size() < min ? l.size() : min;
//		}
//
//		return min - 1;
//	}
//
//	public static void backtrack(String s, List<String> list, List<List<String>> res) {
//		if (s.equals(""))
//			res.add(new ArrayList<String>(list));
//		for (int i = 0; i < s.length(); i++) {
//			if (isPalindrome(s.substring(0, i + 1))) {
//				list.add(s.substring(0, i + 1));
//				backtrack(s.substring(i + 1, s.length()), list, res);
//				list.remove(list.size() - 1);
//			}
//
//		}
//
//	}
//
//	public static boolean isPalindrome(String s) {
//		int start = 0;
//		int end = s.length() - 1;
//		while (start < end) {
//			if (s.charAt(start++) != s.charAt(end--))
//				return false;
//		}
//		return true;
//	}
}
