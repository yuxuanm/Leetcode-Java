package leetcode;

import java.util.Arrays;

public class Java204 {
	
	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}
	public static int countPrimes(int n) {
	      int cnt = 0;
	        if(n<=1)
	            return 0;
	        boolean [] primes = new boolean [n];
	        Arrays.fill(primes,true);
	        for(int i = 2;i*i<n;i++){
	            for(int j =i*i;j<n;j+=i){
	                primes[j]=false;
	            }
	        }
	        
	        for(boolean p:primes){
	            if(p)
	                cnt++;
	        }
	        return cnt;
	    }
}
