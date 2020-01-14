package leetcode;

import java.util.Arrays;

public class Q16 {
	
	public static void main(String[] args) {
		int [] nums = new int [] {-1,2,1,-4};
		System.out.println(threeSumClosest(nums,1));
	}
//	 public static int threeSumClosest(int[] nums, int target) {
//	        int minDiff = Integer.MAX_VALUE;
//	        int remain;
//	        int curDiff=Integer.MAX_VALUE;
//	        Arrays.sort(nums);
//	        for(int i=0;i<nums.length-2;i++){
//	        	remain = target-nums[i];
//	            for(int j=i+1;j<nums.length-1;j++){
//	                for(int k=i+2;k<nums.length;k++){
//	                    curDiff = Math.abs(nums[j]+nums[k]-remain);
//	                    minDiff = curDiff<minDiff?curDiff:minDiff;
//	                }
//	            }
//	        }
//	        return curDiff;
//	    }
	
	public static int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int start,end;
        int sum=0;
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
        	start = i+1;
        	end = nums.length-1;
        	while(start<end) {
        		sum = nums[i]+nums[start]+nums[end];
        		if(Math.abs(sum-target)<minDiff) {
        			minDiff = Math.abs(sum-target);
        			ans=sum;
        		}
        		if(sum>target)
        			end--;
        		else if (sum<target)
        			start++;
        		else
        			return sum;
        	}
        }
        return ans;
    }
}
