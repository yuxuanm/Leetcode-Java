package array;

public class Q62UniquePaths {
	
	/**
	 * Method 1: Dynamic programming
	 * use a 2D array to store unique paths to each cell.
	 * For cell in row 0 and column 0, all values are 1.
	 * For othe cells, res[i][j] = res[i - 1][j] + res[i][j - 1]
	 * 
	 * Results: runtime 0ms beats 100% memory 35.2mb beats 70.65%
	 * */
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					res[i][j] = 1;
					continue;
				}
				res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
}
