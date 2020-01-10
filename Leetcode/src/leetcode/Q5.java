package leetcode;

public class Q5 {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		if (s == null)
			return null;
		
		return new String(longest(2,s).length()>longest(1,s).length()?longest(2,s):longest(1, s));
	}
	
	//start from the middle of the palindrome string
	//start--; end++; 
	public static String longest(int startLength, String s) {
		int start,end,cur;
		int max = 0;
		String maxStr="";
		outer: for (int i = 0; i < s.length(); i++) {
			start = i;
			end = i+(startLength-1);
			cur = startLength;
			while (start >= 0 && end <= s.length() - 1) {
				if (s.charAt(start) == s.charAt(end)) {
					start--;
					end++;
					cur += 2;
				}
				else {
					if (max < cur - 2) {
						max = cur - 2;
						maxStr = s.substring(start + 1, end);
					}
					start--;
					end++;
					continue outer;
				}

			} // if reach the end of the boundary
			if (max < cur - 2) {
				max = cur - 2;
				maxStr = s.substring(start + 1, end);
			}
		}
		return maxStr;
	}
}
