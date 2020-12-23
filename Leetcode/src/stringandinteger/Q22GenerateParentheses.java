package stringandinteger;

import java.util.ArrayList;
import java.util.List;

public class Q22GenerateParentheses {

	/*
	 * Method 1
	 * 
	 * Backtrack, we can add a '(' if there is a '(' left, but the only situation that we
	 * can append a ')' is when there are more ')' than '(' left.
	 * 
	 * Result: runtime 1ms beats 95.86% memory 38.7mb beats 50.67%.
	 * */
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        backtrack(n,n, res, builder);
        return res;
    }

    private void backtrack(int left, int right, List<String> list, StringBuilder builder){ 
        if(left==0 && right ==0)
            list.add(builder.toString());
        
        if(left!=0){ 
            builder.append("(");
            backtrack(left-1, right, list, builder);
            builder.deleteCharAt(builder.length()-1);
        }
        if(right>left){ // only append ')' if there are more ')' than '(' left
            builder.append(")");
            backtrack(left, right-1, list, builder);
            builder.deleteCharAt(builder.length()-1);
        }
        
    }
}
