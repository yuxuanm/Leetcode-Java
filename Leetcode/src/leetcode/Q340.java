package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q340 {
	
	public static void main(String[] args) {
		String s = "eceba";
		int k = 2;
		int res = lengthOfLongestSubstringKDistinct(s, k);
		System.out.println(res);
	}
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length()<k+1)
            return s.length();
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        int left =0,right = 0;
        int res = 0;
        while(right<s.length()){
            if(map.containsKey(s.charAt(right))){
                map.remove(s.charAt(right));
            }
            map.put(s.charAt(right),right++);
            if(map.size()==k+1){
                char leftKey = map.entrySet().iterator().next().getKey();
                int minIndex = map.get(leftKey);
                map.remove(leftKey);
                left = minIndex+1;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
	/**Method 1: sliding window. similar to question 159
	 * */
//	public int lengthOfLongestSubstringKDistinct(String s, int k) {
//        if(s.length()<k+1)
//            return s.length();
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        int left =0,right = 0;
//        int res = 0;
//        while(right<s.length()){
//            if(map.size()<k+1)
//                map.put(s.charAt(right),right++);
//            if(map.size()==k+1){
//                int minIndex = Collections.min(map.values());// get the index of leftmost character
//                map.remove(s.charAt(minIndex));
//                left = minIndex+1;
//            }
//            res = Math.max(res,right-left);
//        }
//        return res;
//    }
}
