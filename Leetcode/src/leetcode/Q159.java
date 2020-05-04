package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q159 {
	public static void main(String[] args) {
		String s = "ababcbcbaaabbdef";
		int res = lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(res);
	}

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s.length()<3)
			return s.length();
		int res = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		int left=0,right = 0;
		while(right<s.length()) {
			if(map.size()<3) {
				map.put(s.charAt(right), right++);
			}
			if(map.size()==3) {
				int minleft = Collections.min(map.values());
				map.remove(s.charAt(minleft));
				left=minleft+1;
			}
			res=Math.max(res, right-left);
		}
		return res;
	}
	
	/**Method 1: complexity O(n^2)
	 * */
//	public static int lengthOfLongestSubstringTwoDistinct(String s) {
//		if (s.length() <= 2)
//			return s.length();
//		int res = 0;
//		int tmpres=0;
//		List<Character> list = new ArrayList<Character>();
//		for (int i = 0; i < s.length() - 1; i++) {
//			list.clear();
//			tmpres = 1;
//			list.add(s.charAt(i));
//			for (int j = i + 1; j < s.length(); j++) {
//				if(j==s.length()-1) {
//					if(list.contains(s.charAt(j))||list.size()<2) {
//						res = Math.max(res, j-i+1);
//						break;
//					}
//					else {
//						res = Math.max(res, j-i);
//						break;
//					}
//				}
//				if (!list.contains(s.charAt(j)) && list.size() == 2) {
//					res = Math.max(tmpres, res);
//					break;
//				}else {
//					if(!list.contains(s.charAt(j)))
//						list.add(s.charAt(j));
//					tmpres++;
//				}
//			}
//		}
//		return res;
//	}
}
