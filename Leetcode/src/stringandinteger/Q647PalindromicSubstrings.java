package stringandinteger;

public class Q647PalindromicSubstrings {

    /**Method 2:
     *
     * time complexity: O(n^2)
     *
     * Results: runtime 3ms beats 93.76% memory 36.6mb beats 65.40%
     * */
    public int countSubstrings2(String s) {
        int res = s.length();

        for(int i = 0; i< s.length(); i++){
            //单
            for(int j = 1; j<=Math.min(i,s.length()-1-i); j++){
                char left = s.charAt(i-j);
                char right = s.charAt(i+j);
                if(left == right)
                    res +=1;
                else
                    break;
            }
            //双
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                res +=1;
                for(int j = 1; j<= Math.min(i, s.length()-2-i);j++){
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

    /** Method1:
     * brute force, iteration every substring
     * time complexity: O(n^3)
     *
     * Results: runtime 456 ms beats 5.34% memory 36.8mb beats 51.43%
     * */
    public int countSubstrings1(String s) {
        int cnt = s.length();

        for(int i = 0; i< s.length()-1; i++){
            for(int j = i+1; j<s.length(); j++){
                cnt += helper(s,i,j);
            }
        }
        return cnt;
    }

    private int helper(String s, int startIndex, int endIndex){
        while(startIndex<=endIndex){
            if(s.charAt(startIndex++) != s.charAt(endIndex--))
                return 0;
        }
        return 1;
    }


}
