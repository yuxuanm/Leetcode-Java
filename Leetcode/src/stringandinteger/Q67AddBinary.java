package stringandinteger;

public class Q67AddBinary {
	
	
	/**
	 * Method 1: Iteration
	 * Add 0 at the front of the shorter String to make the two string same length.
	 * Then add one by one.
	 * 
	 *  Results: runtime 2ms beats 97.98% memory 38.4mb beats 44.00%
	 * */
	public String addBinary(String a, String b) {
		int largeLen = a.length() > b.length() ? a.length() : b.length();
		int smallLen = a.length() > b.length() ? b.length() : a.length();
		String longerStr = a.length() > b.length() ? a : b;
		String shorterStr = a.length() > b.length() ? b : a;

		// add 0 at the front of the shorter String
		for (int i = 0; i < largeLen - smallLen; i++) { 
			shorterStr = 0 + shorterStr;
		}
		
		StringBuilder builder = new StringBuilder();
		int carry = 0;
		for (int i = largeLen - 1; i >= 0; i--) {
			int l = longerStr.charAt(i) - '0';
			int s = shorterStr.charAt(i) - '0';
			if (l + s + carry >= 2) {
				builder.append((l + s + carry) % 2);
				carry = 1;
			} else {
				builder.append((l + s + carry) % 2);
				carry = 0;
			}
		}
		
		if (carry == 1)
			builder.append(1);
		return builder.reverse().toString();
	}
}
