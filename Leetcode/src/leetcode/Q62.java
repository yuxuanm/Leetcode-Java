package leetcode;

public class Q62 {

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		int res = uniquePaths(m, n);
		System.out.println(res);
	}

	public static int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0) {
					res[i][j]=1;
					continue;
				}
				if(j==0) {
					res[i][j]=1;
					continue;
				}
				res[i][j]=res[i-1][j]+res[i][j-1];
			}
		}
		return res[m-1][n-1];
	}
//	/**Method 2:
//	 * Resutl: Time limit exceeded
//	 */
//	public static int uniquePaths(int m, int n) {
//
//		return path(m, n);
//	}
//
//	public static int path(int m, int n) {
//		if (m == 0 || n == 0)
//			return 0;
//		if (m == 1 && n == 1)
//			return 1;
//		while (m >= 1 && n >= 1) {
//			return path(m - 1, n) + path(m, n - 1);
//		}
//
//		return 0;
//	}

//	/** Method 1:
//	 *  Think the problem as a combination problem.
//	 * 	Total steps: m+n-2
//	 * 	move right: m-1
//	 *  move down : n-1
//	 *  total unique paths C(m+n-2,m-1);
//	 *  Result: out of int limit
//	 * */
//	public static int uniquePaths(int m, int n) {
//		if (m == 1 && n == 1)
//			return 0;
//		return (factorial(m + n - 2) / (factorial(n - 1) * factorial(m - 1)));
//	}
//
//	private static int factorial(int m) {
//		if (m == 1 || m == 0)
//			return 1;
//		return m * factorial(m - 1);
//	}
}
