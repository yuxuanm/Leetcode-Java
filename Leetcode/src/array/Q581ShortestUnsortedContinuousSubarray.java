package array;

import java.util.Arrays;

public class Q581ShortestUnsortedContinuousSubarray {

    /**
     * Method 1: sort the array, then compare each position one by one
     * <p>
     * Results: runtime 6ms beats 60.14% memory 39.6mb beats 66.42%
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] copyNums = Arrays.copyOf(nums, nums.length);
        int[] aaa = nums.clone();
        Arrays.sort(copyNums);
        int start = -1;
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != copyNums[i]) {
                start = i;
                break;
            }
        }
        if (start == -1)
            return 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != copyNums[i]) {
                end = i;
                break;
            }
        }
        return end - start + 1;
    }
}
