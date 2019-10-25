package leetcode;

import java.util.HashMap;

public class Java136 {
	public static void main(String[] args) {
//		int [] nums = {2,2,1};
//		Java136 j136 = new Java136();
//		int a = j136.singleNumber2(nums);
//		System.out.println(a);
		System.out.println(1^2^1);
		System.out.println(2^2^1^1);
		System.out.println(11^11);
	}
	
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int n:nums) {
			if(map.containsKey(n)) {
				map.remove(n);
				continue;
			}
			map.put(n, 1);
		}
		for(Integer key:map.keySet()) {
			int result = key.intValue();
			return result;
		}
		return -1;
	}
	
	public int singleNumber2(int[] nums) {
		int ans = 0;
		for(int n:nums)
			ans ^= n;
		return ans;
	}
}
