package leetcode;

public class Q59 {
	public static void main(String[] args) {
		int n =0;
		Q59 q59 = new Q59();
		int [][] res = q59.generateMatrix(n);
	}
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		if(n==0)
			return res;
		int right = n - 1;//right boundary
		int left = 0; //left boundary
		int top = 0; // top
		int bottom = n - 1; //bottom
		int cur = 1;
		while (left <= right && top <= bottom) {
			//fill top boundary,
			for (int i = left; i <= right; i++) {
				res[top][i] = cur++;
			}
			top++;
			//fill right boundary
			for (int i = top; i <= bottom; i++) {
				res[i][right] = cur++;
			}
			right--;
			//fill bottom boundary
			for (int i = right; i >= left; i--) {
				res[bottom][i] = cur++;
			}
			bottom--;
			//fill left boundary
			for (int i = bottom; i >= top; i--) {
				res[i][left] = cur++;
			}
			left++;
		}
		return res;
	}
}
