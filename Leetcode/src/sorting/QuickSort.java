package sorting;

public class QuickSort {
    public void sort(int[] arr){
        quickSort(arr, 0, arr.length -1);

    }

    private void quickSort(int[] arr, int left, int right) {
        if(left<right){
            int index = partition(arr, left, right);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot +1;
        for(int i = index; i<=right; i++){
            if(arr[i]<arr[pivot]){
                swap(arr, i, index++);
            }
        }
        swap(arr, pivot, index-1);
        return index-1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] arr = new int [] {5,3,9,16,2,7};
        quickSort.sort(arr);
        System.out.println(arr.toString());
    }
}
