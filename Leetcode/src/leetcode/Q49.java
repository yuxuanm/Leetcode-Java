package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q49 {
	public static void main(String[] args) {
		String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		Q49 q49 = new Q49();
//		System.out.println(q49.sortStr("eat"));
		List<List<String>> res = q49.groupAnagrams(strs);
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		for(String str:strs) {
			String key = sortStr(str);
			if(map.containsKey(key))
				map.get(key).add(str);
			else {
				List<String> list = new ArrayList<String>();
				list.add(str);
				map.put(key, list);
			}
		}
//		outer:for(String str:strs) {
//			for(List<String> r:res) {
//				if(sortStr(r.get(0)).equals(sortStr(str))) {
//					r.add(str);
//					continue outer;
//				}
//			}
//			ArrayList<String> l = new ArrayList<String>();
//			l.add(str);
//			res.add(l);
//		}
		return new ArrayList<List<String>>(map.values());
	}
	
	private String sortStr(String str) {
		char [] charArr = str.toCharArray();
		Arrays.sort(charArr);
//		for(int i=0;i<charArr.length-1;i++) {
//			char tmp;
//			for(int j=i+1;j<charArr.length;j++) {
//				if(charArr[i]-charArr[j]>0) {
//					tmp=charArr[j];
//					charArr[j]=charArr[i];
//					charArr[i]=tmp;
//				}
//			}
//		}
		return new String(charArr);
	}
}
