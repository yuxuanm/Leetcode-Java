package leetcode;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Java1552 {
	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(2);
		obj.push(0);
		obj.push(3);
		obj.push(0);

		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.getMin());

	}
}

class MinStack {
	/** initialize your data structure here. */
//    private int [] data = new int [10];
	private String[] data = new String[10];
	private int index = 0;

	public MinStack() {

	}

	public void push(int x) {
		if (index >= data.length)
			data = Arrays.copyOf(data, data.length * 2);
		data[index] = String.valueOf(x);
		index++;
	}

	public int peek() {
		if (index <= 0) {
			throw new EmptyStackException();
		}
		return Integer.parseInt(data[index - 1]);
	}

	public void pop() {
//        String [] data2=new String[10];
//        System.arraycopy(data,0,data2,0,index-1);
//        data=data2;
//        index--;
		int a = peek();
		index--;
	}

	public int top() {
		return Integer.parseInt(data[index - 1]);
	}

	public int getMin() {
		int min = Integer.parseInt(data[0]);
		for (int i = 0; i < index; i++) {
			if (Integer.parseInt(data[i]) < min)
				min = Integer.parseInt(data[i]);
		}
		return min;
	}

}
