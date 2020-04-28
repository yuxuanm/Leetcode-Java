package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {
	public static void main(String[] args) {
		String s = "leetcode";
//		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
//		wordDict.add("a");
//		wordDict.add("aa");
//		wordDict.add("aaa");
//		wordDict.add("aaaa");
//		wordDict.add("aaaaa");
//		wordDict.add("aaaaaa");
//		wordDict.add("aaaaaaa");
//		wordDict.add("aaaaaaaa");
//		wordDict.add("aaaaaaaaa");
//		wordDict.add("aaaaaaaaaa");
		System.out.println(wordBreak(s, wordDict));
	}
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean res [] = new boolean[s.length()+1];
		res[0]= true;
		Set<String> set = new HashSet<String>(wordDict);
		for(int i=0;i<s.length();i++) {
			for(int j = 0;j<=i;j++) {
				if(res[j]==true&&set.contains(s.substring(j, i+1)))
					res[i+1]= true;
			}
		}
		return res[s.length()];
    }
	/**Method 2:
	 * bether than method 1, use hashset to check string
	 * result still out of memory
	 * */
//	public static boolean wordBreak(String s, List<String> wordDict) {
//		return helper(s, new HashSet<String>(wordDict));
//	}
//
//	private static boolean helper(String s, HashSet<String> set) {
//		if (s.length() == 0)
//			return true;
//		for (int i = 0; i < s.length(); i++) {
//			if (set.contains(s.substring(0, i + 1))&&helper(s.substring(i+1,s.length()),set)) {
//				return true;
//			}
//		}
//
//		return false;
//	}
	/**Method 1:
	 * Results out of memory
	 */
//	public static boolean wordBreak(String s, List<String> wordDict) {
//		return helper(s, wordDict);
//	}
//
//	public static boolean helper(String str, List<String> wordDict) {
//		if (str.length() == 0)
//			return true;
//		for (int i = 0; i < str.length(); i++) {
//			String subStr = str.substring(0, i + 1);
//			for (String word : wordDict) {
//				if (word.equals(subStr)) {
//					if (helper(str.substring(i + 1, str.length()), wordDict))
//						return true;
//					helper(str.substring(i + 1, str.length()), wordDict);
//				}
//			}
//
//		}
//
//		return false;
//	}
}
