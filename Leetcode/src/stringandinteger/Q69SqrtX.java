package stringandinteger;

public class Q69SqrtX {
	
	
	/**
	 * Method 1: Recursion
	 * 
	 * Results: runtime 1ms beats 100% memory 35.6mb beats 34.97%
	 * */
	public int mySqrt(int x) {
		return helper(x, 0);
	}

	private int helper(int x, int res) {
		if (Math.pow(res + 1, 2) > x) { // end condition
			return res;
		}
		int cur = 1;
		// 0< Math.pow(res+2*cur,2) boundary condition, prevent larger than Integer.MAX_VALUE
		while (Math.pow(res + cur, 2) < x && Math.pow(res + 2 * cur, 2) <= x && 0 < Math.pow(res + 2 * cur, 2)) {
			cur = 2 * cur;
		}
		return helper(x, res + cur);
	}
}
