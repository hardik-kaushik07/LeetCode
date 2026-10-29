class Solution {
    public int[] searchRange(int[] arr, int target) {
        int low = 0 , high = arr.length-1;
        if(arr.length == 1 && arr[0]==target) return new int[]{0,0};
         int f = -1 ; int s = -1;
            while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                 f = mid;
                high = mid-1;
               
            }
            else if (arr[mid]<target){
                low = mid+1;
            }
            else{high = mid-1;}
        }
        low = 0 ; high = arr.length-1;
              while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                s=mid;
                 low = mid+1;
                 
            }
            else if (arr[mid]<target){
                low = mid+1;
            }
            else{high = mid-1;}
        }
        return new int[]{f,s};
    }
}