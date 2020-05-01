package leetcode;

public class MergeSort {
	public static void main(String[] args) {
		int [] arr = new int [] {14,7,3,12,9,11,6,2};
		mergeSort(arr, 0, arr.length-1);
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (end + start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		// TODO Auto-generated method stub
		int[] tmp = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			tmp[k++] = arr[i++];
		}
		while (j <= end) {
			tmp[k++] = arr[j++];
		}

		k = 0;
		while (start <= end) {
			arr[start++] = tmp[k++];
		}
	}

}
