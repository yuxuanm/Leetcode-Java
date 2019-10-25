package leetcode;

public class Java189 {
	public static void main(String[] args) {
		Java189 j189 = new Java189();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		j189.rotate(nums, k);
		System.out.println(nums[1]);
	}

	public void rotate1(int[] nums, int k) {
		while(k>nums.length)
			k=k-nums.length;
		int len = nums.length;
		int[] newNums = new int[len];
		for (int i = 0; i < k; i++) {
				newNums[i] = nums[len-k+i];
		}

		System.arraycopy(nums, 0, newNums, k, len - k);

		for(int i = 0;i<len;i++){
			nums[i]=newNums[i];
		}
	}
	
	public void rotate2(int[] nums, int k) {
		int a [] = new int [ nums.length];
		for(int i=0;i<nums.length;i++) {
			a[i]=nums[(i+nums.length-k)%nums.length];
		}
		for(int i=0;i<nums.length;i++)
			nums[i]=a[i];
	}
	
	public void rotate(int[] nums, int k) {
		reverse(nums, 0, nums.length-1);
		reverse(nums,0,k-1);
		reverse(nums,k,nums.length-1);
	}
	
	public void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int tmp=nums[start];
			nums[start]=nums[end];
			nums[end]=tmp;
			start++;
			end--;
		}
	}
}
