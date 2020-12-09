package dynamicprogramming;

public class Q62UniquePaths {
	
	/*
	 *Problem 62: Unique paths
	 *
	 *Dynamic programming:
	 *Use an 2-dimensional array, the value of each cell represents the number
	 *of unique paths to that cell. 
	 *
	 *Initialize first column and first row with 1. Other cells have the 
	 *transition function: A[i][j]=A[i-1][j]+A[i][j-1]
	 *
	 *Results:	runtime: 0 ms beats 100%
	 *			memory: 35.3 MB beats 72.53%
	 * */
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					res[i][j] = 1;
				else
					res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[m - 1][n - 1];
	}
}