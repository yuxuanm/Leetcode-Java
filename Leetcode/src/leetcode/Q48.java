package leetcode;

public class Q48 {
	public void rotate(int[][] matrix) {
        //first rotate, transpose
        int tmp;
        int n = matrix.length;
        for(int i=0;i<=n;i++){
            for(int j=0;j<n;j++){
                if(j<i) // only rotate once, if j<i, the position has already been rotated
                    continue;
                tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        //second rotate, vertical
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp;
            }
        }
    }
}
