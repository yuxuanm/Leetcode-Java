package array;

public class Q59SpiralMatrixII {
	
	
	/**
	 * Same as Q54.
	 * Four parameters to indicate boundary.
	 * 
	 * Results: runtime 0ms beats 100% memory 36.6mb beats 39.41%
	 * */
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int up = 0;
		int bottom = n - 1;
		int left = 0;
		int right = n - 1;
		int cur = 1;
		while (up <= bottom && left <= right) {
			for (int i = left; i <= right; i++) { // fill from left to right
				res[up][i] = cur++;
			}
			up++;
			for (int i = up; i <= bottom; i++) { // fill from top to bottom
				res[i][right] = cur++;
			}
			right--;
			for (int i = right; i >= left; i--) { // fill from right to left
				res[bottom][i] = cur++;
			}
			bottom--;
			for (int i = bottom; i >= up; i--) { // fill from bottom to top
				res[i][left] = cur++;
			}
			left++;
		}
		return res;
	}
}
