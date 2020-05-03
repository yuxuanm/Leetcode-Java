package leetcode;

public class Q152 {
	public static void main(String[] args) {
		int [] arr = new int[] {-2,3,0,-5,-4};
//		int [] arr = new int[] {-1,-2,-9,6};
		int res = maxProduct(arr);
		System.out.println(res);
	}
	
	/**Dynamic programming: use a array to store current max value, min value.
	 * 						min value is used in case for two negative inputs
	 * */
	public static int maxProduct(int[] nums) {
		int [] dpMax = new int[nums.length];
        int [] dpMin = new int[nums.length];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dpMin[i]=Math.min(dpMax[i-1]*nums[i], Math.min(dpMin[i-1]*nums[i],nums[i]));
            dpMax[i]=Math.max(dpMax[i-1]*nums[i], Math.max(dpMin[i-1]*nums[i],nums[i]));
        }
        int res = Integer.MIN_VALUE;
        for(int n:dpMax){
            res=n>res?n:res;
        }
        
        return res;
    }
}
