package array;

public class Q48RotateImage {

	/*
	 * Method 1: 
	 * step 1: turn upside down 
	 * step 2: Flip diagonally
	 * 
	 * 
	 * Results: runtime 0ms beats 100% memory 38.8mb beats 5.17%
	 */
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		// turn upside down
		for (int i = 0; i < len / 2; i++) {
			for (int j = 0; j < len; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len - 1 - i][j];
				matrix[len - 1 - i][j] = tmp;
			}
		}
		// flip diagonally
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}
