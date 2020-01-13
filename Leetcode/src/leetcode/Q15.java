package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
	public static void main(String[] args) {
		int nums [] = new int[]{-1,0,1,2,-1,-4};
		System.out.println(threeSum(nums));
	}
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int start;
        int end;
        int remain;
        for(int i =0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            start = i+1;
            end = nums.length-1;
            remain = 0-nums[i];
            while(start<end){
                if(nums[start]+nums[end]>remain){
                    end--;
                    continue;
                }else if(nums[start]+nums[end]<remain){
                    start++;
                    continue;
                }else if(nums[start]+nums[end]==remain){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    if(!res.contains(l))
                        res.add(l);
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
	
}
