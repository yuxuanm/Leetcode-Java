package stringandinteger;

public class Q14LogestCommonPrefix {

	public static void main(String[] args) {
		String strs [] = new String[] {"flower","flow","flight"};
		String res = longestCommonPrefix2(strs);
		System.out.println(res);
	}

	/*
	 * Method 2:
	 * 
	 * Firstly, get the longest common str between the first two string, and then 
	 * find the longest common string between that str and the 3rd string and so on.
	 * 
	 * Results: runtime 0ms beats 100% memory 36.5mb beats 80.32%.
	 * */
	public static String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0 || strs == null)
			return "";
		if (strs.length == 1)
			return strs[0];
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			res = longestCommonStr(res, strs[i]);
		}
		return res;
	}

	private static String longestCommonStr(String str1, String str2) {
		int index = 0;
		int len = str1.length() < str2.length() ? str1.length() : str2.length();
		while(index<len) {
			if (str1.charAt(index) != str2.charAt(index))
				return str1.substring(0, index);
			index++;
		}
		return str1.substring(0,index );
	}

	/*
	 * Method 1:
	 * 
	 * Compare all strings character by character gradually.
	 * 
	 * Results: runtime 1ms beats 87.55% memory 36.7mb beats 58.93%.
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		int res = 0;
		int index = 0;
		boolean flag = false;
		try {
			while (true) {
				char c = strs[0].charAt(index);
				for (String s : strs) {
					if (s.charAt(index) != c) {
						if (index == 0 && flag == false)
							return "";
						else
							return strs[0].substring(0, index);
					}
				}
				index++;
				flag = true;
			}
		} catch (Exception e) {
			if (index == 0 && flag == false)
				return "";
			else
				return strs[0].substring(0, index);
		}
	}
}
