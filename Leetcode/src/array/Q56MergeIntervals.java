package array;

import java.util.ArrayList;
import java.util.List;

public class Q56MergeIntervals {
	
	/*
	 * Method 1:
	 * step 1: sort the intervals based on the 1st value
	 * step 2: two parameters used,  	start: start value of current interval
	 * 									end: end value of current interval
	 * step 3: for each arr int[], compare arr[1] with end
	 * 			if arr[1]> end, then (start, end) is one of the final intervals
	 * 
	 * Results: runtime 86ms beats 5.06% memory 40.8mb beats 93.74%
	 * */
	public int[][] merge(int[][] intervals) {
		sort(intervals);
		List<int[]> res = new ArrayList<int[]>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > end) {
				res.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			} else if (intervals[i][0] <= end) {
				if (intervals[i][1] > end)
					end = intervals[i][1];
				else
					continue;
			}
		}
		res.add(new int[] { start, end });

		int[][] res2 = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			res2[i] = res.get(i);
		}
		return res2;
	}

	private void sort(int[][] intervals) {
		for (int i = 0; i < intervals.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < intervals.length; j++) {
				if (intervals[j][0] < intervals[min][0])
					min = j;
			}
			int[] tmp = intervals[min];
			intervals[min] = intervals[i];
			intervals[i] = tmp;
		}
	}
}
