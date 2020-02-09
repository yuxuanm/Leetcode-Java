package leetcode;

public class Q50 {
	public static void main(String[] args) {
		double x = 2.00000;
		int n = -2147483648;
		Q50 q50 = new Q50();
		System.out.println(q50.myPow(x, n));
		System.out.println(Math.pow(x, n));
	}

	public double myPow(double x, int n) {
		Long N;
		double res = 0;
		if (n >= 0) 
			res = myPosPow(x, n);
		else {
			N=(long) -1*n;
			res = 1 / myPosPow(x, N);
		}
		return res;
	}

	private double myPosPow(double x, long n) {
		if (n == 1)
			return x;
		if (n == 0)
			return 1;
		long cur = 1;
		double res = 0;
		double midRes = x;
		while (cur <= n >> 1) {
			res = midRes * midRes;
			midRes = res;
			cur <<= 1;
			if(cur==n)
				return res;
		}
		return res * myPosPow(x, n - cur);
	}

//	//
//	public double myPow(double x, int n) {
//		double res=0;
//		if(n>=0)
//			res=myPosPow(x,n);
//		else
//			res=1/myPosPow(x,-n);
//		return res;
//	}
//	
//	private double myPosPow(double x, int n) {
//		if(x==1&&n>=0||x==1&&n%2==0)
//			return 1;
//		if(x==1&&n<0&&n%2!=0)
//			return -1;
//		if(n==1)
//			return x;
//		if(n==0)
//			return 1;
//		int cur =1;
//		double res = 0;
//		double midRes=x;
//		while(cur<=n>>1) {
//			res=midRes*midRes;
//			midRes=res;
//			cur<<=1;
//		}
//		return res*myPosPow(x,n-cur);
//	}
}
