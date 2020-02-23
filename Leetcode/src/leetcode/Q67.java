package leetcode;

public class Q67 {
	public static void main(String[] args) {
		String a="1010";
		String b="1011";
		String res = addBinary(a, b);
		System.out.println(res);
	}

	public static String addBinary(String a, String b) {
		StringBuilder builder = new StringBuilder();
		int m;
		int n;
		int jinWei = 0;
		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			m = a.length()-i-1<0? 0 : a.charAt(a.length()-i-1) - '0';
			n = b.length()-i-1<0? 0 : b.charAt(b.length()-i-1) - '0';
			if (m + n + jinWei > 1) {
				builder.append(m + n + jinWei - 2);
				jinWei = 1;
			}
			if (m + n + jinWei <= 1) {
				builder.append(m + n + jinWei);
				jinWei = 0;
			}
			if (i == Math.max(a.length(), b.length()) - 1 && jinWei == 1)
				builder.append(1);
		}
		return builder.reverse().toString();
	}
}
