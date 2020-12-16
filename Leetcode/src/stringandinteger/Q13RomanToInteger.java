package stringandinteger;

import java.util.HashMap;
import java.util.Map;

public class Q13RomanToInteger {
	public static void main(String[] args) {
		String s = "III";
		int res = romanToInt(s);
		System.out.println(res);
	}
	
	
	/*
	 * Method 1:
	 * 
	 * Check whether 'I', 'X', and 'C' is followed by specific characters
	 * 
	 * Results: runtime: 73 ms beats 92.53% 
	 * 			memory: 39.2 mb beats 33.59%
	 * 
	 */
	public static int romanToInt(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1)
				res += map.get(String.valueOf(s.charAt(i)));
			char c = s.charAt(i);
			if (c == 'I' && s.charAt(i + 1) == 'V' || c == 'I' &&s.charAt(i + 1) == 'X') {
				res += map.get(s.substring(i, i + 2));
				i++;
				continue;
			}
			if (c == 'X' && s.charAt(i + 1) == 'L' ||c == 'X' && s.charAt(i + 1) == 'C') {
				res += map.get(s.substring(i, i + 2));
				i++;
				continue;
			}
			if (c == 'C' && s.charAt(i + 1) == 'D' ||c == 'C' && s.charAt(i + 1) == 'M') {
				res += map.get(s.substring(i, i + 2));
				i++;
				continue;
			}
			res += map.get(String.valueOf(c));
		}
		return res;
	}
}
