package stringandinteger;

import java.util.Stack;

public class Q20ValidParentheses {
	public static void main(String[] args) {
		String s="(]";
		System.out.println(isValid(s));
	}
	
	/*
	 * Method 1
	 * 
	 * Use stack, push into stack if the current character is '([{', else pop
	 * 
	 * Results: runtime 2ms beats 75.69% memory 36.4mb beats 92.69%.
	 * */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
                if(stack.isEmpty()) 
                    return false;
				char c2 = stack.pop();
				if (c == ')' && c2 != '(')
					return false;
				else if (c == ']' && c2 != '[')
					return false;
				else if (c == '}' && c2 != '{')
					return false;
			}
		}
		return stack.isEmpty();
	}
}
