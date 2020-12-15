package stringandinteger;

public class Q9PalindromeNumber {
	/*
	 * Method 1:
	 * 
	 * Check sign, if negative then return false;
	 * else, change to a string and compare from start and end;
	 * 
	 * Results: runtime 11 ms beats 49.17% memory 37.9 mb beats 71.32%
	 * 
	 */
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		String s = String.valueOf(x);
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}
