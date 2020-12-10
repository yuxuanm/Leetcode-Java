package array;

public class Q11ContainerWithMostWater {

	/*
	 * Method 1:
	 * 
	 * Two Pointers: One starts from the left boundary, the other starts from
	 * the right boundary. At each iteration, move the pointer with smaller
	 * height towards the other. Time complexity is O(n).
	 * 
	 * Results: runtime: 3 ms beats 92.53% 
	 * 			memory: 40 mb beats 33.59%
	 * 
	 */
	public int maxArea(int[] height) {
		int res = 0;
		int left = 0;
		int right = height.length - 1;
		while (left <= right) {
			res = (right - left) * Math.min(height[left], height[right]) > res
					? (right - left) * Math.min(height[left], height[right]) : res;
			if (height[left] >= height[right])
				right--;
			else
				left++;
		}
		return res;
	}
}
