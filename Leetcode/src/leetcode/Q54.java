package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
	public static void main(String[] args) {
//		int [][] matrix=new int [][] {new int[] {1,2,3,4},new int[] {5,6,7,8},new int[] {9,10,11,12}};
//		int [][] matrix=new int [][] {new int[] {1,2,3},new int[] {4,5,6},new int[] {7,8,9}};

		int[][] matrix = new int[][] { new int[] {6,9,7}};
		Q54 q54 = new Q54();
		List<Integer> res = q54.spiralOrder(matrix);
	}

	// wrong method:boundary problem
//	public List<Integer> spiralOrder(int[][] matrix) {
//		if(matrix.length==0)
//			return new ArrayList<Integer>();
//		int colEnd = matrix[0].length - 1;
//		int colStart = 0;
//		int rowStart = 0;
//		int rowEnd = matrix.length - 1;
//		List<Integer> res = new ArrayList<Integer>();
//		char direction = 'r';
//		int col = 0;
//		int row = 0;
//		while (colStart <= colEnd||rowStart<=rowEnd) {
//			if(row<rowStart||row>rowEnd||col<colStart||col>colEnd)
//				break;
//			switch (direction) {
//			case 'r': {
//				while (col < colEnd) {
//					res.add(matrix[row][col]);
//					col++;
//				}
//				res.add(matrix[row][col]);
//				direction = 'd';
//				colEnd--;
//				row++;
//			}
//			case 'd': {
//				if(row>rowEnd) {
//					direction='l';
//					continue;
//				}
//				while (row < rowEnd) {
//					res.add(matrix[row][col]);
//					row++;
//				}
//				res.add(matrix[row][col]);
//				col--;
//				direction = 'l';
//				rowEnd--;
//			}
//			case 'l': {
//
//				while (col > colStart) {
//					res.add(matrix[row][col]);
//					col--;
//				}
//				res.add(matrix[row][col]);
//				colStart++;
//				row--;
//				direction = 'u';
//			}
//			case 'u': {
//				while (row != rowStart+1) {
//					res.add(matrix[row][col]);
//					row--;
//				}
//				res.add(matrix[row][col]);
//				direction = 'r';
//				col++;
//				rowStart++;
//			}
//			}
//		}
//		return res;
//	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if(matrix.length==0)
			return res;
		int top=0;
		int bottom=matrix.length-1;
		int right = matrix[0].length-1;
		int left = 0;
		while(top<=bottom&&left<=right) {
			for(int i=left;i<=right;i++) {
				res.add(matrix[top][i]);
			}
			top++;
			for(int i=top;i<=bottom;i++) {
				res.add(matrix[i][right]);
			}
			right--;
			for(int i=right;i>=left&&top<=bottom;i--) {
				res.add(matrix[bottom][i]);
			}
			bottom--;
			for(int i=bottom;i>=top&&left<=right;i--) {
				res.add(matrix[i][left]);
			}
			left++;
		}
		return res;
	}
}
