package array;

public class Q64MinimumPathSum {
	
	/**
	 * Method: Dynamic Programming
	 * Three cases:
	 * First row: res[i][j] = res[i][j - 1] + grid[i][j];
	 * First col: res[i][j] = res[i][j - 1] + grid[i][j];
	 * Others: res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
	 * 
	 * Results: runtime 3ms beats 85.44% memory 41.4mb beats 5.92%
	 * */
	public int minPathSum(int[][] grid) {
		int res[][] = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 || j == 0) {
					if (i == 0 && j == 0) // first cell, res[0][0]
						res[i][j] = grid[0][0];
					else if (i == 0) // first row
						res[i][j] = res[i][j - 1] + grid[i][j];
					else // first col
						res[i][j] = res[i - 1][j] + grid[i][j];
				} else {
					res[i][j] = Math.min(res[i - 1][j] + grid[i][j], res[i][j - 1] + grid[i][j]);
				}
			}
		}
		return res[res.length - 1][res[0].length - 1];
	}
}
