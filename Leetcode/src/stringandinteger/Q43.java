package stringandinteger;

import java.util.ArrayList;
import java.util.List;

public class Q43 {
	public static void main(String[] args) {
		String s1 = "123";
		String s2 = "456";
		String res = multiply(s1, s2);
		System.out.println(res);
	}
	
	
	/*
	 * Method 1
	 * 
	 * For instance, num1="456", num2="123"
	 * First step results, a list contains
	 * 	000738
	 * 	006150
	 * 	049200
	 * 
	 * Step two, add the number in list 
	 * 	000738 + 006150 + 049200 = 056088 = 56088
	 * 
	 * Results: runtime 42 ms beats 9.41% memory 39.1mb beats 10.25%.
	 * */
	public static String multiply(String num1, String num2) {
		String s = num1.length() < num2.length() ? num1 : num2;
		String l = num1.length() >= num2.length() ? num1 : num2;
		List<String> tmpres = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				builder.append(0);
			}
			int s_dig = s.charAt(s.length() - i - 1) - '0';
			int jinwei = 0;
			for (int j = 0; j < l.length(); j++) {
				int l_dig = l.charAt(l.length() - j - 1) - '0';
				builder.insert(0, (s_dig * l_dig + jinwei) % 10);
				jinwei = (s_dig * l_dig + jinwei) / 10;
			}
			if (jinwei != 0)
				builder.insert(0, jinwei);
			
			// insert zeros in front of each string
			int NumOfZeros = num1.length() + num2.length() - builder.length();
			for (int j = 0; j < NumOfZeros; j++) { 
				builder.insert(0, 0);
			}
			tmpres.add(builder.toString());
			builder.delete(0, builder.length());
		}
		
		
		// Add all string in list
		int jinwei = 0;
		int tmp = 0;
		int len = num1.length() + num2.length();
		for (int i = 0; i < len; i++) {
			tmp = jinwei;
			jinwei = 0;
			for (int j = 0; j < tmpres.size(); j++) {
				int a = tmpres.get(j).charAt(len - i - 1) - '0';
				jinwei = (tmp + a) / 10 + jinwei;
				tmp = (tmp + a) % 10;
			}
			builder.insert(0, tmp);
			tmp = 0;
		}
		if (builder.charAt(0) == '0')
			builder.deleteCharAt(0);
		
		return builder.toString();
	}
}
