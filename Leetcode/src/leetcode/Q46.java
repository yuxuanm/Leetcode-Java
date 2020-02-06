package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46 {
	public static void main(String[] args) {
		Q46 q46 = new Q46();
		List<List<Integer>> res = q46.permute(new int[] {1,3,4});
	}

	public List<List<Integer>> permute(int[] nums) {
		int len = nums.length;
		int ArraySize = factor(len);
		Arrays.sort(nums);
		List<Integer> refList = new ArrayList<Integer>();
		for(int n:nums)
			refList.add(n);
		List<List<Integer>> res = new ArrayList<List<Integer>>(ArraySize);
		for(int i=0;i<nums.length;i++) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[i]);
			subPermute(list, nums, refList, res);
		}
		return res;
	}
	
	private void subPermute(List<Integer> list, int[] nums,List<Integer> refList,List<List<Integer>> res){
		if(list.containsAll(refList)) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
	
		for(int i=0;i<nums.length;i++) {
			if(list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			subPermute(list,nums,refList,res);
			list.remove(list.size()-1);
		}
	}

	public int factor(int n) {
		if (n == 1)
			return n;
		return n * factor(n - 1);
	}
}
