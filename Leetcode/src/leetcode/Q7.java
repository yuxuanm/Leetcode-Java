package leetcode;

public class Q7 {
	public static void main(String[] args) {
		int x = 1534236469;
		System.out.println(reverse(x));
	}

	public static int reverse(int x) {
		int res = 0;
		while (x != 0) {
			int a = x % 10;
			// cant write if(res*10>Math.pow(2,31)) here
			if (res > Math.pow(2, 31) / 10 || res > Math.pow(2, 31) / 10 && a > 7)
				return 0;
			if (res < -Math.pow(2, 31) / 10 || res < -Math.pow(2, 31) / 10 && a < -8)
				return 0;
			res = res * 10 + a;
			x /= 10;
		}
		return res;

	}
//	public static int reverse(int x) {
//		// if(x==null)
//		// return 0;
//		String s = String.valueOf(x);
//
//		boolean negative = false;
//		if (s.charAt(0) == '-')
//			negative = true;
//
//		int len = negative ? s.length() - 1 : s.length();
//		if (negative == true)
//			s = s.substring(1, s.length());
//		String res = "";
//		for (int i = 0; i < len; i++) {
//			res = s.charAt(i) + res;
//		}
//
//		if (negative == true)
//			res = '-' + res;
//		return Integer.parseInt(res);
//	}
}
