class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    public int mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(arr, low, mid);

        count += mergeSort(arr, mid + 1, high);

        count += count(arr, low, mid, high);

        merge(arr, low, mid, high);

        return count;
    }

    public int count(int[] arr, int low, int mid, int high){
        int count = 0;
        int right = mid+1;
        for(int i = low; i <= mid; i++){
            while(right<=high && arr[i]>2L *arr[right]){
                right++;
            }
            count += (right-(mid+1));
        }
        return count;
    } 
    public void merge(int[] arr, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {

            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
}