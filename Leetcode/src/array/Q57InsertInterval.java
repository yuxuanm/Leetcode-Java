package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q57InsertInterval {
	
	/**
	 * Similar to Q56.
	 * Step 1: Create a new 2D array, find the right position 
	 * 		   to insert the newInterval into the original intervals.
	 * Step 2: repeat Q56.
	 * 
	 * Results: runtime 3ms 20.08% memory 40.8mb beats 70.04.
	 * */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> res = new ArrayList<int[]>();
		
		// first sort the intervals ASC
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[][] tmpIntervals = new int[intervals.length + 1][2];
		int index = 0;
		// find the right position to insert newInterval
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] < newInterval[0])
				tmpIntervals[index++] = intervals[i];
			else {
				tmpIntervals[index++] = newInterval;
				for (int j = i; j < intervals.length; j++) {
					tmpIntervals[index++] = intervals[j];
				}
				break;
			}
		}
		if (index == tmpIntervals.length - 1) {
			tmpIntervals[index] = newInterval;
		}

		// below repeat Q56
		int start = tmpIntervals[0][0];
		int end = tmpIntervals[0][1];
		for (int i = 1; i < tmpIntervals.length; i++) {
			if (tmpIntervals[i][0] > end) {
				res.add(new int[] { start, end });
				start = tmpIntervals[i][0];
				end = tmpIntervals[i][1];
				continue;
			} else {
				end = end > tmpIntervals[i][1] ? end : tmpIntervals[i][1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[res.size()][2]);
	}
}
