package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
	public static void main(String[] args) {
		int[] candidates = new int[] {5,10,8,4,3,12,9};
		Q39 q39 = new Q39();
		List<List<Integer>> res = q39.combinationSum(candidates, 27);
	}

	// DFS
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0 || candidates == null)
			return null;
		Arrays.sort(candidates);
		int sum = 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list;
		for (int i : candidates) {
			sum = i;
			list = new ArrayList<Integer>();
			list.add(i);
			subRes(candidates, sum, target, list, res,i);
		}
		if (!res.isEmpty())
			return res;
		return null;
	}

	public void subRes(int[] candidates, int sum, int target, List<Integer> list, List<List<Integer>> res, int curValue) {
		if (sum == target) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			if(candidates[i]<curValue) // as we already rank the candidates, if current value is smaller than previous value, 
									   // return to remove duplicated combination
				continue;
			if (sum + candidates[i] > target)
				return;
			list.add(candidates[i]);
			subRes(candidates, sum + candidates[i], target, list, res,candidates[i]);
			list.remove(list.size() - 1);
		}
	}
}
