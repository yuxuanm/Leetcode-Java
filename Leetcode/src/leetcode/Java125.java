package leetcode;

public class Java125 {
	public static void main(String[] args) {
		String s ="`l;`` 1o1 ??;l`";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		String ss = s.toLowerCase();
		char[] arr = ss.toCharArray();
		int start = 0;
		int end = arr.length - 1;
		while (start < end) {
			if (arr[start] < 97 || arr[end] > 122) {
				if (!Character.isDigit(arr[start])) {
					start++;
					continue;
				}
			}
			if (arr[end] < 97 || arr[end] > 122) {
				if (!Character.isDigit(arr[end])) {
					end--;
					continue;
				}
			}
			if (arr[start] != arr[end])
				return false;
			start++;
			end--;
		}
		return true;
	}
}
