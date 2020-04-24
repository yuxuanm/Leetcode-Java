package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q130 {
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);

	}

	/**Results: runtime: 4ms beats 30.23%
	 * 			memory: 41.6 MB beats 56.25%
	 * */
	public static void solve(char[][] board) {
		//use a flag to indicate whether the current cell is 'O' and whether it is connected with the edge
		boolean[][] flag = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.println(board[i][j]);
				System.out.println(board[i][j] == 'd');
				if (i == 0 || j == 0||i==board.length-1||j==board[0].length-1) {
					if (board[i][j] == 'O') {
						List<Integer> list = new ArrayList<Integer>();
						list.add(i);
						list.add(j);
						BFS(list, flag, board); // if the cell is on any edge and has value 'O', start
												// to search all the 'O' cells connected to it.
						flag[i][j] = true;
					}
				}
			}
		}
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == 'O' && flag[i][j] == false)
					board[i][j] = 'X';
			}
		}

	}

	private static void BFS(List<Integer> list, boolean[][] flag, char[][] board) {
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		int height = board.length - 1;
		int width = board[0].length - 1;

		queue.add(list);
		while (!queue.isEmpty()) {
			List<Integer> l = queue.poll();
			int row = l.get(0);
			int col = l.get(1);
			// check right
			if (col != width && board[row][col + 1] == 'O' && flag[row][col + 1] == false) {
				flag[row][col + 1] = true;
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(row);
				new_list.add(col + 1);
				queue.add(new_list);
			}
			// bottom
			if (row != height && board[row + 1][col] == 'O' && flag[row + 1][col] == false) {
				flag[row + 1][col] = true;
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(row + 1);
				new_list.add(col);
				queue.add(new_list);
			}
			// left
			if (col != 0 && board[row][col - 1] == 'O' && flag[row][col - 1] == false) {
				flag[row][col - 1] = true;
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(row);
				new_list.add(col - 1);
				queue.add(new_list);
			}
			// up
			if (row != 0 && board[row - 1][col] == 'O' && flag[row - 1][col] == false) {
				flag[row - 1][col] = true;
				List<Integer> new_list = new ArrayList<Integer>();
				new_list.add(row - 1);
				new_list.add(col);
				queue.add(new_list);
			}
		}
	}
}
