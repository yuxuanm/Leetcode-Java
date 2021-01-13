package array;

public class Q36ValidSudoku {
	
	
	/*
	 * Method 1:
	 * use an 1D array to check every row
	 * use an 2D array to check each column
	 * use an 2D array to check every box
	 * 
	 * Results: runtime 2ms beats 94.12% memory 38.9mb beats 13.20%
	 * */
	public boolean isValidSudoku(char[][] board) {
		int[] row = new int[9];
		int[][] cols = new int[9][9];
		int[][] boxs = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int tmp = board[i][j] - '0';

				// check row
				if (row[tmp - 1] == 1)
					return false;
				else
					row[tmp - 1] = 1;

				// check col
				if (cols[j][tmp - 1] == 1)
					return false;
				else
					cols[j][tmp - 1] = 1;

				// check box
				int boxNum = (i / 3) * 3 + j / 3;
				if (boxs[boxNum][tmp - 1] == 1)
					return false;
				else
					boxs[boxNum][tmp - 1] = 1;
			}
			for (int j = 0; j < 9; j++)
				row[j] = 0;
		}
		return true;
	}
}
