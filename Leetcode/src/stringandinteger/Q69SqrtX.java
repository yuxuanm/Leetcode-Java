package stringandinteger;

public class Q69SqrtX {
	
	/**
	 * Method 2: Binary Search
	 * 
	 * Results: runtime 2ms beats 46.55% memory 35.7mb beats 17.80%
	 * */
	public int mySqrt2(int x) {
        int left = 0;
        int right =x;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(Math.pow(mid,2)<=x && Math.pow(mid+1,2)>x){
                return mid;
            } else if(Math.pow(mid,2)<x){
                left = mid +1;
            } else
                right = mid-1;
        }
        return -1;
    }
	
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
