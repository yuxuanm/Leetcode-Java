package leetcode;

public class Q31 {
	public static void main(String[] args) {
		int [] nums = new int[] {1,1};
		Q31 q31 = new Q31();
		q31.nextPermutation(nums);
		
	}
	/**from the end of the array, find the index of first position where the current value is
	 * smaller than its next value, if:
	 * 1) there is some turning point, eg: [1,2,5,4,3] index=1, where nums[1]<nums[2] 
	 * 2) there is no turning point, eg: [5,4,3,2,1] just return the reverse array
	 * */
	public void nextPermutation(int[] nums) {
        if(nums.length==1||nums==null)
            return;
        int len = nums.length;
        for(int i=len-2;i>=0;i--){	//situation 1: nums is not the largest, there is some turning point
            if(nums[i]<nums[i+1]){
                returnMinNum(nums,i);
                return;
            }
            if(i==0&&nums[i]>nums[i+1]){ // situation 2: nums is the largest number, return the reverse array
                returnMinNum(nums);
                return;
            }
        }

    }

	/** find the smallest number which is just larger than nums[index]
	 * 	sort the remaining array asc
	 * */
    public void returnMinNum(int [] nums, int index){
        int minDiff=Integer.MAX_VALUE;
        int minIndex=0;
        for(int i=index+1;i<nums.length;i++){//find min start number
            if(minDiff>Math.abs(nums[i]-nums[index])&&nums[i]>nums[index]){
                minIndex=i;
                minDiff=nums[i]-nums[index];
            }
        }
        int tmp=nums[minIndex];
        nums[minIndex]=nums[index];
        nums[index]=tmp;
        sortOf(nums,index);
    }

    public void sortOf(int[] nums, int index){
        for(int i=index+1;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int tmp;
                if(nums[j]<nums[i]){
                    tmp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
    }
    public void returnMinNum(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int tmp=0;
        while(start<end){
            tmp=nums[start];
            nums[start]=nums[end];
            nums[end]=tmp;
            start++;
            end--;
        }
    }
}
