package array;

import java.util.ArrayList;
import java.util.List;

public class Q54SpiralMatrix {
	
	/*
	 * Method 1: 
	 * Simulate the process
	 * 
	 * Results: runtime 0ms beats 100% memory 36.6mb beats 42.83%
	 * */
	public List<Integer> spiralOrder(int[][] matrix) {
		int up = 0;
		int bottom = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;
		int x = 0;
		int y = 0;
		List<Integer> res = new ArrayList<Integer>();
		String direction = "right";

		while (up <= bottom && left <= right) {
			switch (direction) {
			case "right":
				for (int i = left; i <= right; i++) {
					res.add(matrix[up][i]);
				}
				up++;
				direction = "bottom";
				break;
			case "bottom":
				for (int i = up; i <= bottom; i++) {
					res.add(matrix[i][right]);
				}
				right--;
				direction = "left";
				break;
			case "left":
				for (int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
				bottom--;
				direction = "up";
				break;
			case "up":
				for (int i = bottom; i >= up; i--) {
					res.add(matrix[i][left]);
				}
				left++;
				direction = "right";
			}
		}

		return res;
	}
}
