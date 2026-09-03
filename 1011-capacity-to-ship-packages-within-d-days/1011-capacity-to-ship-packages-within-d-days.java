class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        for(int ele: arr){
            maxi = Math.max(maxi, ele);
        }
        return binarySearch(arr, days, maxi, sum);
    }
    public int binarySearch(int[] arr, int days, int low, int high){
        while(low<=high){
            int mid = low + (high-low)/2;
            if(checkDays(arr, mid)<=days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    } 
    public int checkDays(int[] arr, int mid){
        int days = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] + sum <= mid){
                sum += arr[i];
            }
            else{
                days++;
                sum = arr[i];
            }
        }
        return days;
    }
}