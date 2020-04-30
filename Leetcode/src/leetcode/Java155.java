package leetcode;

import java.util.ArrayList;

public class Java155 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(1);
		minStack.push(2);
		minStack.push(3);
		minStack.push(4);
		System.out.println(minStack.top());
	}
}

//class MinStack {
//	int [] stackList = new int[10];
//	int index = 0;
//	
//	/** initialize your data structure here. */
//	public MinStack() {
//	}
//	
//	public void expand() {
//		int [] newList = new int [stackList.length*2];
//		System.arraycopy(stackList, 0, newList, 0, index);
//		stackList = newList;
//	}
//	
//	public void push(int x) {
//		if(index == stackList.length-1) {
//			this.expand();
//		}
//		stackList[index]=x;
//		index++;
//	}
//
//	public void pop() {
//		int [] newList = new int [stackList.length];
//		System.arraycopy(stackList, 0, newList, 0, index-1);
//		stackList = newList;
//	}
//
//	public int top() {
//		return stackList[index];
//	}
//
////	public int getMin() {
//
////	}
//}