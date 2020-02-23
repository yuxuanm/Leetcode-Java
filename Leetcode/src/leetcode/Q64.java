package leetcode;

public class Q64 {
	
	 /**for each cell, the minimum steps required is
	  * path(i,j)=min(path(i-1,j),min(i,j-1))+grid[i][j]
	  * */
	 public int minPathSum(int[][] grid) {
	        int res [][] = new int[grid.length][grid[0].length];
	        res[0][0]=grid[0][0];
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[0].length;j++){
	                if(i==0&&j==0){
	                    res[0][0]=grid[0][0];
	                    continue;
	                }
	                if(i==0){
	                    res[0][j]=res[0][j-1]+grid[0][j];
	                    continue;
	                }
	                if(j==0){
	                    res[i][0]=res[i-1][0]+grid[i][0];
	                    continue;
	                }
	                
	                res[i][j]=grid[i][j]+Math.min(res[i-1][j],res[i][j-1]);
	            }
	        }
	        return res[grid.length-1][grid[0].length-1];
	    }
}
