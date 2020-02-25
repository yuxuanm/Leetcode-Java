package leetcode;

public class Q75 {
	
	/**Method 2(From Leetcode): one pass
	 * 
	 * */
	public void sortColors(int[] nums) {
        int p0=0, curr =0;
        int p2 = nums.length-1;
        while(curr<=p2){
            if(nums[curr]==2){ // swap nums[curr] and curr[p2]
                int tmp = nums[p2];
                nums[p2]=nums[curr];
                nums[curr]=tmp;
                p2--;
                continue;
            }
            if(nums[curr]==0){ // swap nums[curr] and curr[p0]
                int tmp = nums[p0];
                nums[p0]=0;
                nums[curr]=tmp;
                p0++;
                curr++;
                continue;
            }
            if(nums[curr]==1){
                curr++;
            }
        }
    }
	
	/** Method 1: straight forward, two passes
	 * runtime: 0ms beats 100%
	 * memory: 38.1MB beats 5.18%
	 * */
//	public void sortColors(int[] nums) {
//        int cntZero = 0;
//        int cntOne=0;
//        int cntTwo =0;
//        for(int i:nums){
//            if(i==0)
//                cntZero++;
//            if(i==1)
//                cntOne++;
//            if(i==2)
//                cntTwo++;
//        }
//        
//        Arrays.fill(nums,2);
//        for(int i=0;i<cntZero;i++){
//            nums[i]=0;
//        }
//        for(int i=cntZero;i<cntZero+cntOne;i++){
//            nums[i]=1;
//        }
//    }
}
