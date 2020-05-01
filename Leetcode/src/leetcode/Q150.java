package leetcode;

import java.util.Stack;

public class Q150 {
	public static void main(String[] args) {
		String [] arr = new String[] {"2","1","+","3","*"};
		int res = evalRPN(arr);
	}
	
	/**use stack
	 * */
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String t:tokens){
            if(t.equals("+")||t.equals("-")||t.equals("*")||t.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int res;
                if(t.equals("+")) {
                    stack.push(b+a);
                    continue;
                }
                if(t.equals("-")) {
                	stack.push(b-a);
                	continue;
                }
                if(t.equals("*")) {
                	stack.push(b*a);
                	continue;
                }
                else
                    stack.push(b/a);
            }
            else
                stack.push(Integer.parseInt(t));
        }
        return stack.pop();
    }
}
