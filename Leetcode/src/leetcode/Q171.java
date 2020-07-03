package leetcode;

public class Q171 {
	
	public static void main(String[] args) {
		Q171 q171 = new Q171();
		int res = q171.trailingZeroes(30);
		System.out.println(res);
		System.out.println(5^1);
	}
	
	public int trailingZeroes(int n) {
		int cnt = 0;
		int num = n;
		while (n != 0 || n % 5 != 0) {
			cnt += 1;
			n /= 5;
		}
		int res = 0;
		for (int i = 1; i <= cnt; i++) {
			res += num / Math.pow(5, i);
		}
		return res;
	}
}
