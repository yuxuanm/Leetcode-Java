package stringandinteger;

import java.util.ArrayList;
import java.util.List;

public class Q17LetterCombinationsOfPhoneNumber {
	
	/*
	 * Method 2
	 * 
	 * Backtrack.
	 * 
	 * Results: runtime 0 ms beats 100%, memory 36.9 mb beats 95.98%.
	 * 
	 * */
	public List<String> letterCombinations2(String digits) {
        if(digits.equals("")||digits==null)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        String [] digits_arr = new String []{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(digits,0, res, new StringBuilder(), digits_arr);
        return res;
    }
    private void backtrack(String digits, int index, List<String> list, StringBuilder sb, String[] digits_arr){
        if(sb.length()==digits.length()){ // end condition
            list.add(sb.toString());
            return;
        }

        for(char c: digits_arr[digits.charAt(index)-'0'-2].toCharArray()){
            sb.append(c);
            backtrack(digits, index+1, list, sb, digits_arr);
            sb.deleteCharAt(index); // remove last character
        }
    }
	
	
	
	/*
	 * Method 1
	 * 
	 * Brute force, call three for loops, add characters layer by layer
	 * 
	 * Results: runtime 6 ms beats 29.02%, memory 38.5 mb beats 30.95%.
	 * 
	 * */
	public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals(""))
            return new ArrayList<String>();
        String [] digits_arr = new String []{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> res = new ArrayList<String>();
        res.add("");
        
        for(int i=0; i<digits.length();i++){
            List<String> tmp = new ArrayList<String>();
            char [] char_arr = digits_arr[digits.charAt(i)-'0'].toCharArray();
            for(String r:res){
                for(char c:char_arr){
                    tmp.add(r+c);
                }
            }
            res = tmp;
        }
        return res;
    }
}
