package others;

import java.util.LinkedList;
import java.util.Queue;

public class Q225ImplementStackUsingQueues {
    /**
     * Method 1: use 1 queue
     *
     * Results: runtime 0ms beats 100% memory 35.9mb beats 93.53%
     * */
    private Queue<Integer> queue1;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty())
            queue1.add(x);
        else{
            int n = queue1.size();
            queue1.add(x);
            for(int i = 0; i<n; i++){
                queue1.add(queue1.poll());
            }
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty()?true:false;
    }

    public static void main(String[] args) {
        Q225ImplementStackUsingQueues stack = new Q225ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.top();
        stack.pop();
        stack.empty();
    }
}
