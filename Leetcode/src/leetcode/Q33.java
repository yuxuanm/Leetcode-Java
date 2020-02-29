package leetcode;

public class Q33 {
	//
	// similar to Q81
	//
	public static void main(String[] args) {
		int[] nums = { 4,5,6,7,0,1,2 };
		Q33 q33 = new Q33();
		System.out.println(q33.search(nums, 5));
	}
	
	/**Method 2: binary search(optimazed)
	 * */
	public int search(int[] nums, int target) {
        int start =0;
        int end = nums.length-1;
        int mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]>=nums[start]){
                if(nums[start]<=target&&nums[mid]>target)
                    end=mid-1;
                else
                    start=mid+1;
            }
            
            else{
                if(nums[mid]<target&&nums[end]>=target)
                    start=mid+1;
                else
                    end=mid-1;
            }
        }
        return -1;
    }
	
	
	/**Method 1: binary search
	 * */
//	public int search(int[] nums, int target) {
//		if (nums.length == 1) {
//			if (nums[0] == target)
//				return 0;
//			else
//				return -1;
//		}
//
//		int left = 0;
//		int right = nums.length - 1;
//		while (left < right) {
//			int mid = (right + left) / 2;
//			if (nums[left] == target)
//				return left;
//			if (nums[right] == target)
//				return right;
//			if(nums[mid]==target)
//				return mid;
//			if (nums[mid] > nums[left]) {
//				if (nums[left] <= target && nums[mid] >= target) {
//					right = mid - 1;
//					continue;
//				} else {
//					left = mid + 1;
//					continue;
//				}
//			}
//			if (nums[right] > nums[mid]) {
//				if (nums[mid] <= target && nums[right] >= target) {
//					left = mid + 1;
//					continue;
//				} else {
//					right = mid - 1;
//					continue;
//				}
//			}
//			return -1;
//		}
//		return -1;
//	}
}
