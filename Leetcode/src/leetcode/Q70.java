package leetcode;

public class Q70 {
	public static void main(String[] args) {
		Q70 q70 = new Q70();
		System.out.println(q70.climbStairs(34));
	}
	
	/**Method 3: same as Method 2
	 * use a array to store results
	 * */
	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] steps = new int[n];
		steps[0] = 1;
		steps[1] = 2;
		for (int i = 2; i < n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}
		return steps[n - 1];
	}

	/**Method 2:
	 * step[i] = step[i-1]+step[i-2];
	 * Result: run out of time
	 * */
//	public int climbStairs(int n) {
//		if (n == 1)
//			return 1;
//		if (n == 2)
//			return 2;
//		return climbStairs(n - 1) + climbStairs(n - 2);
//	}

	/**Method 1: combination
	 * eg: 5 steps:  5*1
	 * 				 3*1+2*1
	 * 				 2*2+1*1
	 * 		formula: 5 steps = C(5,0)+C(4,1)+C(3,2)
	 * Result: out of runtime limit
	 * */
//	public int climbStairs(int n) {
//		int m = 0;
//		int sum = 0;
//		while (n >= m) {
//			sum += combination(n--, m++);
//		}
//		return sum;
//	}
//	
////  easily out of Integer limit
//	private int combination(int n, int m) {
//		return factorial(n) / (factorial(m) * factorial(n - m));
//	}
//
//	private int factorial(int n) {
//		if (n == 1 || n == 0)
//			return 1;
//		return factorial(n - 1) * n;
//	}
//
//	/** alternative approach to find combination
//	 * use the formula: C(n,m)=C(n-1,m)+C(n-1,m-1);
//	 */
//	private int combination(int n, int m) {
//		// end requirement
//		if (m == n || m == 0)
//			return 1;
//		return combination(n - 1, m) + combination(n - 1, m - 1);
//	}
}
