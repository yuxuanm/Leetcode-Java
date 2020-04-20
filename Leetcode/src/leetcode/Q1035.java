package leetcode;

public class Q1035 {
	// similarto Q1143, longest common subsequence.
	
	
	/**Dynamic programming
	 * */
	public int maxUncrossedLines(int[] A, int[] B) {
		int res[][] = new int[A.length + 1][B.length + 1];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (i == 0 || j == 0) {
					res[i][j] = 0;
					continue;
				}
				if (A[i - 1] == B[j - 1])
					res[i][j] = res[i - 1][j - 1] + 1;
				else
					res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
			}
		}
		return res[A.length][B.length];
	}
}
