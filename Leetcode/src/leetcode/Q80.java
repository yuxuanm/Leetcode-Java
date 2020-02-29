package leetcode;

public class Q80 {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		System.out.println(removeDuplicates(nums));
	}

	/**Method 3(From LeetCode):
	 * 
	 * */
	public static int removeDuplicates(int[] nums) {
		int j=1;
		int cnt =1;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]==nums[i-1])
				cnt++;
			else {
				cnt=1;
			}
			if(cnt<=2) 
				nums[j++]=nums[i];
		}
		
		return j;
	}
	
	
	
	/**Method 2: 
	 * if count >2, move all the remaining array forward by 1
	 * */
//	public static int removeDuplicates(int[] nums) {
//		int cnt = 1;
//		int len = nums.length;
//		for (int i = 1; i < len; i++) {
//			if (nums[i] == nums[i - 1])
//				cnt++;
//			if (nums[i] != nums[i - 1]) {
//				cnt = 1;
//			}
//			if (cnt > 2) {
//				remove(nums, i);
//				len--;
//				i--;
//				cnt--;
//			}
//		}
//		return len;
//	}
//
//	private static void remove(int[] nums, int index) {
//		for (int i = index; i < nums.length - 1; i++) {
//			nums[i] = nums[i + 1];
//		}
//	}
	
	
	/**
	 * Method 1: too complicated, not finished yet
	 * 
	 */
//	public static int removeDuplicates(int[] nums) {
//		int cnt = 0;
//		int len = nums.length;
//		outer: for (int i = 0; i < len - 1; i++) {
//			if (i != 0 && nums[i] == nums[i - 1]) {
//				if(i==len-2&&nums[i]!=nums[len-1])
//					cnt++;
//				continue;
//			}
//			for (int j = i + 1; j < len; j++) {
//				if (nums[j] != nums[i] && j - i <= 2) {// no need to change array
//					cnt += (j - i-1);
//					continue outer;
//				}
//				if (nums[j] != nums[i] && j - i > 2) {// need to change the array
//					cnt += (j-i-1);
//					System.arraycopy(nums, j, nums, cnt, len - j);
//					len-=(j-i-2);
//					continue outer;
//				}
//				if (j == len - 1 && nums[j] != nums[i]) {
//					nums[cnt] = nums[j];
//					cnt++;
//				}
//				if(j==len-1&&nums[j]==nums[i]&&j-1<=2) {
//					cnt+=(j-i);
//				}
//				if(j==len-1&&nums[j]==nums[i]&&j-1<=2) {
//					cnt+=2;
//					System.arraycopy(nums, j, nums, cnt, len - j);
//				}
//
//			}
//		}
//		return cnt;
//	}
}
