package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q73 {

	/**           find the indices of zeros in matrix
	 * 			  set all values to zero with these row, column indices
	 * */
	public void setZeroes(int[][] matrix) {
		List<Integer> rowIndex = new ArrayList<Integer>();
		List<Integer> colIndex = new ArrayList<Integer>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (!rowIndex.contains(i))
						rowIndex.add(i);
					if (!colIndex.contains(j))
						colIndex.add(j);
				}
			}
		}

		for (Integer i : rowIndex) {
			Arrays.fill(matrix[i], 0);
		}

		for (Integer i : colIndex) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[j][i] = 0;
			}
		}
	}
}
