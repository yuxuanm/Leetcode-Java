package array;

public class Q63UniquePathsII {
	
	/**
	 * Method 1: Dynamic Programming
	 * Same as Q62. 
	 * When there is an obstacle, set the cell to 0.
	 * 
	 * Results: runtime 0ms beats 100% memory 37.8mb beats 32.74%¡£
	 * */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		// store number of paths to each cell
		int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) { // when there is an obstacle
					res[i][j] = 0;
				} else if (i == 0 && j == 0) { // initial first cell
					res[i][j] = 1;
					continue;
				} else if (i == 0) {
					res[i][j] = res[i][j - 1];
				} else if (j == 0) {
					res[i][j] = res[i - 1][j];
				} else
					res[i][j] = res[i - 1][j] + res[i][j - 1];
			}
		}
		return res[res.length - 1][res[0].length - 1];
	}
}
