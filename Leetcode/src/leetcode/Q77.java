package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q77 {
	public static void main(String[] args) {
		List<List<Integer>> res =Q77.combine(3, 3);
		
	}
	
	/**Method : backtracking
	 * 
	 * runtime: 28ms beats 46.71%
	 * memory: 42.6MB beats 14378%
	 * */
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == 0)
			return res;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
			subCombine(res, list, k, n, i + 1);
			list.remove(0);
		}
		return res;
	}

	private static void subCombine(List<List<Integer>> res, List<Integer> list, int k, int n, int cur) {
		if (list.size() == k) {
			res.add(new ArrayList<Integer>(list));
		}

		for (int i = cur; i <= n; i++) {
			list.add(i);
			subCombine(res, list, k, n, ++cur);
			list.remove(list.size() - 1);
		}
	}
}
