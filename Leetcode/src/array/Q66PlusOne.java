package array;

public class Q66PlusOne {
	/**
	 * Method 2: Iteration from end
	 * Code optimization of Method 1;
	 * 
	 * Results: runtime 0ms beats 100% memory 37.1mb beats 18.62%.
	 * */
	public int[] plusOne2(int[] digits) {
        for(int i =digits.length-1;i>=0;i--){
            if(digits[i]+1 <10){
                digits[i]=digits[i]+1;
                return digits;
            } else{  // digits[i] + 1 =10
                digits[i]=0;
            }
        }

        digits = new int [digits.length+1];
        digits[0]=1;
        return digits;
    }
	
	/**
	 * Method 1£º Iteration from end
	 * 
	 * Results: runtime 0ms beats 100% memory 37mb beats 31.45%.
	 * */
	public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]+1 <=9){
            digits[digits.length-1] = digits[digits.length-1] +1;
            return digits;
        } else{
            int jinWei = 1;
            int cur = digits.length -1;
            while(jinWei !=0){
                if(cur == -1){
                    int []res = new int [digits.length+1];
                    res[0]=1;
                    return res;
                }
                if(jinWei+digits[cur] ==10){
                    digits[cur] = 0;
                    cur--;
                } else{
                    digits[cur] = digits[cur]+1;
                    jinWei = 0;
                }
            }
            return digits;
        }
    }
}
