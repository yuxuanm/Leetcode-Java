package leetcode;

public class Q11 {
	// Method 1: iterate all the possible combinations
//	public int maxArea(int[] height) {
//		if (height == null)
//			return 0;
//		int maxVol = 0;
//		int curVol;
//
//		for (int i = 0; i < height.length; i++) {
//			for (int j = i + 1; j < height.length; j++) {
//				curVol = Math.abs(i - j) * Math.min(height[i], height[j]);
//				maxVol = curVol > maxVol ? curVol : maxVol;
//			}
//		}
//		return maxVol;
//	}

	//Method 2: two pointers
	public int maxArea(int[] height) {
		if(height == null)
			return 0;
		int start = 0;
		int end = height.length-1;
		int maxVol = 0;
		int curVol;
		
		while(start<end) {
			curVol = Math.abs(start-end)*Math.min(height[start], height[end]);
			maxVol = curVol > maxVol ? curVol : maxVol;
			if(height[start]>height[end])
				end--;
			else
				start++;
		}
		return maxVol;
	}
}
