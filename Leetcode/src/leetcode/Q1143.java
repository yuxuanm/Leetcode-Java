package leetcode;

public class Q1143 {
	// longest common subsequence (very important)
	
	/**Dynamic programming
	 * */
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] res = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				if (i == 0 || j == 0) {
					res[i][j] = 0;
					continue;
				}
				if (text1.charAt(i - 1) == text2.charAt(j - 1))
					res[i][j] = res[i - 1][j - 1] + 1;
				else
					res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
			}
		}
		return res[text1.length()][text2.length()];
	}
}
