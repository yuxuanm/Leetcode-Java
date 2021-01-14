package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40CombinationSumII {

	/*
	 * Method 2: Backtrack
	 * 
	 * Results: runtime 3ms beats 81.97% memory 38.7mb beats 57.23%.
	 * */
	public List<List<Integer>> combinationSum22(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack2(res, new ArrayList<Integer>(), candidates, -1, target);
		return res;
	}

	private void backtrack2(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int remain) {
		if (remain == 0) {
			res.add(new ArrayList<Integer>(list));
		}

		int i = index + 1;
		while (i < candidates.length) {
			if (remain < candidates[i])
				return;
			list.add(candidates[i]);
			backtrack(res, list, candidates, i, remain - candidates[i]);
			list.remove(list.size() - 1);
			// duplicate control
			// at same level, cannot use same number again
			while (i + 1 < candidates.length && candidates[i + 1] == candidates[i])
				i++;
			i++;
		}
	}

	/*
	 * Method 1: Backtrack 
	 * Same as Problem 39.
	 * 
	 * Improvement: instead of using list1.equals(list2) to check duplicate, 
	 * use index.
	 * 
	 * Results: runtime 669ms beats 7.13% memory 38.6mb beats 72.85%
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(res, new ArrayList<Integer>(), candidates, -1, target);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> list, int[] candidates, int index, int remain) {
		if (remain == 0) {
			for (List<Integer> l : res) {
				if (l.equals(list))
					return;
			}
			res.add(new ArrayList<Integer>(list));
		}
		for (int i = index + 1; i < candidates.length; i++) { // start from next index
			if (remain < candidates[i])
				return;
			list.add(candidates[i]);
			backtrack(res, list, candidates, i, remain - candidates[i]);
			list.remove(list.size() - 1);
		}
	}
}