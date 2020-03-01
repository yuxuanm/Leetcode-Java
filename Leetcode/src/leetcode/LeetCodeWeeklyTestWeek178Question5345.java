package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCodeWeeklyTestWeek178Question5345 {
	
	/**Method: use int[] to store votes for each character
	 * 		   rewrite the compare method
	 * */
	public String rankTeams(String[] votes) {
		if (votes.length == 1)
			return votes[0];
		Map<Character, int[]> map = new HashMap<Character, int[]>();
		for (int i = 0; i < votes.length; i++) {
			for (int j = 0; j < votes[0].length(); j++) {
				if (!map.containsKey(votes[i].charAt(j))) { 
					int[] count = new int[votes[0].length()]; // initial count[] with zeros
					count[j]=1;
					map.put(votes[i].charAt(j), count);
				}
				else {
					int [] count = map.get(votes[i].charAt(j));
					count[j]=count[j]+1;
					map.put(votes[i].charAt(j), count);
				}
			}
		}

		List<Map.Entry<Character, int[]>> list = new ArrayList<Map.Entry<Character, int[]>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Character, int[]>>() {
		//sort
			@Override
			public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character, int[]> o2) {
				int [] count1 = o1.getValue();
				int [] count2 = o2.getValue();
				for(int i=0;i<count1.length;i++) {
					if(count1[i]!=count2[i])
						return count2[i]-count1[i];
				}
				return o1.getKey()-o2.getKey();
			}

		});
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character, int[]> l:list) {
			sb.append(l.getKey());
		}
		return sb.toString();
		
	}
}
