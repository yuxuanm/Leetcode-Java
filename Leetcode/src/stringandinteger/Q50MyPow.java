package stringandinteger;

public class Q50MyPow {
	
	/*
	 * Method 1: Binary search
	 * Two cases, 
	 * n<0, return 1/res
	 * n>0, return res
	 * res=x^(abs(n))
	 * 
	 * Results: runtime 1ms beats 98.05% memory 37.9mb beats 19.64%
	 * */
	public double myPow(double x, int n) {
		return n < 0 ? 1 / mySubPow(x, 1, -n) : mySubPow(x, 1, n);
	}

	private double mySubPow(double x, double curRes, int n) {
		if (n == 0) {
			return curRes;
		}
		double res = x;
		int cur = 1;
		while (cur * 2 <= n && cur <= Integer.MAX_VALUE / 2) { // prevent over 2*31-1
			res = res * res;
			cur = cur * 2;
		}
		return mySubPow(x, curRes * res, n - cur);
	}
}
