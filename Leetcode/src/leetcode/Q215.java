package leetcode;

public class Q215 {
	public static void main(String[] args) {
		int [] nums = new int[] {2,1};
		int k =2;
		int res = findKthLargest(nums, k);
		System.out.println(res);
	}
	
	
	/**Method 1: use quick sort, transfer the question equal to find the nth smallest/
	 * */
	public static int findKthLargest(int[] nums, int k) {
        int nthSmallest = nums.length+1-k;
        int index = partitioning(nums);
        if(index == nthSmallest-1)
            return nums[index];
        if(index>nthSmallest-1){
            int [] newarr = new int[index];
            System.arraycopy(nums,0,newarr,0,index);
            return findKthLargest(newarr,k-nums.length+index);
        }
        else{
            int [] newarr = new int[nums.length-index-1];
            System.arraycopy(nums,index+1,newarr,0,nums.length-index-1);
            return findKthLargest(newarr,k);
        }
    }
    
    private static int partitioning(int[] nums){
        int p = nums[0];
        int i = 0;
        int j = nums.length-1;
        int tmp;
        while(i<j){
            while(nums[i]<=p&&i<nums.length-1)
                i++;
            while(nums[j]>p&&j>=0)
                j--;
            tmp = nums[i];
            nums[i]=nums[j];
            nums[j]= tmp;
        }
        tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        
        tmp = nums[0];
        nums[0]=nums[j];
        nums[j]= tmp;
        return j;
    }
}
