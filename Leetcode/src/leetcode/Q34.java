package leetcode;

public class Q34 {
	public static void main(String[] args) {
		int [] nums = {1,4};
		Q34 q34 = new Q34();
		int [] res =
		q34.searchRange(nums, 4);
	}
	public int[] searchRange(int[] nums, int target) {
		if(nums.length==0)
			return new int [] {-1,-1};
		if(nums.length==1) {
			if(nums[0]==target)
				return new int [] {0,0};
			return new int [] {-1,-1};
		}
        int left=0;
        int right = nums.length-1;
        int mid;
        int index=-1;
        //find whether target exists in the array or not
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target) {
            	index=mid;
            	break;
            }
            if(nums[mid]>target){
                right=mid-1;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
        }
        left=right =index;
        int start=-1;
        int end=-1;
        
        //find left boundary and right boundary.
        if(index!=-1){
            while(nums[left]==target&&left>=0){
            	if(left==0) {
            		start=0;
            		break;
            	}
            	start=left;
            	left--;
            }
            while(nums[right]==target&&right<=nums.length-1){
            	if(right==nums.length-1) {
            		end=nums.length-1;
            		break;
            	}
            	end = right;
            	right++;
            }
            return new int [] {start,end};
        }
        return new int[]{-1,-1};
    }
}
