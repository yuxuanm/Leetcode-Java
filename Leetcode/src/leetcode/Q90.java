package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {

	public static void main(String[] args) {
		int[] nums = new int[] { 0 };
		List<List<Integer>> res = subsetsWithDup(nums);
	}


	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= nums.length; i++) { //use i to indicate list length
			backtrack(nums,i,list,0);
		}

		return res;
	}

	private static void backtrack(int [] nums, int tarLen,List<Integer> list,int index) {
		if(list.size()==tarLen) {
			for(List<Integer> l:res) {//double check duplicated list
//				if(l.toString().equals(list.toString()))
				if(l.equals(list))
					return;
			}
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i=0;i<nums.length;i++) {
			if(i<index)
				continue;
			list.add(nums[i]);
			backtrack(nums,tarLen,list,i+1);
			list.remove(list.size()-1);
		}
	}
}
