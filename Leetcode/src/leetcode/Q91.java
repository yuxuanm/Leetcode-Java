package leetcode;

public class Q91 {
	public static void main(String[] args) {
		String s = "226104110123";
		System.out.println(numDecodings(s));
	}
	
	/**Method 1: dynamic programming
	 * use int [] dp to store all the results, the cases are:
	 * 
	 * 	   a = s.charAt(i-1), b= s.charAt(i)
	 * 
	 * 1.a==0 : a) b==0     return 0
	 * 		    b) b!=0  => dp[i]=dp[i-1]
	 * 
	 * 2.a!=0 : a) ab >26 , if b=0, return 0
	 * 						if b!=0, dp[i]=dp[i-1]
	 * 			b) ab<=26,  if b=0, dp[i] = dp[i-2]
	 * 						if b!=0, dp[i]=dp[i-1]+dp[i-2]
	 * 
	 * 
	 * Results:  4 ms beats 28.49%
	 * 			 38.1MB beats 5.10%
	 * */
	public static int numDecodings(String s) {
		if(s.startsWith("0"))
			return 0;
       if(s.length()==1)
           return 1;
        int [] dp = new int [s.length()];
        dp[0]=1; 
        dp[1]=Integer.parseInt(s.substring(0,2))>26?(s.charAt(1)=='0'?0:1):(s.charAt(1)=='0'?1:2);
        for(int i=2;i<s.length();i++){
        	if(s.charAt(i-1)-'0'==0) {
        		if(s.charAt(i)-'0'==0)
        			return 0;
        		dp[i]=dp[i-1];
        	}
        	else {
        		if(s.charAt(i)-'0'==0) {
        			if(Integer.parseInt(s.substring(i-1,i+1))>26)
        				return 0;
        			dp[i]=dp[i-2];
        		}
        		else {
        			dp[i]=Integer.parseInt(s.substring(i-1,i+1))>26?dp[i-1]:(dp[i-1]+dp[i-2]);
        		}
        	}
        }
        return dp[s.length()-1];
    }

}
