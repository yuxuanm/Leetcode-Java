package leetcode;

public class InterviewQ59 {
	public static void main(String[] args) {
		MaxQueue queue = new MaxQueue();
		queue.push_back(4);
		queue.push_back(2);
		queue.push_back(3);
		System.out.println(queue.max_value());
		queue.pop_front();
		System.out.println(queue.max_value());
	}
}

class MaxQueue {
	int[] queue;
	int front = 0;
	int end = 0;

	public MaxQueue() {
		queue = new int[10]; // intial queue with length of 10
	}

	public int max_value() {
		if (front == end)
			return -1;
		int max = queue[front];
		for (int i = front; i < end; i++) {
			max = Math.max(max, queue[i]);
		}
		return max;
	}

	public void push_back(int value) {
		expand();
		queue[end] = value;
		end++;
	}

	private void expand() {
		if (end == queue.length) {
			int len = queue.length;
			int[] newQueue = new int[len * 2];
			System.arraycopy(queue, front, newQueue, 0, end - front);
			queue = newQueue;
			end = end - front;
			front = 0;
		}

	}

	public int pop_front() {
		if (front == end)
			return -1;
		return queue[front++];
	}
}