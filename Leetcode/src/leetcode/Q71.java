package leetcode;

import java.util.Stack;

public class Q71 {
	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
//		String path = "/home/";
		Q71 q71 = new Q71();
		System.out.println(q71.simplifyPath(path));
	}

	public String simplifyPath(String path) {
		String[] paths = path.split("\\/+");
		Stack<String> stack = new Stack<String>();
		for (String p : paths) {
			if (!p.equals(".") &&!p.equals("..")&& p.length()>0)
				stack.push(p);
			if (p.equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.insert(0, stack.pop()).insert(0, "/");
		return sb.length() == 0 ? "/" : sb.toString();
	}

//	/**Method 1: regex pattern
//	 * Steps: 1. remove end '/'
//	 * 		  2. remove '/.'
//	 * 		  3. remove duplicated '////'
//	 * 		  4. count number of '/..'
//	 *        .....
//	 * Too complicated
//	 * */
//	 public String simplifyPath(String path) {
//	        //remove end '/'
//	        if(path.endWith('/'))
//	            path=path.copyOf(0,path.length-2);
//	        
//	        //remove '\.'
//	        String regex2 = "(\\/\\.)(?!\\.)";
//	        path=path.replaceAll(regex2,"");
//	        
//	        //remove duplicated '///'
//	        String regex1 = "(\\/)\\1+";
//	        path = path.replaceAll(regex1,"$1");
//	        
//	        //count number of '/..'
//	        int cnt = 0;
//	        String regex3 = "(\\/\\.\\.)";
//	        Pattern pattern = Pattern.compile(regex3);
//	        Matcher matcher = pattern.Matcher(path);
//	        while(matcher.find())
//	            cnt++;
//	        
//	        //remove '/..'
//	        path=path.replaceAll(regex3,"");
//	        
//	        //count number of '/a'
//	        int cntFolder = 0;
//	        String regex4="(\\/\\w+)"
//	        Pattern patternFolder = Pattern.compile(regex4);
//	        Matcher matcherFolder = patternFolder.Matcher(path);
//	        while(matcherFolder.find())
//	            cntFolder++;
//	        
//	        int remain = cntFolder-cnt;
//	        StringBuilder builder = new StringBuilder();
//	        for(int i=1;i<=remain;i++){
//	            
//	        }
//	        
//	    }
}
