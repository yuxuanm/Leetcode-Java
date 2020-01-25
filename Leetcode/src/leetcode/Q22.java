package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
	
	 public List<String> generateParenthesis(int n) {
	       if(n==0)
	    	   return null;
	       List<String> res = new ArrayList<String>();
	       generateDFS("", n, n, res);
	       return res;
	 }
	 
	 public void generateDFS(String curStr, int left, int right, List<String> res) {
		 	if(left==0&&right==0) {
		 		res.add(curStr);
		 		return;
		 	}
		 	
		 	if(left>right)
		 		return;
		 	if(left>0)
		 		generateDFS(curStr+"(", left-1, right, res);
		 	if(right>0)
		 		generateDFS(curStr+")", left, right-1, res);
	 }
}
