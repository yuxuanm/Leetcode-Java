package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q621TaskScheduler {

    /**
     * Method 1: Greedy
     *
     * Results: runtime 17ms beats 40.23% memory 38.4mb beats 98.27%
     * Solution reference : https://leetcode-cn.com/problems/task-scheduler/solution/jian-ming-yi-dong-de-javajie-da-by-lan-s-jfl9/
     * */
    public int leastInterval1(char[] tasks, int n) {
        // count times that each character appears
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(char c:tasks){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else
                map.put(c, 1);
        }

        int max = 0;
        int maxCnt = 1;
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue()>max){
                max = entry.getValue();
                maxCnt=1;
            } else if (entry.getValue()==max)
                maxCnt +=1;
        }
        return Math.max((max-1)*(n+1) + maxCnt, tasks.length);
    }
}
