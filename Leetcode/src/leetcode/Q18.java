package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Q18 {
	public static void main(String[] args) {
		int [] nums = new int [] {-3,-2,-1,0,0,1,2,3};
		int target = 0;
		Q18 q= new Q18();
		q.fourSum(nums, target);
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
        	if(threeSum(Arrays.copyOfRange(nums, i+1, nums.length),target - nums[i]).size()!=0) {
        		List<List<Integer>> semiRes;        		
        		semiRes= threeSum(Arrays.copyOfRange(nums, i+1, nums.length),target - nums[i]);
        		for(int j=0;j<semiRes.size();j++) {
        			semiRes.get(j).add(nums[i]);
        			if(!res.contains(semiRes.get(j))) // avoid duplicate item
        				res.add(semiRes.get(j));
        		}
        	}
        }
        return res;
    }
    
	// treeSum
    public List<List<Integer>> threeSum(int[] nums, int target){
        int start,end;
        List<List<Integer>> semiRes = new ArrayList<List<Integer>>();
        for(int i =0;i<nums.length-2;i++){
            start = i+1;end = nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]==target-nums[i]){
                    ArrayList<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[start]);
                    l.add(nums[end]);
                    semiRes.add(l);
                    start++;
                    end--;
                }
                else if(nums[start]+nums[end]>target-nums[i])
                    end--;
                else if(nums[start]+nums[end]<target-nums[i])
                    start++;
            }
        }
        return semiRes;
    }
}
