package array;

public class Q26RemoveDuplicatesfromSortedArray {
	
	/*
	 * Method 1
	 * 
	 * Two pointers, one faster pointer iterate the whole array.
	 * One slow pointer to indicate the current non-dupilicate position.
	 * 
	 * Results: runtime 1ms beats 83.92% memory 40.3mb beats 59.04%.
	 * */
	public int removeDuplicates(int[] nums) {
        if(nums.length==0|| nums.length==1)
            return nums.length;
        int fast = 0; // iterate the whole array
        int slow = 0; // indicate the current position without duplication
        while(fast<=nums.length-1){ // end condition
            if(nums[slow] == nums[fast])
                fast++;
            else
                nums[++slow] = nums[fast];
        }
        return slow+1;
    }
}
