package stringandinteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49GroupAnagrams {

	/*
	 * Method 1: HashMap
	 * An hashmap is used to store <key,List<String>>
	 * Sort each string
	 * 
	 * 
	 * Results: runtime 6ms beats 98.55% memory 41.3mb beats 80.06%.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			String sortS = sort(s);
			if (map.containsKey(sortS)) { // already contain key
				map.get(sortS).add(s);
			} else { // new key
				List<String> tmp = new ArrayList<String>();
				tmp.add(s);
				map.put(sortS, tmp);
				res.add(tmp);
			}
		}
		return res;
	}

	private String sort(String s) {
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}
}
