package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
	public static void main(String[] args) {
		String a = "234";
		letterCombinations(a);
	}
	static String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	static ArrayList<String> res;
	public static List<String> letterCombinations(String digits) {
		if(digits == null || digits == "")
			return null;
		res = new ArrayList<String>();
		Conbine(digits, "", 0);
		return res;
	}
	public static String Conbine(String input, String str, int index) {
		if(index == input.length()) {
			res.add(str);
			return str;
		}
		
		char c = input.charAt(index);
		int n = c-'0';
		for(int i =0;i<letter_map[n].length();i++) {
			Conbine(input,str+letter_map[n].charAt(i),index+1);
		}
		return null;
	}
	
//	public List<String> letterCombinations(String digits) {
//		List<String> ans = new ArrayList<String>();
//		List<char []> charArrays = new ArrayList<char[]>();
//		
//		for (int i = 0; i < digits.length(); i++) {
//			int n = Integer.parseInt(digits.substring(i, i+1));
//			switch (n) {
//			case 2:
//				charArrays.add(new char[] { 'a', 'b', 'c' });
//				break;
//			case 3:
//				charArrays.add(new char[] { 'd', 'e', 'f' });
//				break;
//			case 4:
//				charArrays.add(new char[] { 'g', 'h', 'i' });
//				break;
//			case 5:
//				charArrays.add(new char[] { 'j', 'k', 'l' });
//				break;
//			case 6:
//				charArrays.add(new char[] { 'm', 'n', 'o' });
//				break;
//			case 7:
//				charArrays.add(new char[] { 'p', 'q', 'r', 's' });
//				break;
//			case 8:
//				charArrays.add(new char[] { 't', 'u', 'v' });
//				break;
//			case 9:
//				charArrays.add(new char[] { 'w', 'x', 'y', 'z' });
//			}
//		}
//	}
}