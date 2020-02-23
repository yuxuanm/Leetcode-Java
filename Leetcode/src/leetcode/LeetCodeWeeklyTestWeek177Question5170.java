package leetcode;

public class LeetCodeWeeklyTestWeek177Question5170 {
	public static void main(String[] args) {
		int [] res = closestDivisors(688427155);
	}
	public static int[] closestDivisors(int num) {

		int[] r1 = findClosestDivisors(num + 1);
		int[] r2 = findClosestDivisors(num + 2);
		int res[] = new int[2];
		res[0] = r1[2] < r2[2] ? r1[0] : r2[0];
		res[1] = r1[2] < r2[2] ? r1[1] : r2[1];
		return res;
	}
	
	private static int[] findClosestDivisors(int num) {
		int[] res = new int[3];
		res[0] = 1;
		res[1] = num;
		res[2] = num-1;
		for (int i = 2; i <= num /i; i++) {
			if (num % i == 0) {
				if (Math.abs(i - num / i) < res[2]) {
					res[0] = i;
					res[1] = num / i;
					res[2] = Math.abs(i - num / i);
				}
			}
		}

		return res;
	}
}
