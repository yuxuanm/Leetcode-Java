package stringandinteger;

public class Q58LengthofLastWord{
	
	/*
	 * Nothing to say.
	 * 
	 * Results: runtime 1ms beats 37.75% memory 37.1mb beats 15.96%.
	 * */
	public int lengthOfLastWord(String s) {
		if (s == null || s.trim().equals(""))
			return 0;
		String[] arr = s.split(" ");
		return arr[arr.length - 1].length();
	}
}
