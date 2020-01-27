package leetcode;

public class Q29 {
	public static void main(String[] args) {
//		System.out.println(((2147483647>>1)+10)<<1);
		int res = divide(-2147483648, -1);
//		System.out.println(Math.abs(Integer.MIN_VALUE));
//		int res = divide(-20, 3);
//		System.out.println(Math.abs(Integer.MIN_VALUE));
//		System.out.println(res);
		System.out.println(res);
	}

	// Method 1: exceeds time limit
//	public static int divide(int dividend, int divisor) {
//        int res = 0;
//        int yu = dividend;
//        if(dividend>=0 && divisor>=0 ||dividend<0&&divisor<0){
//             while(yu==Integer.MIN_VALUE||Math.abs(yu)>=Math.abs(divisor)){
//                 yu=yu-divisor;
//                res+=1;
//                if(res<=Math.pow(-2, 31)||res>=Math.pow(2, 31)-1 && Math.abs(yu)>=Math.abs(divisor))
//                	return Integer.MAX_VALUE;
//            }
//        }
//        else{
//            while(Math.abs(yu)>=Math.abs(divisor)){
//                yu=yu+divisor;
//                res-=1;
//                if(res<=Math.pow(-2, 31)||res>=Math.pow(2, 31)-1&&Math.abs(yu)>=Math.abs(divisor))
//                	return Integer.MAX_VALUE;
//            }
//        }
//        return res;
//    }
	
	// Method 2:
	public static int divide(int dividend, int divisor) {
		if(dividend>=0)
			return positiveDividend(dividend, divisor);
		else
			return negativeDividend(dividend, divisor);
	}
	
	public static int positiveDividend(int dividend, int divisor) {
		int res =negativeDividend(-dividend, divisor);
		
		if(res==Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		
		return -res;
	}
	
	public static int negativeDividend(int dividend, int divisor) {
		boolean flag = divisor>0;
		int res =flag?-1:1;
		divisor =flag?-divisor:divisor;
		if(dividend>divisor)
			return 0;
		int div=divisor;
		while(dividend <=divisor << 1){
			if(divisor<=Integer.MIN_VALUE>>1)
				break;
			res <<= 1;
			divisor <<= 1;
		}
		res+=negativeDividend(dividend+Math.abs(divisor), div);
		if(res<Integer.MIN_VALUE||res>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(!flag&&res<0)//if flag is false, which means the result should be a positive
						//value. Therefore, if the current res is negative, the res should
						//exceed(smaller than) Integre.MIN_VALUE. 
			return Integer.MAX_VALUE;
		return res;
	}
}
