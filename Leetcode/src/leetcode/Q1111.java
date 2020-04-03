package leetcode;

public class Q1111 {
	
	
	public int[] maxDepthAfterSplit(String seq) {
		int res[] = new int[seq.length()];
		int depth = 0;
		for (int i = 0; i < seq.length(); i++) {
			if (seq.charAt(i) == '(') {
				depth++;
				res[i] = depth % 2;
			} else {
				depth--;
				res[i] = (depth + 1) % 2;
			}
		}
		return res;
	}
}
