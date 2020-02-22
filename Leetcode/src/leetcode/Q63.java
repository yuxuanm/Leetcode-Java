package leetcode;

import java.util.Arrays;

public class Q63 {
	public static void main(String[] args) {
//		int [][] obstacleGrid=new int[][] {new int[] {0,0,0},new int[] {0,1,0},new int[] {0,0,0}};
		int[][] obstacleGrid = new int[][] { new int[] { 1, 0 } };
		int res = uniquePathsWithObstacles(obstacleGrid);
		System.out.println(res);
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid[0][0]==1)
			return 0;
		boolean flagFirstRow = false; // flag to indicate if there is obstacle in the 1st row
		boolean flagFirstCol = false; // flag to indicate if there is obstacle in the 1st col
		
		int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					if(i==0) {
						flagFirstRow=true; //change flag to true, set all values from this cell to 0
					}
					if(j==0)
						flagFirstCol=true; // change flag to true, set all values after that to 0
					res[i][j] = 0;
					continue;
				}
				if (i == 0 && flagFirstRow==false|| j == 0 && flagFirstCol==false) {
					res[i][j] = 1;
					continue;
				}
				if (i == 0 && flagFirstRow==true|| j == 0 && flagFirstCol==true) {
					res[i][j] = 0;
					continue;
				}
				
				res[i][j] = res[i - 1][j] + res[i][j - 1];

			}
		}
		return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

	}
}
