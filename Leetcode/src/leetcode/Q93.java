package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
	public static void main(String[] args) {
		String str = "0000";
		List<String> res = restoreIpAddresses(str);
	}

	/**Method 1: backtrack
	 * 
	 * Results: 7 ms beats 19.18%
	 * 			38.6 MB beats 6.23%
	 * */
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return res;
		for (int i = 0; i < 3; i++) {
			String curIp = s.substring(0, i + 1);
			if (Integer.parseInt(curIp) <= 255 && !(curIp.startsWith("0") && curIp.length() >= 2))
				//any partion of the Ip has to be less than 256 and cannot start with 0
				backtrack(s.substring(i + 1, s.length()), curIp, 3, res);
		}

		return res;
	}

	private static void backtrack(String str, String ip, int partitions, List<String> res) {
		if (str.length() == 0 || str.length() > 4 * partitions || partitions == 1 && Integer.parseInt(str) > 255
				|| partitions == 0 || str.startsWith("0") && str.length() >= 2&&partitions==1)
			//if and of the following circumstances:
			// 	(1) str.length is empty
			//  (2) str length greater than 4* remaining number of ip partitions
			//  (3) number of partitions remained is 0 but str is not empty
			//  (4) str starts with 0
			//  (5) number of partitions remained is 1, but str value > 255 
			//finish the loop and return;
			return;

		if (partitions == 1 && str.length() <= 3 && Integer.parseInt(str) <= 255) {
			res.add(ip + "." + str);
			return;
		}
		for (int i = 0; i < 3 && i < str.length(); i++) {
			String curIp = str.substring(0, i + 1);
			if (curIp.startsWith("0") && curIp.length() >= 2 || Integer.parseInt(curIp) > 255)
				return;
			String remainIp = str.substring(i + 1, str.length());
			backtrack(remainIp, ip + '.' + curIp, partitions - 1, res);

		}
	}
}
