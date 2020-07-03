package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q161 {
	public static void main(String[] args) {
		String s = "ba";
		String t = "a";
		boolean res = isOneEditDistance(s, t);
		System.out.println(res);
	}
	public static boolean isOneEditDistance(String s, String t) {
		if (s.length() - t.length() >= 2 || s.length() - t.length() <= -2) {
			return false;
		}
		int difCount = 0;
		Queue<Character> queue = new LinkedList<Character>();
		for (int i = 0; i < t.length(); i++) {
			queue.add(t.charAt(i));
		}

		if (s.length() == t.length()) {
			for (int i = 0; i < t.length(); i++) {
				char c = queue.poll();
				if (s.charAt(i) != c) {
					if (difCount == 1)
						return false;
					difCount += 1;
				}
			}
		}
		else if (s.length() > t.length()) {
			for (int i = 0; i < s.length(); i++) {
				if (queue.peek() == s.charAt(i)) {
					queue.poll();
				} else {
					difCount += 1;
				}
			}
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (queue.poll() != s.charAt(i)) {
					queue.poll();
					difCount += 1;
				} else {
					continue;
				}
			}
		}
		return difCount < 2;
	}
}
