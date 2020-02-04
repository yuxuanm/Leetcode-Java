package leetcode;

public class Q43 {
	public static void main(String[] args) {
		Q43 q43 = new Q43();
		String res = q43.multiply(new String("456"), new String("123"));
		System.out.println(res);
	}
	
	public String multiply(String num1, String num2) {
		if(num1=="0"||num2=="0")
			return new String("0");
        int len1=num1.length();
        int len2=num2.length();
        String res="";
        String subRes="";
        int cur=0;
        int next=0;
        int n1;
        int n2;
        for(int i=1;i<=len1;i++){
            n1=num1.charAt(len1-i)-'0';
            cur=0;
            next=0;
            subRes="";
            for(int k=0;k<i-1;k++) {
            	subRes+="0";
            }
            for(int j=1;j<=len2;j++){
                n2=num2.charAt(len2-j)-'0';
                cur=(n1*n2+next)%10;
                next=(n1*n2+next)/10;   
                subRes=String.valueOf(cur)+subRes;
                if(j==len2&&next!=0)
                	subRes=String.valueOf(next)+subRes;
            }
            res=addTwoStrings(res,subRes);
        }

        return res;
    }
	private String addTwoStrings(String res,String subRes) {
		StringBuilder builder = new StringBuilder();
		int len1=res.length();
		int len2=subRes.length();
		int n1, n2,cur,next =0;
		while(len1>0||len2>0) {
			n1=len1>0?res.charAt(len1-1)-'0':0;
			n2=len2>0?subRes.charAt(len2-1)-'0':0;
			cur=(n1+n2+next)%10;
			next=(n1+n2+next)/10;
			len1--;len2--;
			builder.append(cur);
			if(len1<=0&&len2<=0&&next!=0)
				builder.append(next);
		}
		return builder.reverse().toString();
	}
//	private String addTwoStrings(String res,String subRes) {
//		int len1=res.length();
//		int len2=subRes.length();
//		int n1, n2,cur,next =0;
//		String ans="";
//		while(len1>0||len2>0) {
//			n1=len1>0?res.charAt(len1-1)-'0':0;
//			n2=len2>0?subRes.charAt(len2-1)-'0':0;
//			cur=(n1+n2+next)%10;
//			next=(n1+n2+next)/10;
//			len1--;len2--;
//			ans=String.valueOf(cur)+ans;
//			if(len1<=0&&len2<=0&&next!=0)
//				ans=String.valueOf(next)+ans;
//		}
//		return ans;
//	}
	
	//Method 2(Wrong, can only return up to Integer.MAX_VALUE)
//	 public String multiply(String num1, String num2) {
//	        int len1=num1.length();
//	        int len2=num2.length();
//	        int res=0;
//	        int subRes=0;
//	        int cur=0;
//	        int next=0;
//	        int n1;
//	        int n2;
//	        for(int i=1;i<=len1;i++){
//	            n1=num1.charAt(len1-i)-'0';
//	            cur=0;
//	            next=0;
//	            subRes=0;
//	            for(int j=1;j<=len2;j++){
//	                n2=num2.charAt(len2-j)-'0';
//	                cur=(n1*n2+next)%10;
//	                next=(n1*n2+next)/10;   
//	                subRes+=cur*Math.pow(10,j-1);
//	                if(j==len2)
//	                    subRes+=next*Math.pow(10,j);  
//	            }
//	            res+=subRes*Math.pow(10,i-1);
//	        }
//
//	        return String.valueOf(res);
//	    }
}
