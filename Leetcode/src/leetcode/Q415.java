package leetcode;

public class Q415 {

	public static void main(String[] args) {
		String num1 = "98";
		String num2 = "9";
		Q415 q415 = new Q415();
		String res = q415.addStrings(num1, num2);
		System.out.println(res);
	}

	public String addStrings(String num1, String num2) {
		String res = "";
		if (num1.length() >= num2.length())
			res = addStr(num1, num2);
		else
			res = addStr(num2, num1);
		return res;
	}

	// default num1.length>=num2.length;
	private String addStr(String num1, String num2) {
		String res = "";
		int curSum = 0;
		int jinWei = 0;
		int len1 = num1.length();
		int len2 = num2.length();
		outer:for (int i = 1; i <= len1; i++) {
			while (i <= len2) {
				curSum = num1.charAt(len1 - i) - '0' + num2.charAt(len2 - i) - '0' + jinWei;
				if (curSum >= 10)
					jinWei = 1;
				if (0 <= curSum && curSum < 10)
					jinWei = 0;
				res = curSum % 10 + res;
				continue outer;
			}
			curSum = num1.charAt(len1 - i) - '0' + jinWei;
			if (curSum >= 10)
				jinWei = 1;
			if (0 <= curSum && curSum < 10)
				jinWei = 0;
			res = curSum % 10 + res;
		}
		
		if (jinWei == 1)
			res = "1" + res;
		return res;
	}

//	public String addStrings(String num1, String num2) {
//        String res = "";
//        int len1=num1.length();
//        int len2=num2.length(); 
//        int minLen = Math.min(len1,len2);
//        int jinWei = 0;
//        int cur=0;
//        
//        for(int i=1;i<=minLen;i++){
//            // cur=Integer.parseInt(num1.charAt(len1-i))+Integer.parseInt(num2.charAt(len2-i))+jinWei;
//            cur=num1.charAt(len1-i)-'0'+num2.charAt(len2-i)-'0'+jinWei;
//            if(cur>=10)
//                jinWei=1;
//            if(0<=cur&&cur<10)
//                jinWei=0;
//            res=String.valueOf(cur%10)+res;
//        }
//
//        int remainLen=Math.max(len1,len2)-minLen;
//        String subRes= len1>len2?addSubStrings(num1,remainLen,jinWei):addSubStrings(num2,remainLen,jinWei);
////        res=(len1>len2?addSubStrings(num1,remainLen,jinWei):addSubStrings(num2,remainLen,jinWei)+res);
//        res=subRes+res;
//        return res;
//    }
//    
//    private String addSubStrings(String num, int len, int jinWei){
//        String res = "";
//    int cur=0;
//        for(int i=len-1;i>=0;i--){
//            // cur=Integer.parseInt(num1.charAt(len1-i))+Integer.parseInt(num2.charAt(len2-i))+jinWei;
//            cur=num.charAt(i)-'0'+jinWei;
//            if(cur>=10)
//                jinWei=1;
//            if(0<=cur&&cur<10)
//                jinWei=0;
//            res=String.valueOf(cur%10)+res;
//        }
//        if(jinWei==1)
//            res="1"+res;
//        
//        return res;
//    }
}
