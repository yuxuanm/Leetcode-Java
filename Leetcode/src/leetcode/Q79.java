package leetcode;

public class Q79 {
	
	public static void main(String[] args) {
//		char [][] board = new char[] []{new char[] {'a','a','b','a','a','b'},
//			new char[] {'a','a','b','b','b','a'},new char[] {'a','a','a','a','b','a'},
//			new char[] {'b','a','b','b','a','b'},new char[] {'a','b','b','a','b','a'},
//			new char[] {'b','a','a','a','a','b'}};
//		String word = "bbbaabbbbbab";
		
		char [][] board = new char[][] {new char[] {'a','b','c','e'},new char[] {'s','f','c','s'},new char[] {'a','d','e','e'}};
		String word = "abcced";
		Q79 q79 = new Q79();
		boolean res = q79.exist(board, word);
		System.out.println(res);
	}
	
	private boolean[][] indicator; // used to indicate whether the cell has been used
	private	boolean flag = false; // once matched, change flag to true
	private char [][] board;
	private String word;
	
	/**Method 1: backtrack
	 * Results: runtime 14 ms beats 21.10%
	 * 			memroy 42.2 MB beats 18.27%
	 * */
    public boolean exist(char[][] board, String word) {
    	this.board=board;
    	this.word=word;
        if(word.length()>board[0].length*board.length)
            return false;
        char c = word.charAt(0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==c){
                	indicator= new boolean[board.length][board[0].length];
                    subExist(i,j,0,0);
                    if(flag)
                    	return true;
                }
            }
        }
        return flag;
    }
    
    /**direction : 1 up 2 right 3 bottom 4 left
     * */
    private void subExist(int row, int col, int index,  int direction){
    	if(index==word.length()-1&&board[row][col]==word.charAt(index)&&indicator[row][col]==false) {
        	//matched condition
        	flag=true;
    		return;
        }
        if(board[row][col]==word.charAt(index)&&indicator[row][col]==false){
            indicator[row][col]=true;
            //check up, top boundary: 0
            if(row!=0 && direction!=3){
                subExist(--row,col,++index,1);
                row++;
                index--;
                if(flag) // if matched, finish all the possible remaining cases
                	return;
            }
            
            //check right, right boundary: board[0].length-1
            if(col!=board[0].length-1&&direction !=4){
                subExist(row,++col,++index,2);
                col--;
                index--;
                if(flag)
                	return;
            }
            //check bottom, bottom boundary: board.length-1
            if(row!=board.length-1&&direction !=1){
                subExist(++row,col,++index,3);
                row--;
                index--;
                if(flag)
                	return;
            }
            //check left, left boundary : 0
            if(col!=0&&direction !=2){
                subExist(row,--col,++index,4);
                col++;
                index--;
                if(flag)
                	return;
            }
            indicator[row][col]=false;
        }
    }
}

