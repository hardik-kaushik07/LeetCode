class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
    public void mergeSort(int[] nums){
        int n = nums.length;
        if(n<=1){
            return;
        }
    int mid = n/2;

    int[] a = new int[mid];
    int[] b = new int[nums.length - mid];
    int idx = 0;
   for(int  i = 0; i < a.length; i++){
    a[i] = nums[idx++];
   }
   for(int i = 0; i < b.length; i++){
    b[i] = nums[idx++];
   }

   mergeSort(a);
   mergeSort(b);

   merge(nums, a, b);
        
    }

    public void merge(int[] ans, int[] left, int[] right) {

        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {

            if (left[i] <= right[j])
                ans[k++] = left[i++];
            else
                ans[k++] = right[j++];
        }

        while (i < left.length)
            ans[k++] = left[i++];

        while (j < right.length)
            ans[k++] = right[j++];

    }
}