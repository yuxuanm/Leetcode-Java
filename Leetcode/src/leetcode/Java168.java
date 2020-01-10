package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Java168 {
	public static void main(String[] args) {
		int a = -3;
		System.out.println(a>>>1);
		System.out.println(reverseBits(a));
		
	}
	public static int reverseBits(int n) {
	    int res = 0;
	    int count = 0;
	    while (count < 32) {
	        res =res<< 1;  //res 左移一位空出位置
	        res |= (n & 1); //得到的最低位加过来
	        n >>= 1;//原数字右移一位去掉已经处理过的最低位
	        count++;
	    }
	    return res;
	}

	public int majorityElement(int[] nums) {
		int res = nums[0];
		int cnt=0;
		int size = nums.length;
		int index=0;
		while(index<size-1) {
			if(nums[index]==res)
				cnt++;
			if(nums[index]!=res)
				cnt--;
			if(cnt==0)
				res=nums[index+1];
			index++;
		}
		return res;
		
	}
	
//	public int majorityElement(int[] nums) {
//		int majorityCount = nums.length/2+1;
//		for(int n:nums) {
//			int count =1;
//			for(int m:nums) {
//				if(m==n)
//					count++;
//				if(count>majorityCount)
//					return n;
//			}
//		}
//		return -1;
//	}
//	public int majorityElement(int[] nums) {
//		int result=0;
//		int count=1;
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int n : nums) {
//			if (map.containsKey(n)) {
//				int cnt = map.get(n);
//				map.remove(n);
//				map.put(n, cnt + 1);
//			} else {
//				map.put(n, 1);
//			}
//		}
//		Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
//		while(it.hasNext()) {
//			Map.Entry<Integer, Integer> entry = it.next();
//			count=count>entry.getValue()?count:entry.getValue();
//			result=count>entry.getValue()?result:entry.getKey();
//		}
//		return result;
//	}

	public String convertToTitle(int n) {
		String result = "";
		int yu;
		while (n > 26) {
			yu = n % 26;
			n = n / 26;

			if (yu == 0) {
				result = (char) (26 + 64) + result;
				n = n - 1;
				continue;
			}
			result = (char) (yu + 64) + result;
		}
		result = (char) (n + 64) + result;
		return result;
	}

	public String reverse(String s) {
		char[] arr = s.toCharArray();
		char[] newarr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newarr[i] = arr[arr.length - 1 - i];
		}
		String result = newarr.toString();
		return result;
	}
}
