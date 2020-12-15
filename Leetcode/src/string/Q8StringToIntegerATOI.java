package string;

public class Q8StringToIntegerATOI {
	public static void main(String[] args) {
		String s = "2147483648";
		int res = myAtoi(s);
		System.out.println(res);
	}

	
	/*
	 * Method 1:
	 * 
	 * 1. Check first non-space character, if not '-', '+' or numeric number, then 
	 * return 0 directly.
	 * 2. Check start sign, conver str to int.
	 * 
	 * Results: runtime 3 ms beats 51.79% memory 38.5 mb beats 75.25%
	 */
	public static int myAtoi(String s) {
		s = s.trim();
		if (s.length() == 0 || s.charAt(0) < 48 || s.charAt(0) > 57) {
			if (!s.startsWith("-") && !s.startsWith("+"))
				return 0;
		}
		if (s.startsWith("-"))
			return strToInt(s, 1, s.length() - 1);
		else if (s.startsWith("+"))
			return strToInt(s.substring(1, s.length()), 0, s.length() - 2);
		else
			return strToInt(s, 0, s.length() - 1);
	}

	private static int strToInt(String s, int start, int end) {
		int res = 0;
		for (int i = start; i <= end; i++) {
			if (s.charAt(i) < 48 || s.charAt(i) > 57)
				return start == 1 ? -1 * res : res;
			// Check boundary condition
			else if (res > 214748364 || res == 214748364 && start == 1 && Character.getNumericValue(s.charAt(i)) > 8
					|| res == 214748364 && start == 0 && Character.getNumericValue(s.charAt(i)) > 7)
				return start == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			else
				res = res * 10 + Character.getNumericValue(s.charAt(i));
		}
		return start == 1 ? -1 * res : res;
	}
}
