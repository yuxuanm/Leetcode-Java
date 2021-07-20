package stringandinteger;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.countSubstrings("aaa");
    }
        public int countSubstrings(String s) {
            int res = s.length();

            for(int i = 0; i< s.length(); i++){
                //单
                for(int j = 1; j<Math.min(i,s.length()-1-i); j++){
                    char left = s.charAt(i-j);
                    char right = s.charAt(i+j);
                    if(left == right)
                        res +=1;
                    else
                        break;
                }
                //双
                if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                    for(int j = 0; j< Math.min(i, s.length()-2-i);j++){
                        char left = s.charAt(i-j);
                        char right = s.charAt(i+j+1);
                        if(left == right)
                            res+=1;
                        else
                            break;
                    }
                }
            }

            return res;
        }
}
