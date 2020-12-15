package stringandinteger;

public class Q5LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "tattarrattat";
		String res = longestPalindrome(s);
		System.out.println(res);
	}

	/*
	 * Method 1:
	 * 
	 * Start form middle: every character in string is a possible center of 
	 * the longest palindromic substring. Check the longest substring for each
	 * center.
	 * 
	 * Results: runtime 34 ms beats 78.55% 
	 * 			memory 39.2 mb beats 54.13%
	 * 
	 */
	public static String longestPalindrome(String s) {
		if (s == null)
			return null;
		if (s.length() == 1)
			return s;
		String res = "";
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] tmp = expandFromMiddle(s, i, i);
			if (tmp[0] > max) {
				res = s.substring(tmp[1], tmp[2] + 1);
				max = tmp[0];
			}
			int[] tmp2 = expandFromMiddle(s, i, i + 1);
			if (tmp2[0] > max) {
				res = s.substring(tmp2[1], tmp2[2] + 1);
				max = tmp2[0];
			}
		}
		return res;
	}

	public static int[] expandFromMiddle(String s, int left, int right) {
		/**
		 * @return : an int array length of 3, first component represents
		 *         length, second component represents start index, last
		 *         component represents end index
		 */
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		if (left != -1 && right != s.length() && s.charAt(left) == s.charAt(right) || left == right)
			return new int[] { right - left + 1, left, right };
		else
			return new int[] { right - left - 1, left + 1, right - 1 };
	}
}
