package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q56MergeIntervals {
	
	/**
	 * Method 1:
	 * step 1: sort the intervals based on the 1st value
	 * step 2: two parameters used,  	start: start value of current interval
	 * 									end: end value of current interval
	 * step 3: for each arr int[], compare arr[1] with end
	 * 		   if arr[1]> end, then (start, end) is one of the final intervals
	 *         else the current arr can be merged with (start, end)		   
	 * 
	 * Results: runtime 6ms beats 95.37% memory 41.1mb beats 71.50%
	 * */
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		List<int[]> res = new ArrayList<int[]>();
		int start = intervals[0][0];
		int end = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] > end) { // then (start, end) is a final interval
				res.add(new int[] { start, end });
				start = intervals[i][0]; // re-initial start & end
				end = intervals[i][1];
			} else if (intervals[i][0] <= end) {
				if (intervals[i][1] > end)
					end = intervals[i][1];
				else
					continue;
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[res.size()][2]);
	}

}
