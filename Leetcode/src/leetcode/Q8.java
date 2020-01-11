package leetcode;

public class Q8 {
	public static void main(String[] args) {
		String a = "-2147483649";
		System.out.println(myAtoi(a));

	}

	public static int myAtoi(String str) {
		if (str == null)
			return 0;
		str = str.trim();
		if (str == "")
			return 0;
		if (Character.isDigit(str.charAt(0)) || str.startsWith("-") || str.startsWith("+")) {// if not start with
																								// return 0
			if (str.startsWith("-") || str.startsWith("+")) { // if the str startswith a '+' or 'i' sign
				int lengthNoSign = digLength(str.substring(1, str.length()));
				if (str.startsWith("-"))
					return strToInt(str.substring(1, lengthNoSign + 1), true);
				else
					return strToInt(str.substring(1, lengthNoSign + 1), false);
			} else { // str starts with number
				int lengthNoSign = digLength(str);
				return strToInt(str.substring(0, lengthNoSign), false);
			}
		}
		return 0;
	}

	// return effective length
	public static int digLength(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 48 || str.charAt(i) > 57)
				return i;
			if (i == str.length() - 1)
				return i + 1;
		}
		return 0;
	}

	public static int strToInt(String str, boolean isNegative) {
		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			int a = Integer.parseInt(String.valueOf(str.charAt(i)));

			if (isNegative == false && res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && a > 7) {
				return Integer.MAX_VALUE;
			}
			if (isNegative == true && res < -Integer.MIN_VALUE / 10 || res == -Integer.MAX_VALUE / 10 && a > 8) {
				return Integer.MIN_VALUE;
			}
			if (isNegative)
				res = res * 10 - a;
			else
				res = res * 10 + a;
		}
		return res;
	}
}
