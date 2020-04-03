package leetcode;

public class Q8DailyPractice {
	public static void main(String[] args) {
		String s = "2147483648";
		System.out.println(myAtoi(s));
	}
	public static int myAtoi(String str) {
		str = str.trim();
		if (str.length() == 0 )
			return 0;
		int res = 0;
		int index;
		if (str.charAt(0) == '-') {
			index = 1;
			while (index < str.length() && str.charAt(index) <= 57 && str.charAt(index) >= 48) {
				if (res > 214748365 || res >= 214748364 && str.charAt(index) - '0' > 8)
					return Integer.MIN_VALUE;
				res = res * 10 + (str.charAt(index) - '0');
				index++;
			}
			return -res;
		} else {
			index = str.charAt(0)=='+'?1:0;
			while (index < str.length() && str.charAt(index) <= 57 && str.charAt(index) >= 48) {
				if (res > 214748365 || res >= 214748364 && str.charAt(index) - '0' > 7)
					return Integer.MAX_VALUE;
				res =res * 10 + (str.charAt(index) - '0');
				index++;
			}
		}

		return res;
	}
}
