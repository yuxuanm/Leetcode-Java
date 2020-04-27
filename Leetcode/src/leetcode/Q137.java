package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q137 {
	public static void main(String[] args) {
		System.out.println(~3);
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : nums) {
			if (map.containsKey(n))
				map.put(n, map.get(n) + 1);
			else
				map.put(n, 1);
		}
		for (int k : map.keySet())
			if (map.get(k) == 1)
				return k;
		return -1;

//		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry<Integer, Integer> entry = it.next();
//			if (entry.getValue() == 1)
//				return entry.getKey();
//		}
//		return -1;
	}
}
