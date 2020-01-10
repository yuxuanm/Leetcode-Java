package leetcode;

import java.util.Arrays;

public class Q6 {
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		System.out.println(convert(s, 4));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		boolean goingUp = false;
		String[] res = new String[numRows];
		Arrays.fill(res, "");
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (goingUp == false) {
				res[index] += c;
				index++;
			}
			if (goingUp == true) {
				res[index] += c;
				index--;
			}
			//change flag condition
			if (i == numRows - 1 || (i - numRows + 1) % (2 * numRows - 2) == 0) {
				goingUp = true;
				index-=2;
			}
			//change flag condition
			if (i == 2 * numRows - 2 || (i - 2 * numRows + 2) % (2 * numRows - 2) == 0) {
				if(i==0)
					continue;
				goingUp = false;
				index+=2;
			}
		}
		String result = "";
		for(String ss : res) {
			result+=ss;
		}
		return result;
	}
}
