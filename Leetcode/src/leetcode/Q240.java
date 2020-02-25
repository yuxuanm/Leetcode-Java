package leetcode;

public class Q240 {
	public static void main(String[] args) {
		int [][] matrix = new int[5][];
		matrix[0]=new int[] {1,4,7,11,15};
		matrix[1]=new int[] {2,5,8,12,19};
		matrix[2]=new int[] {3,6,9,16,22};
		matrix[3]=new int[] {10,13,14,17,24};
		matrix[4]=new int[] {18,21,23,26,30};
		
		Q240 q240 = new Q240();
		System.out.println(q240.searchMatrix(matrix, 20));
	
	}
	
	/**Method 3(From Leetcode): start from left-bottom corner, if the current value>target, then row--
	 * 														   if the current value<target, then col++
	 * 
	 * runtime: 7 ms beats 87.94%
	 * memory: 42.3MB beats 67.73%
	 * */
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while(row>=0&&col<=matrix[0].length-1){
            if(matrix[row][col]==target)
                return true;
            if(matrix[row][col]<target) {
                col++;
                continue;
            }
            if(matrix[row][col]>target) {
                row--;
                continue;
            }
        }
        return false;
    }
	
	/** Method 2: binary search
	 * Runtime: 8ms beats 49.41%
	 * memory: 42MB beats 80.44%
	 * */
//	public boolean searchMatrix(int[][] matrix, int target) {
//        if(matrix.length==0||matrix[0].length==0)
//            return false;
//        for(int i=0;i<matrix.length;i++){
//        	//check whether target is in the current sub array
//            if(matrix[i][0]>target||matrix[i][matrix[0].length-1]<target)
//                continue;
//            else{
//            	//call binary search to check if the target is in the array
//                if(binarySearch(matrix[i],target))
//                    return true;
//            }
//        }
//        return false;
//    }
//    
//    private boolean binarySearch(int[] subArray, int target){
//        int start = 0;
//        int end = subArray.length-1;
//        int mid ;
//        while(start<=end){
//            mid=(start+end)/2;
//            if(subArray[mid]==target)
//                return true;
//            if(subArray[mid]>target)
//                end=mid-1;
//            if(subArray[mid]<target)
//                start=mid+1;
//        }
//        return false;
//    }
	
	/**Method 1: search matrix one by one
	 * 
	 * runtime: 21ms beats 5.44%
	 * memory: 42.4MB beats 62.60%
	 * 
	 * */
//	public boolean searchMatrix(int[][] matrix, int target) {
//		for (int i = 0; i < matrix.length; i++) {
//			for (int j = 0; j < matrix[0].length; j++) {
//				if (matrix[i][j] == target)
//					return true;
//			}
//		}
//		return false;
//	}
}
