package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q36 {
	public static void main(String[] args) {
		char[][] board = new char[][] {{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','9','.'},{'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','1'},{'.','.','.','7','.','.','.','.','.'},{'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
		Q36 q36 = new Q36();
		
		System.out.println(q36.isValidSudoku(board));
		
	}
	public boolean isValidSudoku(char[][] board) {
		Map<Character,Integer> rowMap ;
		Map<Character,Integer> colMap;
		Map<Character,Integer> subSudoku1 = null;
		Map<Character,Integer> subSudoku2 = null;
		Map<Character,Integer> subSudoku3 = null;
		for(int i=0;i<9;i++) {
			if(i==0||i==3||i==6) { //Initialize sub sudoku
				subSudoku1 = new HashMap<Character, Integer>();
				subSudoku2 = new HashMap<Character, Integer>();
				subSudoku3 = new HashMap<Character, Integer>();
			}
			rowMap = new HashMap<Character, Integer>();
			colMap = new HashMap<Character, Integer>();
			for(int j=0;j<9;j++) {
				/* check every row
				 * */
				if(board[i][j]!='.'&&rowMap.containsKey(board[i][j]))
					return false;
				rowMap.put(board[i][j], 1);
				
				//check every column
				if(board[j][i]!='.'&&colMap.containsKey(board[j][i]))
					return false;
				colMap.put(board[j][i],1);
				
				//check every sub sudoku
				if(j/3==0) {
					if(board[i][j]!='.'&&subSudoku1.containsKey(board[i][j]))
						return false;
					subSudoku1.put(board[i][j], 1);
				}
				if(j/3==1) {
					if(board[i][j]!='.'&&subSudoku2.containsKey(board[i][j]))
						return false;
					subSudoku2.put(board[i][j], 1);
				}
				if(j/3==2) {
					if(board[i][j]!='.'&&subSudoku3.containsKey(board[i][j]))
						return false;
					subSudoku3.put(board[i][j], 1);
				}
			}
		}
		
		return true;
	}
}
