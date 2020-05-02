package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q151 {
	public static void main(String[] args) {
		String s="a good   example";
		String res = reverseWords(s);
	}
	
	public static String reverseWords(String s) {
		List<String> list = new ArrayList<String>(Arrays.asList(s.split("\\s+")));
		Collections.reverse(list);
		return String.join(" ", list);
	}
	
//	public static String reverseWords(String s) {
//		String[] arr = s.split(" ");
//		String res = "";
//		for (String a : arr) {
//			if(a.equals(""))
//				continue;
//			res = a + " " + res;
//		}
//		return res;
//	}
}
