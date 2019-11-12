package leetcode;

import java.util.ArrayList;

public class Java155 {
	MinStack minStack = new MinStack();

}

class MinStack {
	int [] stackList = new int[10];
	int index;
	
	/** initialize your data structure here. */
	public MinStack() {
		index = 0;
	}
	
	public void expand() {
		
	}
	
	public void push(int x) {
		stackList[index]=x;
		index++;
	}

	public void pop() {
		int [] newList = new int [stackList.length];
		System.arraycopy(stackList, 0, newList, 0, index-1);
		stackList = newList;
	}

	public int top() {
		return stackList[index];
	}

	public int getMin() {

	}
}