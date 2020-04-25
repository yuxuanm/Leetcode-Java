package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
	
	
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> res = partition(s);
	}
	
	/**Method: use backtrack. start from first character of the string s.
	 * Results : runtime: 5ms memory: 40.5 MB
	 * */
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == "" || s == null)
			return res;
		backtrack(s, new ArrayList<String>(), res);
		return res;
	}

	public static void backtrack(String s, List<String> list, List<List<String>> res) {
		if (s.equals(""))
			res.add(new ArrayList<String>(list));
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i + 1))) {
				list.add(s.substring(0, i + 1));
				backtrack(s.substring(i + 1, s.length()),list,res);
				list.remove(list.size() - 1);
			}

		}

	}

	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length()-1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}
