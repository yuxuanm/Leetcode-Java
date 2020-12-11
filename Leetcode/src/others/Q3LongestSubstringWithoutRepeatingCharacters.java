package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3LongestSubstringWithoutRepeatingCharacters {

	/*
	 * Method 1:
	 * 
	 * Brute force: use two pointers to check every possible combinations. Use a
	 * HashMap to store keys, if the new input exists in the map, then stop
	 * current round of iteration and calculate the size of the map.
	 * 
	 * Results: runtime 145 ms beats 10.88% 
	 * 			memory 39.1 mb beats 32.28%
	 * 
	 * Improvement: use HashSet with contains method.
	 * 
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null)
			return 0;
		int res = 0;
		Map<Character, Integer> map;
		for (int i = 0; i < s.length(); i++) {
			map = new HashMap<Character, Integer>();
			for (int j = i; j < s.length(); j++) {
				if (map.containsKey(s.charAt(j))) {
					res = map.size() > res ? map.size() : res;
					break;
				} else {
					map.put(s.charAt(j), 1);
					if (j == s.length() - 1)
						res = map.size() > res ? map.size() : res;
				}
			}
		}
		return res;
	}

	
	/*
	 * Method 2:
	 * 
	 * Sliding window (two pointers): 
	 * 
	 * Results: runtime 10 ms beats 36.18%% 
	 * 			memory 38.5 mb beats 81.57%
	 * 
	 */
	public static int lengthOfLongestSubstring2(String s) {
		int res = 0;
		List<Character> characters = new ArrayList<Character>();
		List<Integer> index = new ArrayList<Integer>();
		int smallestIndex = 0; // indicate the most left valid character

		for (int i = 0; i < s.length(); i++) {
			if (characters.contains(s.charAt(i))) { // current character already exists
				res = res > characters.size() ? res : characters.size();
				// latestIndex: the index that the current input character locate 
				int latestIndex = characters.indexOf(s.charAt(i)); 
				for (int j = smallestIndex; j <= latestIndex; j++) { // remove all between them
					characters.remove(0);
					index.remove(0);
				}
			} 
			characters.add( s.charAt(i));
			index.add(i);
		}
		res = res > characters.size() ? res : characters.size();
		return res;
	}
	public static void main(String[] args) {
		String s = " ";
		int res = lengthOfLongestSubstring2(s);
		System.out.println(res);
	}
}
