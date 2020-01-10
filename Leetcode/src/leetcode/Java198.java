package leetcode;

public class Java198 {
	public static void main(String[] args) {
		int [] homes = new int [] {3,1,2,7};
		System.out.println(rob(homes));
	}
	public static int rob(int[] nums) {
	    if(nums == null)
	    	return -1;
	    if(nums.length==1)
	    	return nums[0];
	    if(nums.length==2)
	    	return Math.max(nums[0],nums[1]);
	    int m0 = 0;
	    int m1 = nums[0];
	    int m2 = Math.max(nums[0],nums[1]);
	    
	    int m [] = new int [nums.length];
	    m[0]=m1;
	    m[1]=m2;
	    for(int i=2;i<nums.length;i++) {
	    	m[i]=Math.max(m[i-2]+nums[i], m[i-1]);
	    }
	    
	    return m[nums.length-1];
    }
}
