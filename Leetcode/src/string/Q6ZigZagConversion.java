package string;

public class Q6ZigZagConversion {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		String res = convert(s, 3);
		System.out.println(res);
	}
	
	/*
	 * Method 1: 
	 * 
	 * Use a variable to indicate direction, direction =1 means going down,
	 * direction = -1 means going up
	 * 
	 * Results: runtime 10 ms beats 38.18%
	 * 			memory 39.3 mb beats 41.85%
	 * */
	public static String convert(String s, int numRows) {
		String res = "";

		int minRows = Math.min(numRows, s.length());
		int curRow = 0;

		StringBuilder[] builders = new StringBuilder[minRows];

		for (int i = 0; i < minRows; i++) {
			builders[i] = new StringBuilder();
		}
		int direction = 1;
		for (char c : s.toCharArray()) {
			builders[curRow].append(c);
			if (curRow == 0 && builders[0].length() != 1)
				direction = 1;
			if (curRow == numRows - 1)
				direction = -1;
			curRow += direction;
		}
		for (StringBuilder builder : builders) {
			res += builder.toString();
		}
		return res;
	}
}
