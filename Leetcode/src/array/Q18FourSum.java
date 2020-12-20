package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18FourSum {
	
	/*
	 * Method 1:
	 * 
	 * Two pointers, fixed the first two indices, and then use two pointers, one start from
	 * left, one starts from right, both move toward each other.
	 * 
	 * Results: runtime 15ms beats 56.4% memory 39.1mb beats 61.49%
	 * */
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j =i+1;j<nums.length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int remain = target - nums[i]-nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]>remain)
                        right--;
                    else if(nums[left]+nums[right]<remain)
                        left++;
                    else{
                        List<Integer> sub_sol = new ArrayList<Integer>();
                        sub_sol.add(nums[i]);
                        sub_sol.add(nums[j]);
                        sub_sol.add(nums[left]);
                        sub_sol.add(nums[right]);
                        left++;
                        if(!res.contains(sub_sol))
                            res.add(sub_sol);
                    }
                }
            }

        }
        return res;
    }
}
