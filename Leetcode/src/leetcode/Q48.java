package leetcode;

public class Q48 {
	public void rotate(int[][] matrix) {
        //first rotate, transpose
//		[1,2,3]					[1,4,7]
//		[4,5,6]			to		[2,5,8]
//		[7,8,9]					[3,6,9]
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
//      [1,4,7]					[7,4,1]
//      [2,5,8]         to		[8,5,2]			
//      [3,6,9]		 			[9,6,3]
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                tmp=matrix[i][j];
                matrix[i][j]=matrix[i][n-1-j];
                matrix[i][n-1-j]=tmp;
            }
        }
    }
}
