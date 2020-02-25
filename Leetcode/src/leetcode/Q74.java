package leetcode;

public class Q74 {
	public static void main(String[] args) {
		Q74 q74 = new Q74();
		int[][] matrix = new int[][] {new int[] {1,3,5,7},new int[] {10,11,16,20},new int[] {23,30,34,50}};
		System.out.println(q74.searchMatrix(matrix, 1));
	}
	
	/**Method 3: Binary search
	 * Runtime: 0ms beats 100%
	 * memory: 41.8MB beats 36.24%
	 * */
	public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end=matrix.length*matrix[0].length-1;
        int mid = (start+end)/2;
        int row,col;
        while(start<=end){
        	mid=(start+end)/2;
            row = mid/matrix[0].length;
            col = mid%matrix[0].length;
            if(matrix[row][col]==target)
                return true;
            if(matrix[row][col]<target){
                start=mid+1;
            }
            if(matrix[row][col]>target){
                end=mid-1;
            }
        }
        return false;
    }
	
	/**Method 2: search the first cell of each sub array firstly to locate which sub array the target
	 * 			 belongs to, then search the sub array one by one
	 * runtime: 0 ms beats 100%
	 * memory: 42 MB beats
	 * */
//	 public boolean searchMatrix(int[][] matrix, int target) {
//	        if(matrix.length==0)
//	            return false;
//	        for(int i=0;i<=matrix.length-2;i++){
//	            if(matrix[i][0]<=target&&matrix[i+1][0]>target){
//	                for(int j=0;j<matrix[0].length;j++){
//	                    if(matrix[i][j]==target)
//	                        return true;
//	                }
//	            }
//	        }
//	        
//	        for(int j=0;j<matrix[0].length;j++){
//	            if(matrix[matrix.length-1][j]==target){
//	                return true;
//	            }
//	        }
//	        return false;
//	    }
	
	/**Method 1: search matrix one by one
	 * 
	 * runtime: 1ms beats 42.69%
	 * memory: 42MB beats 31.42%
	 * */
//	public boolean searchMatrix(int[][] matrix, int target) {
//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                if(matrix[i][j]==target)
//                    return true;
//            }
//        }
//        return false;
//    }
}
