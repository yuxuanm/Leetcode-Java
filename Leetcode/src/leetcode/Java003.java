package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Java003 {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	 public static int lengthOfLongestSubstring(String s) {
	        int cnt = 0;
	        int max = 0;
	        if ( s == null)
	            return 0;
	        Set<Character> set = new HashSet<Character>();
	        char [] arr = s.toCharArray();
	        outer:for(int i =0;i<arr.length;i++){
	            set.clear();
	            cnt = 0;
	            for(int j=i;j<arr.length;j++){
	                if(set.contains(arr[j])){
	                    max = cnt>max?cnt:max;
	                    continue outer;
	            }
	                else{
	                    set.add(arr[j]);
	                    cnt++;
	                }
	                if(j==arr.length-1){
	                     max = cnt>max?cnt:max;
	                }
	            }
	        }
	        return max;
	    }
}
