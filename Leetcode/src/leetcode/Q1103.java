package leetcode;

public class Q1103 {
	public static void main(String[] args) {
		int [] res = distributeCandies(10, 3);
	}
	public static int[] distributeCandies(int candies, int num_people) {
		int remain = candies;
		int[] res = new int[num_people];
		int cur = 1;
		int position = 0;
		while (remain > 0) {
			if (remain < cur) {
				res[position] = res[position] + remain;
				break;
			}
			res[position] = res[position] + cur;
			remain -= cur++;
			position++;
			if (position == num_people)
				position = 0;
		}
		return res;
	}
}
