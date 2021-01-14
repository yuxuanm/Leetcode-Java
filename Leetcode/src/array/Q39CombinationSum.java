package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39CombinationSum {

	public static void main(String[] args) {
		int [] candidates = new int [] {2,3,6,7};
		List<List<Integer>> res = combinationSum(candidates, 7);
	}

	/*
	 * Method 1: Backtrack Sort the array.
	 * 
	 * Results: runtime 2ms beats 99.93% memory 38.6mb beats 70.25%
	 * 
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, 0, target);
		return res;
	}

	private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int remain) {
		if (remain == 0) { // sum equals target, add to result.
			res.add(new ArrayList<Integer>(list));
		}

		for (int i = index; i < candidates.length; i++) {
			if (remain < candidates[i]) // exceed target, return
				return;
			list.add(candidates[i]);
			backtrack(res, list, candidates, i, remain - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
}
