package stringandinteger;

public class Q7ReverseInteger {
	public static void main(String[] args) {
		int in = -2147483412;
		int res = reverse2(in);
		System.out.println(res);
	}
	/*
	 * Method 2: 
	 * 
	 * Math
	 * 
	 * Results: runtime 1 ms beats 100%
	 * 			memory 35.7 mb beats 65.06%
	 * */
	public static int reverse2(int x) {
		int res = 0;
		while (x != 0) {
			if (res < -214748364 || res == -214748364 && x % 10 >= 9 || res > 214748364
					|| res == 214748364 && x % 10 >= 8)
				return 0;
			res = res * 10 + x % 10;
			x = x / 10;
		}
		return x < 0 ? -1 * res : res;
	}
	
	
	/*
	 * Method 1: 
	 * 
	 * Convert to a string and reverse.
	 * 
	 * Results: runtime 13 ms beats 5%
	 * 			memory 36.8 mb beats 5.06%
	 * */
	public int reverse1(int x) {
		int sigh = x < 0 ? -1 : 1;
		if (x < 0) {
			return reverseStr(String.valueOf(x), 1);
		} else {
			return reverseStr(String.valueOf(x), 0);
		}
	}

	public int reverseStr(String s, int start) {
		String res = "";
		for (int i = s.length() - 1; i >= start; i--) {
			res += s.charAt(i);
		}
		try {
			return start == 1 ? -1 * Integer.parseInt(res) : Integer.parseInt(res);
		} catch (Exception e) {
			return 0;
		}
	}
}
