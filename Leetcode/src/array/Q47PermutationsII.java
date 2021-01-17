package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q47PermutationsII {
	
	/*
	 * Method 1: backtrack
	 * 
	 * 
	 * Improvement: duplicate control
	 * 
	 * Results: runtime 982ms beats 5.06% memory 39.3mb beats 40.73%.
	 * */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		backtrack(res, tmp, numsList);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> list, List<Integer> nums) {
		if (nums.size() == 0) {
			for (List<Integer> l : res) {
				if (l.equals(list))
					return;
			}
			res.add(new ArrayList<Integer>(list));
		}

		for (int i = 0; i < nums.size(); i++) {
			int num = nums.remove(i);
			list.add(num);
			backtrack(res, list, nums);
			list.remove(list.size() - 1);
			nums.add(i, num);
		}
	}
}
