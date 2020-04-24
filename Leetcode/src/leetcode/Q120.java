package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q120 {
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		List<Integer> l4 = new ArrayList<Integer>();
		l1.add(2);
		l2.add(3);
		l2.add(4);
		l3.add(6);
		l3.add(5);
		l3.add(7);
		l4.add(4);
		l4.add(1);
		l4.add(8);
		l4.add(3);
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		
		int res = minimumTotal(list);
	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] res = new int[triangle.size() + 1]; // use an array to store minimum sum of each row
		res[0] = 0; // dummy value at index 0, eliminate boundary condition
		for (List<Integer> l : triangle) {
			int size = l.size();
			// special condition, when we are dealing with the first item and last item
			for (int i = size; i > 0; i--) {
				if (i == size) {
					res[i] = res[i - 1] + l.get(i - 1);
					continue;
				}
				if(i==1) {
					res[i]=res[i]+l.get(i-1);
					continue;
				}
				res[i] = l.get(i - 1) + Math.min(res[i], res[i - 1]);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < res.length; i++) {
			min = res[i] < min ? res[i] : min;
		}
		return min;
	}
}
