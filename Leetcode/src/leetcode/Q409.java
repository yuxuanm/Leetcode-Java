package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q409 {
	public static void main(String[] args) {
		String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		int res = longestPalindrome(s);
		System.out.println(res);
	}
	public static  int longestPalindrome(String s) {
        int sum = 0;
        // use a HashMap to count the times each character appears
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(Character.valueOf(c)))
                map.put(Character.valueOf(c),map.get(Character.valueOf(c))+1);
            else
                map.put(Character.valueOf(c),new Integer(1));
        }
        
        boolean flag=false;//use flag to indicate whether there is a character that appears odd number of times
        
        Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()) {
        	Map.Entry<Character, Integer> entry = it.next();
        	if((entry.getValue().intValue()&1)==0)
        		sum+=entry.getValue().intValue();
        	else {
        		flag = true;// if there is a character appear odd number of times
        		sum+=entry.getValue().intValue()-1;
        	}
        }
        return flag?sum+1:sum;
	}
}
