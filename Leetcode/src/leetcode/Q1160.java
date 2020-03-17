package leetcode;

import java.util.Arrays;

public class Q1160 {
	public static void main(String[] args) {
		for(int i = 0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println("jjj:"+j);
				break;
			}
			System.out.println("iii: "+ i);
		}
	}
	public int countCharacters(String[] words, String chars) {
		int sum = 0;
		char[] charsArr = chars.toCharArray();
		Arrays.sort(charsArr); // sort the array, so we can match all characters with 1 loop
		outer: for (String s : words) {
			if (s.length() > chars.length())
				continue;
			char[] wordsArr = s.toCharArray();
			Arrays.sort(wordsArr);
			int index = 0;
			for (int i = 0; i < chars.length(); i++) { // match every char
				if (wordsArr[index] == charsArr[i]) {
					if (index == s.length() - 1) {
						sum += s.length();
						continue outer;
					}
					index++;
				}
			}
		}
		return sum;
	}
}
