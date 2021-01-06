package stringandinteger;

public class Q29DivideTwoIntegers {
	public static void main(String[] args) {
		int res = divide2(-10, -1);
		System.out.println(res);
	}

	public static int divide2(int dividend, int divisor) {
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0)
			return subDivideNegative(Math.abs(dividend), Math.abs(divisor));
		else
			return subDividePositive(Math.abs(dividend), Math.abs(divisor));
	}

	
	private static int subDividePositive(int dividend, int divisor) {
		int res = subDivideNegative(-dividend, -divisor);
		if(res==Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		return res;
	}

	private static int subDivideNegative(int dividend, int divisor) {
		if (dividend > divisor)
			return 0;
		int multi = 1;
		int cur = divisor;
		while (cur <= dividend ) {
			multi *= 2;
			cur *= 2;
		}
		return subDivideNegative(dividend - cur, divisor) + multi;
	}

	/*
	 * Method 1
	 * 
	 * Brute force, subtract dividend by divisor, use another variable to count the
	 * number of subtract operations. Convert both dividend and divisor to negative
	 * and use a flag to indicate the sign of result.
	 * 
	 * 
	 * Results: run out of time.
	 */
	public int divide(int dividend, int divisor) {
		if (dividend < 0 && divisor > 0 || dividend >= 0 && divisor < 0)
			return -subDivide(-Math.abs(dividend), -Math.abs(divisor), false);
		else
			return subDivide(-Math.abs(dividend), -Math.abs(divisor), true);
	}

	private int subDivide(int dividend, int divisor, boolean flag) {
		int tmp = dividend;
		int res = 0;
		while (tmp < 0 && tmp - divisor <= 0) {
			tmp -= divisor;
			res -= 1;
		}
		if (flag == true && res == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		return -res;
	}
}
