package stringandinteger;

import java.util.HashMap;
import java.util.Map;

public class Q28ImplementStrStr {
	public static void main(String[] args) {
		String haystack = "babba";
		String needle = "bbb";
		int res = strStr(haystack, needle);
		System.out.println(res);
	}

	public static int strStr(String haystack, String needle) {
		if (needle.equals(""))
			return 0;
		Map<Character, Integer> moveMap = new HashMap<Character, Integer>();
		for (int i = 0; i < needle.length(); i++) {
			if(i==needle.length()-1 && moveMap.containsKey(needle.charAt(i)))
				break;
			else
				moveMap.put(needle.charAt(i), needle.length() - i - 1);
		}
		int len = haystack.length() - needle.length();
		int i=0;
		
		while(i<= haystack.length() - needle.length()) {
			char c1=haystack.charAt(i) ;
			char c2 = needle.charAt(0);
			if (haystack.charAt(i) == needle.charAt(0)) {
				int j = 0;
				while (haystack.charAt(i + j) == needle.charAt(j)) {
					if (j == needle.length() - 1)
						return i;
					else
						j++;
				}
				// char c=
				boolean flag = moveMap.containsKey(haystack.charAt(i+needle.length()-1));
				i += moveMap.containsKey(haystack.charAt(i+needle.length()-1)) ? moveMap.get(haystack.charAt(i+needle.length()-1)) : needle.length();
				continue;
			}
			i++;
		}
		return -1;
	}
}
