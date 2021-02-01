package array;

public class Q70ClimbingStairs {
	
	/**
	 * Method 1: Dynamic Programming
	 * Transfer function: res[i] = res[i-1] + res[i-2]
	 * 
	 * Results: runtime 0ms beats 100% memory 35.2mb beats 51.63%
	 * */
	public int climbStairs(int n) {
		if (n <= 2)
			return n;

		int res[] = new int[n];
		res[0] = 1;
		res[1] = 2;
		for (int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n - 1];
	}
}
