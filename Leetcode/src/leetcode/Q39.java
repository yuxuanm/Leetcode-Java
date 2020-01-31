package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
	public static void main(String[] args) {
		int[] candidates = new int[] { 1,2};
		Q39 q39 = new Q39();
		List<List<Integer>> res = q39.combinationSum(candidates, 4);
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(1);
		l1.add(2);
		
		l2.add(2);
		l2.add(2);
		l2.add(2);
		l2.add(2);
		System.out.println(l1.containsAll(l2));
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
			subRes(candidates, sum, target, list, res);
		}
		if (!res.isEmpty())
			return res;
		return null;
	}

	public void subRes(int[] candidates, int sum, int target, List<Integer> list, List<List<Integer>> res) {
		if (sum == target) {
			// remove duplicated results
			for (List<Integer> l : res) {
				if (l.containsAll(list))
					return;
			}
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			if (sum + candidates[i] > target)
				return;
			list.add(candidates[i]);
			subRes(candidates, sum + candidates[i], target, list, res);
			list.remove(list.size() - 1);
		}
	}
}
