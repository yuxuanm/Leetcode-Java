package stringandinteger;

public class Q36CountAndSay {
	/*
	 * Method 1:
	 * Iteration
	 * Special case when n=1, directly return "1"
	 * 
	 * 
	 * Result: runtime 35ms beats 5.59% memory 38.9mb beats 13.38%.
	 * */
	public String countAndSay(int n) {
		if (n == 1)
			return "1";

		String res = "1";
		String tmpres = "";
		for (int i = 2; i <= n; i++) {
			int cnt = 0;
			int cur = res.charAt(0) - '0';
			for (int j = 0; j < res.length(); j++) {
				if (res.charAt(j) - '0' == cur) {
					cnt += 1;
				} else {
					tmpres += cnt;
					tmpres += cur;
					cnt = 1;
					cur = res.charAt(j) - '0';
				}
			}
			tmpres += cnt;
			tmpres += cur;
			res = tmpres;
			tmpres = "";
		}
		return res;
	}
}
