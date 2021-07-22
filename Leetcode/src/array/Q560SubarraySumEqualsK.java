package array;

import java.util.HashMap;
import java.util.Map;

public class Q560SubarraySumEqualsK {

    /**
     * Method 2: HashMap + array
     * 
     * Results: 20ms beats 97.53% memory 40.4mb beats 96.85%
     * */
    public int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int curSum = 0;
        int res = 0;
        for(int i = 0; i<nums.length; i++){
            curSum += nums[i];
            if(map.containsKey(curSum-k)){
                res += map.get(curSum-k);
            }
            if(map.containsKey(curSum)){
                map.put(curSum, map.get(curSum)+1);
            } else {
                map.put(curSum, 1);
            }
        }
        return res;
    }

    /**
     * Method 1: brute force, two iterations
     *
     * Results : runtime 1094ms beats 36.47% memory 41.7mb beats 12.54%
     * */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int curSum;
        for (int i = 0; i < nums.length; i++) {
            curSum = nums[i];
            if (curSum == k) {
                res += 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (curSum + nums[j] == k) {
                    res += 1;
                    curSum = k;
                } else {
                    curSum += nums[j];
                }
            }
            curSum = 0;
        }
        return res;
    }
}
