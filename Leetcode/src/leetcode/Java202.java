package leetcode;

import java.util.HashSet;

public class Java202 {
	public static void main(String[] args) {
		int a =19;
		System.out.println(isHappy(a));
	}
	public static int pingfanghe(int n ) {
		int res =0;
		while(n>=10) {
			int a = n%10;
			res += a*a;
			n/=10;
		}
		res+=n*n;
		return res;
	}
	
	public static boolean isHappy(int n) {
		HashSet<Integer> set = new HashSet<Integer>();
		int res = 0;
		while(res!=1) {
			res=pingfanghe(n);
			if(set.contains(res))
				return false;
			set.add(res);
			n=res;
		}
		return true;
	}
}
